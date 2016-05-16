package math.sevakkalpesh.com.viewrangercodetest;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import math.sevakkalpesh.com.viewrangercodetest.view.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * Created by kalpesh on 16/05/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {


    private Intent mIntent;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class,
            true,     // initialTouchMode
            false);   // launchActivity. False so we can customize the intent per test method

    @Before
    public void setUp(){
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        Context context = instrumentation.getTargetContext();
        mIntent = new Intent(context, MainActivity.class);
    }

    @Test
    public void preConditions() throws InterruptedException {
        activityRule.launchActivity(mIntent);
        // Check view existence
        onView(withId(R.id.toolbar)).check(matches(anything()));
        onView(withId(R.id.fab)).check(matches(anything()));
        onView(withId(R.id.etInput)).check(matches(anything()));
        onView(withId(R.id.tvResult)).check(matches(anything()));
        onView(withId(R.id.tvCalculation)).check(matches(anything()));

    }

    @Test
    public void ensureTextChangesWork() throws InterruptedException{
        activityRule.launchActivity(mIntent);
        // Type text and then press the button.
        onView(withId(R.id.etInput))
                .perform(typeText("4*3+1"), closeSoftKeyboard());
        onView(withContentDescription("FAB")).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.tvResult)).check(matches(withText("13")));
    }

}


