package com.silmood.ciph;


public class CipherPresenter {
    private RemoteDataSource dataSource;
    private CipherView view;

    public CipherPresenter(RemoteDataSource dataSource, CipherView view) {
        this.dataSource = dataSource;
        this.view = view;
    }

    public void cipher(String message) {
        dataSource.cipher(message, new RemoteDataSource.Callback() {
            @Override
            public void onSuccess(String result) {
                view.showResult(result);
            }

            @Override
            public void onError(Exception e) {
                view.showError(e.getMessage());
            }
        });
    }
}
