package edu.hw3;

public class Task4 {
    private Task4() {
    }

    @SuppressWarnings("MagicNumber")
    public static String convertToRoman(int number) {
        if (number < 0 || number > 3999) {
            return null;
        }
        int copyNumber = number;
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder romanNumber = new StringBuilder();
        for (int i = 0; i < romanNumerals.length; i++) {
            while (copyNumber >= arabicValues[i]) {
                romanNumber.append(romanNumerals[i]);
                copyNumber -= arabicValues[i];
            }
        }
        return romanNumber.toString();
    }
}
