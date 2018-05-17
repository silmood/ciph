package com.silmood.ciph;


import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static junit.framework.Assert.assertEquals;

public class DataSourceTest {

    MockWebServer server;
    RemoteDataSource source;

    @Before
    public void setup() throws IOException {
        source = new RemoteDataSource();
        server = new MockWebServer();
        server.start();
    }

    @Test
    public void cipherRequest_isValid() throws IOException, InterruptedException {
        MockResponse response = new MockResponse()
                .setResponseCode(200)
                .setBody("{}");

        server.enqueue(response);

        String url = server.url("/cipher").toString();
        OkHttpClient client = new OkHttpClient();

        Request cipherRequest = source.getCipherRequest(
                "Hello World", url);

        client.newCall(cipherRequest).execute();

        RecordedRequest request = server.takeRequest();

        assertEquals("/cipher?msg=Hello%20World", request.getPath());
    }
}
