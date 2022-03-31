package pageobject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import nl.testchamber.mailordercoffeeshop.R;

public class OnboardingScreen {

    private final int closeButton = R.id.close_button;

    public void closeOnboardingScreen() {
        onView(withId(closeButton)).perform(click());
    }
}
