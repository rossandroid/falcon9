package morg.ros.falconapp

import android.os.SystemClock
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import morg.ros.falconapp.presenter.MainPresenter

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    var mactivity: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Rule @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun shouldDisplaySpinner() {

        onView(withId(R.id.spinner)).check(matches(isDisplayed()));

    }

    fun shoudlDisplayRecicleView() {

        SystemClock.sleep(10000);
        onView(withId(R.id.recycleView)).check(matches(isDisplayed()));

    }
}
