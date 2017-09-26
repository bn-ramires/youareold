package com.example.fujiwara.youareold

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        years_result.text = User.getYearsLived().toString()
        months_result.text = User.getMonthsLived().toString()
        weeks_result.text = User.getWeeksLived().toString()
        days_result.text = User.getDaysLived().toString()
        hours_result.text = User.getHoursLived().toString()
        minutes_result.text = User.getMinutesLived().toString()
        seconds_result.text = User.getSecondsLived().toString()
        println(years_textview.text)
        println(months_textview.text)
        println(days_textview.text)
        println(years_textview.textSize)
    }
}
