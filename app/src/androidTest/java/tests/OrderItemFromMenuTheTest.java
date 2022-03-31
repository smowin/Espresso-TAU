package tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import pageobject.CustomOrderScreen;
import pageobject.MenuScreen;
import pageobject.OnboardingScreen;
import utils.IE2ETest;

@RunWith(AndroidJUnit4.class)
public class OrderItemFromMenuTheTest extends TestBase {

    private OnboardingScreen onboardingScreen = new OnboardingScreen();
    private CustomOrderScreen customOrderScreen = new CustomOrderScreen();
    private MenuScreen menuScreen = new MenuScreen();

    @Test
    @IE2ETest
    @SmallTest
    public void shouldBeAbleToSelectAnItemInTheMenu() {
        onboardingScreen.closeOnboardingScreen();
        customOrderScreen.clickMenuButton();
        menuScreen.scrollToMenuItem("CAPPUCCINO", "Cappuccino");

    }
}
