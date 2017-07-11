package com.example.fujiwara.youareold

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val mainActivity = MainActivity()
        years_result.setText(mainActivity.user.getYearsLived())
    }
}
