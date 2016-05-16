package math.sevakkalpesh.com.viewrangercodetest;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.robotium.solo.Solo;

import math.sevakkalpesh.com.viewrangercodetest.view.MainActivity;

/**
 * Created by kalpesh on 16/05/2016.
 */
public class MainActivityRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;
    View fab;
    public MainActivityRobotiumTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
         fab = getActivity().findViewById(R.id.fab);

    }

    public void testCase1() {

        //Defining our own values to multiply
        //Access First value (edit-filed) and putting firstNumber value in it
        solo.enterText(0, "4+5*2");

        //Click on FAB button

        solo.clickOnView(fab);

        assertTrue(solo.searchText("14"));
    }

    public void testCase2() {

        solo.enterText(0,"4+5/2");

        //Click on FAB button
        solo.clickOnView(fab);

        assertTrue(solo.searchText("6.5"));
    }

    public void testCase3() {

        solo.enterText(0,"4+5/2-1");

        //Click on FAB button

        solo.clickOnView(fab);

        assertTrue(solo.searchText("5.5"));
    }

    public void testFail() {

        solo.enterText(0,"4+5/4-1");

        //Click on FAB button

        solo.clickOnView(fab);

        assertTrue(solo.searchText("8"));
    }

    @Override
    protected void tearDown() throws Exception {

        solo.finishOpenedActivities();
    }
}