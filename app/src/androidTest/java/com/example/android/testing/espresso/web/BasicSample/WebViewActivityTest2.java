package com.example.android.testing.espresso.web.BasicSample;

import static androidx.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static androidx.test.espresso.web.sugar.Web.onWebView;
import static androidx.test.espresso.web.webdriver.DriverAtoms.clearElement;
import static androidx.test.espresso.web.webdriver.DriverAtoms.findElement;
import static androidx.test.espresso.web.webdriver.DriverAtoms.getText;
import static androidx.test.espresso.web.webdriver.DriverAtoms.webClick;
import static androidx.test.espresso.web.webdriver.DriverAtoms.webKeys;

import static org.hamcrest.Matchers.containsString;

import android.content.Intent;

import androidx.test.espresso.web.webdriver.Locator;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class WebViewActivityTest2 {

    private static final String text = "Test_TAU";

    @Rule
    public ActivityTestRule<WebViewActivity> webViewActivityActivityScenarioRule =
            new ActivityTestRule<WebViewActivity>(WebViewActivity.class, false, false) {
        @Override
        protected void afterActivityLaunched() {
            onWebView().forceJavascriptEnabled();
        }
    };

    @Test
    public void typeTextSubmitFormTest() {
        Intent webFormIntent = new Intent();
        webViewActivityActivityScenarioRule.launchActivity(webFormIntent);

        onWebView()
                .withElement(findElement(Locator.ID, "text_input"))
                .perform(clearElement())
                .perform(webKeys(text));
        onWebView()
                .withElement(findElement(Locator.ID, "submitBtn"))
                .perform(webClick());
        onWebView()
                .withElement(findElement(Locator.ID, "response"))
                .check(webMatches(getText(), containsString(text)));
    }
}
