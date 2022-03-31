package tests;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import pageobject.CustomOrderScreen;
import pageobject.OnboardingScreen;
import pageobject.ReviewOrderScreen;
import utils.ISmokeTest;

@RunWith(AndroidJUnit4.class)
public class CreateCustomOderWithIngredientsTest extends TestBase {

    private OnboardingScreen onboardingScreen = new OnboardingScreen();
    private CustomOrderScreen customOrderScreen = new CustomOrderScreen();
    private ReviewOrderScreen reviewOrderScreen = new ReviewOrderScreen();

    @Test
    @ISmokeTest
    public void orderOverViewShouldDisplayedIngredients() {
        onboardingScreen.closeOnboardingScreen();
        customOrderScreen.createCustomOrder(4);
        reviewOrderScreen.checkIngredients(3);
    }
}
