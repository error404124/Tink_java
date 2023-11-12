package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    private Task1() {

    }

    @SuppressWarnings({"MultipleStringLiterals", "MagicNumber"})
    public static String howTimes(String str1, String str2) {
        long totalSecond = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        LocalDateTime start1 = LocalDateTime.parse(str1.trim().split(" - ")[0], formatter);
        LocalDateTime finish1 = LocalDateTime.parse(str1.trim().split(" - ")[1], formatter);
        LocalDateTime start2 = LocalDateTime.parse(str2.trim().split(" - ")[0], formatter);
        LocalDateTime finish2 = LocalDateTime.parse(str2.trim().split(" - ")[1], formatter);

        long second1 = Duration.between(start1, finish1).getSeconds();
        long second2 = Duration.between(start2, finish2).getSeconds();
        if ((second1 < 0 && second2 < 0) || (second2 >= Long.MAX_VALUE && second1 >= Long.MAX_VALUE)) {
            return "IncorrectDates";
        }
        totalSecond += (second1 + second2) / 2;
        long hours = totalSecond / 3600;
        long minutes = totalSecond % 3600 / 60;

        return hours + "ч" + " " + minutes + "м";
    }
}
