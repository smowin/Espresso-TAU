package pageobject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import nl.testchamber.mailordercoffeeshop.R;

public class MenuScreen {

    private final int beverageRecyclerView = R.id.beverage_recycler_view;
    private final int beverageDetailTitle = R.id.beverage_detail_title;



    public void scrollToMenuItem(String item, String itemTitle) {
        onView(withId(beverageRecyclerView))
                .perform(actionOnItem(hasDescendant(withText(item)), click()));

        onView(withId(beverageDetailTitle))
                .check(matches(withText(itemTitle)));
    }
}
