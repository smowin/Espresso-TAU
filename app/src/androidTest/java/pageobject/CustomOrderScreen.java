package pageobject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import nl.testchamber.mailordercoffeeshop.R;

public class CustomOrderScreen {

    private final String increaseButton = "+";
    private final String decreaseButton = "-";

    private final int chocolateCheck = R.id.chocolate;
    private final int reviewOrderButton = R.string.review_order_button;
    private final int menuButton = R.id.use_menu;

    public void createCustomOrder(int itemNumber) {
        for (int i = 0; i < itemNumber; i++) {
            onView(withText(increaseButton)).perform(click());
        }
        onView(withText(decreaseButton)).perform(click());
        onView(withId(chocolateCheck)).perform(click());
        onView(withText(reviewOrderButton)).perform(click());
    }

    public void clickMenuButton() {
        onView(withId(menuButton)).perform(click());
    }
}
