package com.silmood.ciph;


import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class RoboelectricMainActivityTest {

    MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void messageEmpty_showError() {
        activity.findViewById(R.id.btn_cipher).performClick();

        String error = ((EditText) activity.findViewById(R.id.input_message))
                .getError().toString();

        assertNotNull(error);
        assertFalse(error.isEmpty());
    }
}
