package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {
    private Task5() {

    }

    public static Boolean checkCarNumber(String number) {
        String regex = "[А-Я]\\d{3}[А-Я]{2}\\d{3}";
        return Pattern.matches(regex, number);
    }
}
