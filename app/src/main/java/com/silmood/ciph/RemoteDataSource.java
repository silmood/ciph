package com.silmood.ciph;


public interface RemoteDataSource {

    void cipher(String message, Callback callback);

    interface Callback {
        void onSuccess(String result);
        void onError(Exception e);
    }
}
