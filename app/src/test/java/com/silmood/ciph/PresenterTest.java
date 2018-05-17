package com.silmood.ciph;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class PresenterTest {

    @Mock
    CipherView view;

    @Mock
    DataSource source;

    @Captor
    ArgumentCaptor<DataSource.Callback> captor;

    CipherPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new CipherPresenter(view, source);
    }

    @Test
    public void presenterShowsResult_valid() {
        presenter.cipher("Hello World");

        verify(source).cipher(eq("Hello World"),
                captor.capture());

        captor.getValue().onSuccess("Uryyb Jbeyq");
        verify(view).showResult("Uryyb Jbeyq");
    }

}
