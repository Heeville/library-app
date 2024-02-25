package com.group.libraryapp.dto.calculator.response;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TodayDate {
    private final DayOfWeek dayOfTheWeek;

    public String getDayOfTheWeek() {
        return dayOfTheWeek.toString().substring(0,3);
    }

    public TodayDate(String day) {
        this.dayOfTheWeek = LocalDate.parse(day).getDayOfWeek();
    }


}
