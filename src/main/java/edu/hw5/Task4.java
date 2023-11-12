package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    private Task4() {

    }

    public static Boolean checkPassword(String str) {
        String regex = ".*[~!@#$%^&*|].*";
        return Pattern.matches(regex, str);
    }
}
