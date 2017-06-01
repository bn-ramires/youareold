package com.example.fujiwara.youareold

import android.annotation.TargetApi
import android.icu.text.NumberFormat
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Populating spinner with all the available months to be chosen
        val adapter = ArrayAdapter.createFromResource(
                this, R.array.months, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        month_spinner.adapter = adapter
        month_spinner.setSelection(4)


        calculate_button.setOnClickListener {

            // Getting user's year of birth
            val year: Int = input_year.text.toString().toInt()

            // Getting user's day of birth
            val day: Int = input_day.text.toString().toInt()

            // Getting user's month of birth
            val month: Int = month_spinner.selectedItemPosition + 1

            // Creating an instance of the user
            var user = User()

            // Setting user's birth date
            user.setBirthDate(year, month, day)

            // If user's birth date was not set in the future, proceed.
            if (!user.isFromTheFuture) {

                val result = """
Years lived: ${NumberFormat.getNumberInstance().format(user.getYearsLived())}
Months lived: ${NumberFormat.getNumberInstance().format(user.getMonthsLived())}
Weeks lived: ${NumberFormat.getNumberInstance().format(user.getWeeksLived())}
Days lived: ${NumberFormat.getNumberInstance().format(user.getDaysLived())}
Hours lived: ${NumberFormat.getNumberInstance().format(user.getHoursLived())}
Minutes lived: ${NumberFormat.getNumberInstance().format(user.getMinutesLived())}
Seconds lived: ${NumberFormat.getNumberInstance().format(user.getSecondsLived())}"""

                result_textview.text = result
                println(result)

                // Otherwise, display error message.
            } else {
                Toast.makeText(applicationContext,
                        R.string.cannot_be_born_in_the_future, Toast.LENGTH_LONG).show()
            }
        }
    }
}