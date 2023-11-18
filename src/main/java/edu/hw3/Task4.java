package edu.hw3;

public class Task4 {
    private Task4() {
    }

    static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static final int[] ARABIC_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    @SuppressWarnings("MagicNumber")
    public static String convertToRoman(int number) {
        if (number < 0 || number > 3999) {
            return null;
        }
        int copyNumber = number;

        StringBuilder romanNumber = new StringBuilder();
        for (int i = 0; i < ROMAN_NUMERALS.length; i++) {
            while (copyNumber >= ARABIC_VALUES[i]) {
                romanNumber.append(ROMAN_NUMERALS[i]);
                copyNumber -= ARABIC_VALUES[i];
            }
        }
        return romanNumber.toString();
    }
}
