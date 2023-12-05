package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MagicNumber")
public class Task2 {
    private Task2() {

    }

    public static List<LocalDate> allFriday13(int year) {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate date = LocalDate.of(year, Month.JANUARY, 13);
        while (date.getYear() == year) {
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                dates.add(date);
            }
            date = date.plusMonths(1);
        }
        return dates;
    }

    public static LocalDate nextFriday13(LocalDate data) {
        LocalDate copyData = data;
        LocalDate nextFriday = data.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (nextFriday.getDayOfMonth() != 13) {
            if (copyData.getDayOfMonth() > 13) {
                copyData = copyData.plusMonths(1).withDayOfMonth(1);
            }
            nextFriday = copyData.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            copyData = copyData.plusDays(1);
        }
        return nextFriday;
    }
}

