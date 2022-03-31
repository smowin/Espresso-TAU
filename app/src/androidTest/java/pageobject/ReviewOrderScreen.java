package pageobject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;

import android.content.Intent;

import nl.testchamber.mailordercoffeeshop.R;

public class ReviewOrderScreen {

    private final int nameTextBox = R.id.name_text_box;
    private final int customOrderNameBox = R.id.custom_order_name_box;
    private final int mailOrderButton = R.id.mail_order_button;
    private final int beverageDetailIngredients = R.id.beverage_detail_ingredients;

    public void reviewOrder(String name, String orderTitle) {
        onView(withId(nameTextBox)).perform(scrollTo(), typeText(name));
        onView(withId(customOrderNameBox)).perform(scrollTo(), typeText(orderTitle));
        onView(withId(mailOrderButton)).perform(scrollTo(), click());

        intended(allOf(
                hasAction(equalTo(Intent.ACTION_SENDTO)),
                hasExtra(Intent.EXTRA_SUBJECT, "Order: " + name + " – " + orderTitle + " ")));
    }

    public void checkIngredients(int count) {
        onView(withId(beverageDetailIngredients)).check(matches(withText(" " + count + " ")));
    }
}
