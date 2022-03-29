package com.example.android.testing.espresso.DataAdapterSample;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LongListActivityTest2 {

    private static final String itemText = "item: 30";
    private static final String selectedItemText = "30";
    private static final String lastItemID = "item: 99";

    @Rule
    public ActivityScenarioRule<LongListActivity> longListActivityActivityScenarioRule =
            new ActivityScenarioRule<>(LongListActivity.class);

    @Test
    public void lastItemNotDisplayedTest() {
        onView(withText(lastItemID)).check(doesNotExist());
    }

    @Test
    public void scrollToLastItemTest() {
        onData(hasEntry(equalTo(LongListActivity.ROW_TEXT), is(lastItemID)))
        .check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void clickOnRowAndCheckTest() {
        onData(hasEntry(equalTo(LongListActivity.ROW_TEXT), is(itemText)))
                .onChildView(withId(R.id.rowContentTextView))
                .perform(click());

        onView(withId(R.id.selection_row_value))
                .check(matches(withText(selectedItemText)));
    }

    @Test
    public void clickToggleButtonTest() {
        DataInteraction dataInteraction = onData(hasEntry(equalTo(LongListActivity.ROW_TEXT), is(itemText)))
                .onChildView(withId(R.id.rowToggleButton));
        dataInteraction.check(matches(isNotChecked()));

        ViewInteraction perform = dataInteraction.perform(click());
        perform.check(matches(isChecked()));
    }
}
