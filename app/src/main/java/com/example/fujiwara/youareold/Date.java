package com.example.fujiwara.youareold;

import org.joda.time.LocalDate;

/**
 * Created by Bruno Ramres on 26/04/2017.
 */

public interface Date {

    // Returns user's birth date
    LocalDate getBirthDate();

    // Set user's birth date
    void setBirthDate(int year, int month, int day);

}
