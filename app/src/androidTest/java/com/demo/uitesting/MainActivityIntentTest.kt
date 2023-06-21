package com.demo.uitesting

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityIntentTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun testIntent() {
        Espresso.onView(withId(R.id.btn_next)).perform(ViewActions.click())
        intended(hasComponent(HomeActivity::class.java.name))
    }

    @Test
    fun testIntentData() {
        Espresso.onView(withId(R.id.btn_next)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.txt_name)).check(matches(withText("Bhavish")))
    }
}