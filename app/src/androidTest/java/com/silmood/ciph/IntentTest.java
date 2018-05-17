package com.silmood.ciph;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasType;
import static org.hamcrest.Matchers.allOf;


@RunWith(AndroidJUnit4.class)
public class IntentTest {


    @Rule
    public IntentsTestRule<MainActivity> mActivityRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void userCanShareMessage() {
        onView(ViewMatchers.withId(R.id.share)).perform(click());

        intended(allOf(
                hasAction(Intent.ACTION_SEND),
                hasExtraWithKey(Intent.EXTRA_TEXT),
                hasType("text/plain")
        ));
    }
}
