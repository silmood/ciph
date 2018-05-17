package com.silmood.ciph;

/**
 * Created by silmood on 5/16/18.
 */

public class CipherPresenter {

    private CipherView view;
    private DataSource source;

    public CipherPresenter(CipherView view, DataSource source) {
        this.view = view;
        this.source = source;
    }

    public void cipher(String message) {
        source.cipher(message, new DataSource.Callback() {
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
