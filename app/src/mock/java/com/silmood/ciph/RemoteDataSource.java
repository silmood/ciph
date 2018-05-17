package com.silmood.ciph;

/**
 * Created by silmood on 5/16/18.
 */

public class RemoteDataSource implements DataSource{
    @Override
    public void cipher(String message, Callback callback) {
       String result = Cipher.rot13(message);
       callback.onSuccess(result);
    }
}
