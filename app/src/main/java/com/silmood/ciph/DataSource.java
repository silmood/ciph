package com.silmood.ciph;


public interface DataSource {

    void cipher(String message, Callback callback);

   public interface Callback {
       void onSuccess(String result);
       void onError(Exception e);
   }
}
