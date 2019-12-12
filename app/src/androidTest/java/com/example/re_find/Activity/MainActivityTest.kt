package com.example.re_find.Activity

import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.re_find.Adapter.PostViewHolder
import com.example.re_find.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun launchAppTest() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun urlActivityIntentTest() {

        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.subredditSearchEditText))
            .perform(typeText("basketball"))
        onView(withId(R.id.submitBtn))
            .perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.postRecyclerView))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        Thread.sleep(2000)
        onView(withId(R.id.urlTxt))
            .check(matches(ViewMatchers.isDisplayed()))

    }
}