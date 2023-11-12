package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    private Task6() {

    }

    public static Boolean stringInSting(String str1, String str2) {
        return str2.matches(".*" + Pattern.quote(str1) + ".*");
    }
}
