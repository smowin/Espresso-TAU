package com.tau.drawersampleapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isOpen;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DrawerActivityTest2 {

    private final int DRAWER_ID = R.id.drawer_layout;

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void openDrawerActivityTest() {
        // Open Drawer
        // Click on Gallery
        // Assert Gallery Activity is displayed
        // Open Drawer
        // Click Home
        // Close Drawer

        onView(withId(DRAWER_ID))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withText("Gallery")).perform(click());
        onView(withId(R.id.text_gallery))
                .check(matches(withText("This is gallery fragment")))
                .check(matches(isDisplayed()));

        onView(withId(DRAWER_ID))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withText("Home")).perform(click());
        onView(withId(R.id.text_home))
                .check(matches(withText("This is home fragment")))
                .check(matches(isDisplayed()));

    }
}
