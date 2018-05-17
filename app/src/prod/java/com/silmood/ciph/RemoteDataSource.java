package com.silmood.ciph;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by silmood on 5/16/18.
 */

public class RemoteDataSource implements DataSource {

    @Override
    public void cipher(String message, final Callback callback) {
        OkHttpClient client = new OkHttpClient();

        String url = "http://localhost:4000/cipher";
        Request request = getCipherRequest(message, url);

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
                .get()
                .url(url)
                .build();
    }
}
