package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Task3 {
    private Task3() {

    }

    private static Optional<LocalDate> parse1(String str) {
        try {
            LocalDate data = LocalDate.parse(str);
            return Optional.of(data);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private static Optional<LocalDate> parse2(String str) {
        try {
            LocalDate date = LocalDate.parse(str, DateTimeFormatter.ofPattern("d/M/yy"));
            return Optional.of(date);
        } catch (Exception ignored) {
        }
        try {
            LocalDate date = LocalDate.parse(str, DateTimeFormatter.ofPattern("d/M/y"));
            return Optional.of(date);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @SuppressWarnings("ReturnCount")
    private static Optional<LocalDate> parse3(String str) {
        if (str.equals("tomorrow")) {
            return Optional.of(LocalDate.now().plusDays(1));
        } else if (str.equals("today")) {
            return Optional.of(LocalDate.now());
        } else if (str.equals("yesterday")) {
            return Optional.of(LocalDate.now().minusDays(1));
        } else if (str.endsWith(" day ago") || str.endsWith(" days ago")) {
            try {
                int days = Integer.parseInt(str.split(" ")[0]);
                return Optional.of(LocalDate.now().minusDays(days));
            } catch (Exception ignored) {

            }
        }
        return Optional.empty();
    }

    private static Optional<LocalDate> parse4(String str) {
        try {
            LocalDate date = LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-d"));
            return Optional.of(date);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @SuppressWarnings("ReturnCount")
    public static Optional<LocalDate> parseData(String str) {
        if (parse1(str).isPresent()) {
            return parse1(str);
        } else if (parse2(str).isPresent()) {
            return parse2(str);
        } else if (parse3(str).isPresent()) {
            return parse3(str);
        } else if (parse4(str).isPresent()) {
            return parse4(str);
        }
        return Optional.empty();
    }
}
