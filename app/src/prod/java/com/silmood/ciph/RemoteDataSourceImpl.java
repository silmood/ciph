package com.silmood.ciph;

import java.io.IOException;
import java.net.URI;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RemoteDataSourceImpl implements RemoteDataSource {
    public static final String URL = "http://localhost:4000/cipher";

    @Override
    public void cipher(String message, final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = getCipherRequest(message, URL);

        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });
    }

    public Request getCipherRequest(String message, String urlBase) {
        String url = urlBase + "?msg=" + message;

        return new Request.Builder()
                .url(url)
                .get()
                .build();
    }
}
