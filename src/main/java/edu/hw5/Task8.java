package edu.hw5;

public class Task8 {
    private Task8() {

    }

    static public Boolean check1(String str) {
        String regex = "([01]{2})*[01]";
        return str.matches(regex);
    }

    static public Boolean check2(String str) {
        String regex = "^0([01]{2})*|^1([01]{2})*[01]";
        return str.matches(regex);
    }

    static public Boolean check3(String str) {
        String regex = ".*[0]{1,}.*[0]{1,}.*[0]{1,}.*";
        return str.matches(regex);
    }

    static public Boolean check4(String str) {
        String regex = "^(?:(?!11|111).)*$";
        return str.matches(regex);
    }

    static public Boolean check6(String str) {
        String regex = "^(?=.*0.*0)(?!.*1.*1)[01]+$";
        return str.matches(regex);
    }

    static public Boolean check7(String str) {
        String regex = "(0|10)*1?0*";
        return str.matches(regex);
    }
}
