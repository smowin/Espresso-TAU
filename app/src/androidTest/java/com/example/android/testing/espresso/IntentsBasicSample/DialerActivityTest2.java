package com.example.android.testing.espresso.IntentsBasicSample;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DialerActivityTest2 {

    private static final String PHONE_NUMBER = "123-456-7891";
    private static final Uri INTENDED_PHONE_NUMBER = Uri.parse("tel:" + PHONE_NUMBER);

    @Rule
    public IntentsTestRule<DialerActivity> dialerActivityIntentsTestRule =
            new IntentsTestRule<>(DialerActivity.class);

    @Before
    public void stubAllExternalIntents() {
        intending(not(isInternal()))
                .respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    @Test
    public void callTypeNumberTest() {
        onView(withId(R.id.edit_text_caller_number))
                .perform(typeText(PHONE_NUMBER));
        closeSoftKeyboard();
        onView(withId(R.id.button_call_number))
                .perform(click());

        intended(allOf(
                    hasAction(Intent.ACTION_CALL),
                    hasData(INTENDED_PHONE_NUMBER)
                )
        );
    }
}
