package edu.hw1;

public class Task7 {
    public static int rotateRight(int n, int shift) {
        String binary = Integer.toBinaryString(n);
        shift %= binary.length();
        String array = new String();

        for (int i = binary.length() - shift; i < binary.length(); ++i) {
            array += binary.charAt(i);
        }
        for (int i = 0; i < binary.length() - shift; ++i) {
            array += binary.charAt(i);
        }
        int answer = Integer.parseInt(array, 2);
        return answer;
    }

    public static int rotateLeft(int n, int shift) {
        String binary = Integer.toBinaryString(n);
        shift %= binary.length();
        String array = new String();

        for (int i = shift; i < binary.length(); ++i) {
            array += binary.charAt(i);
        }
        for (int i = 0; i < shift; ++i) {
            array += binary.charAt(i);
        }
        int answer = Integer.parseInt(array, 2);
        return answer;
    }
}
