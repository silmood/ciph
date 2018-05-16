package com.silmood.ciph;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.appflate.restmock.RESTMockServer;
import io.appflate.restmock.android.RESTMockTestRunner;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static io.appflate.restmock.utils.RequestMatchers.pathContains;
import static io.appflate.restmock.utils.RequestMatchers.hasQueryParameterNames;
import static org.hamcrest.Matchers.allOf;

public class CipherTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class, true, false);


    @Test
    public void cipherRot13SimpleText() {
        // Type Message to cipher
        onView(withHint("Message")).perform(typeText("Hello World"));

        //Click cipher button
        onView(withText("CIPHER")).perform(click());

        //Check Rot 13 output
        onView(withText("Uryyb Jbeyq")).check(matches(isDisplayed()));
    }
}
