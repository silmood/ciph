package com.silmood.ciph;

import com.silmood.ciph.RemoteDataSource;

public class RemoteDataSourceImpl implements RemoteDataSource {
    @Override
    public void cipher(String message, Callback callback) {
        String result = Cipher.rot13(message);
        callback.onSuccess(result);
    }
}
