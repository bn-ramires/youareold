package com.example.fujiwara.youareold;

import android.support.v7.app.AppCompatActivity;

import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Weeks;
import org.joda.time.Years;

public class User extends AppCompatActivity {

    static LocalDate birthDate = new LocalDate();
    static LocalDate currentDate = new LocalDate();

    static boolean isFromTheFuture;

    static int daysLived;
    static int yearsLived;
    static int monthsLived;
    static int weeksLived;
    static String secondsLived;
    static int minutesLived;
    static int hoursLived;

    public User() {
    }

    public static void setBirthDate(int year, int month, int day) {

        LocalDate userInput = new LocalDate(year, month, day);
        isFromTheFuture = userInput.isAfter(currentDate);
        birthDate = userInput;
    }

    public static int getDaysLived() {
        return daysLived =
                Days.daysBetween(birthDate, currentDate).getDays();
    }

    public static LocalDate getBirthDate() {
        return birthDate;
    }

    public static int getYearsLived() {
        return yearsLived =
                Years.yearsBetween(birthDate, currentDate).getYears();
    }

    public static int getMonthsLived() {
        return monthsLived =
                Months.monthsBetween(birthDate, currentDate).getMonths();
    }

    public static int getWeeksLived() {
        return weeksLived =
                Weeks.weeksBetween(birthDate, currentDate).getWeeks();
    }

    public static String getSecondsLived() {
        long result = Minutes.minutesBetween(birthDate, currentDate).getMinutes();
        return secondsLived = Long.toString(result * 60);

    }

    public static int getMinutesLived() {
        return minutesLived =
                Minutes.minutesBetween(birthDate, currentDate).getMinutes();
    }

    public static int getHoursLived() {
        return hoursLived =
                Hours.hoursBetween(birthDate, currentDate).getHours();
    }
}
