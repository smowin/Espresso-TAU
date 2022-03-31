package tests;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import pageobject.CustomOrderScreen;
import pageobject.OnboardingScreen;
import pageobject.ReviewOrderScreen;

@RunWith(AndroidJUnit4.class)
public class SendOrderToEmailTest extends TestBase {

    private OnboardingScreen onboardingScreen = new OnboardingScreen();
    private CustomOrderScreen customOrderScreen = new CustomOrderScreen();
    private ReviewOrderScreen reviewOrderScreen = new ReviewOrderScreen();

    @Test
    public void shouldSendAnIntentContainingTheRightOrderDetails() {
        onboardingScreen.closeOnboardingScreen();
        customOrderScreen.createCustomOrder(4);
        reviewOrderScreen.reviewOrder("Moataz", "TAU Test");
    }
}
