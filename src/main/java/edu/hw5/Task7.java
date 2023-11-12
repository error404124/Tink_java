package edu.hw5;

public class Task7 {
    private Task7() {

    }

    public static Boolean checkString1(String str) {
        String regex = "[01]{2}0[01]*";
        return str.matches(regex);
    }

    public static Boolean checkString2(String str) {
        if (str.length() == 1) {
            return false;
        }
        String regex = "([01]).*\\1";
        return str.matches(regex);
    }

    public static Boolean checkString3(String str) {
        String regex = "[01]{1,3}";
        return str.matches(regex);
    }

}
