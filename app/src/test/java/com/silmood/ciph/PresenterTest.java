package com.silmood.ciph;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class PresenterTest {

    @Mock
    CipherView view;

    @Mock
    RemoteDataSource dataSource;

    @Captor
    private ArgumentCaptor<RemoteDataSource.Callback> callback;

    CipherPresenter presenter;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        presenter = new CipherPresenter(dataSource, view);
    }

    @Test
    public void cipherText_showResult() {
        presenter.cipher("Hello World");

        verify(dataSource).cipher(eq("Hello World"), callback.capture());
        callback.getValue().onSuccess("Uryyb Jbeyq");

        InOrder order = Mockito.inOrder(view);
        order.verify(view).showResult("Uryyb Jbeyq");
    }

}
