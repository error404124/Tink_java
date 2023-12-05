package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    private Task1() {

    }

    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    @SuppressWarnings({"MultipleStringLiterals", "MagicNumber"})
    public static String howTimes(String[] timeArray) {
        long totalSecond = 0;
        int counter = 0;
        for (String time : timeArray) {
            ++counter;
            LocalDateTime start = LocalDateTime.parse(time.trim().split(" - ")[0], FORMATTER);
            LocalDateTime finish = LocalDateTime.parse(time.trim().split(" - ")[1], FORMATTER);
            long seconds = Duration.between(start, finish).getSeconds();

            if (seconds < 0 || seconds >= Long.MAX_VALUE) {
                return "IncorrectDates";
            }

            totalSecond += seconds;
        }
        totalSecond /= counter;

        long hours = totalSecond / 3600;
        long minutes = totalSecond % 3600 / 60;

        return hours + "ч " + minutes + "м";
    }
}
