package com.example.fujiwara.youareold;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner monthsSpinner;
    EditText inputYear;
    EditText inputDay;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Populating spinner with all the available months to be chosen
        monthsSpinner = (Spinner) findViewById(R.id.input_month);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.months, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthsSpinner.setAdapter(adapter);
        monthsSpinner.setSelection(4);

        // Finding the result TextView
        resultTextView = (TextView) findViewById(R.id.result_textview);

        // Finding the field with the year
        inputYear = (EditText) findViewById(R.id.input_year);

        // Finding the field with the year
        inputDay = (EditText) findViewById(R.id.input_day);
    }

    public void calculate(View view) {

        // Getting user's year of birth
        int year = Integer.parseInt(inputYear.getText().toString());

        // Getting user's day of birth
        int day = Integer.parseInt(inputDay.getText().toString());

        // Getting user's month of birth
        int month = monthsSpinner.getSelectedItemPosition() + 1;

        // Creating an instance of the user
        User user = new User();

        // Setting user's birth date
        user.setBirthDate(year, month, day);

        // If user's birth date was not set in the future, proceed.
        if (!user.isFromTheFuture) {

            String result =
                    "Years lived: " + NumberFormat.getNumberInstance().format(user.getYearsLived()) +
                            "\nMonths lived: " + NumberFormat.getNumberInstance()
                            .format(user.getMonthsLived()) +
                            "\nWeeks lived: " + NumberFormat.getNumberInstance()
                            .format(user.getWeeksLived()) +
                            "\nDays lived: " + NumberFormat.getNumberInstance()
                            .format(user.getDaysLived()) +
                            "\nHours lived: " + NumberFormat.getNumberInstance()
                            .format(user.getHoursLived()) +
                            "\nMinutes lived: " + NumberFormat.getNumberInstance()
                            .format(user.getMinutesLived());
//                            "\nSeconds lived: " + String.valueOf(user.getSecondsLived());

            resultTextView.setText(result);
            System.out.println(result);

            // Otherwise, display error message.
        } else {
            Toast.makeText(getApplicationContext(),
                    R.string.cannot_be_born_in_the_future, Toast.LENGTH_LONG).show();
        }
    }
}
