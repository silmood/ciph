package com.silmood.ciph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static junit.framework.Assert.assertEquals;


public class DataSourceTest {

    RemoteDataSourceImpl dataSource;
    MockWebServer server;
    OkHttpClient client;

    @Before
    public void setUp() throws IOException {
        dataSource = new RemoteDataSourceImpl();
        server = new MockWebServer();
        client = new OkHttpClient();

        server.start();
    }

    @Test
    public void remoteCipher_validRequest() throws InterruptedException, IOException{
        MockResponse mockReponse = new MockResponse()
                .setResponseCode(200)
                .setBody("{}");

        server.enqueue(mockReponse);

        String url = server.url("/cipher").toString();

        Request request = dataSource.getCipherRequest("Hello World", url);
        client.newCall(request).execute();

        RecordedRequest recordedRequest = server.takeRequest();

        assertEquals("/cipher?msg=Hello%20World", recordedRequest.getPath());
    }

    @After
    public void tearDown() throws IOException {
        server.shutdown();
    }
}
