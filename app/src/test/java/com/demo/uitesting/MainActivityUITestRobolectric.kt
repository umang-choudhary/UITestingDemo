package com.demo.uitesting

import android.app.Activity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.shadows.ShadowActivity
import org.robolectric.shadows.ShadowIntent


@RunWith(RobolectricTestRunner::class)
class MainActivityUITestRobolectric {

    private lateinit var mainActivity: Activity

    @Before
    fun setup() {
        mainActivity = Robolectric.buildActivity(MainActivity::class.java).create().get()
    }

    @Test
    fun testEditTextChange() {
        val edtTextName = mainActivity.findViewById(R.id.edt_name) as EditText
        edtTextName.setText("Duggu")

        val btnChangeText = mainActivity.findViewById(R.id.btn_change_text) as Button

        btnChangeText.performClick()
        assertThat(edtTextName.text.toString(), equalTo("Hello Guys"))
    }

    @Test
    fun testTextMsg() {
        val btnChangeText = mainActivity.findViewById(R.id.btn_change_text) as Button
        btnChangeText.performClick()
        val txtMsg = mainActivity.findViewById(R.id.txt_msg) as TextView

        assertThat(txtMsg.text.toString(), equalTo("Msg Updated"))
    }

    @Test
    fun testIntent() {
        val button = mainActivity.findViewById<View>(R.id.btn_next) as Button
        button.performClick()

        val shadowActivity: ShadowActivity = shadowOf(mainActivity)
        val startedIntent = shadowActivity.nextStartedActivity
        val shadowIntent: ShadowIntent = shadowOf(startedIntent)
        assertThat(shadowIntent.intentClass.name, equalTo(HomeActivity::class.java.name))
    }

}