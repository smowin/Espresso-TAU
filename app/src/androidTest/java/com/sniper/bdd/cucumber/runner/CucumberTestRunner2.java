package com.sniper.bdd.cucumber.runner;

import android.os.Bundle;

import cucumber.api.android.CucumberAndroidJUnitRunner;
import io.cucumber.android.BuildConfig;

public class CucumberTestRunner2 extends CucumberAndroidJUnitRunner {

    private static final String CUCUMBER_TAGS_KEYS = "tags";
    private static final String CUCUMBER_SCENARIO_KEY = "name";

    @Override
    public void onCreate(Bundle bundle) {
        String tags = BuildConfig.TEST_TAGS;
        String scenario = BuildConfig.TEST_SCENARIO;
        super.onCreate(bundle);
    }
}
