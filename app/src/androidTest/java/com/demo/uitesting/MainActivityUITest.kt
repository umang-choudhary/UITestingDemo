package com.demo.uitesting

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testEditTextChange() {
        Espresso.onView(withId(R.id.edt_name))
            .perform(ViewActions.typeText("Duggu"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.btn_change_text)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.edt_name)).check(matches(withText("Hello Guys")))
    }

    @Test
    fun testTextMsg() {
        Espresso.onView(withId(R.id.btn_change_text)).perform(ViewActions.click())
        Espresso.onView(withText("Msg Updated")).check(matches(isDisplayed()))
    }

}