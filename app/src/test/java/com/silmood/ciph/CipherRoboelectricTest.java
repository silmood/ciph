package com.silmood.ciph;


import android.widget.Button;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class CipherRoboelectricTest {

    private MainActivity mainActivity;

    @Before
    public void setup() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void whenMessageInputIsEmpty_showError() {
        Button button = mainActivity.findViewById(R.id.btn_cipher);
        button.performClick();

        TextView input = mainActivity.findViewById(R.id.input_message);

        Assert.assertNotNull("Input doesn't show message", input.getError());
    }

}
