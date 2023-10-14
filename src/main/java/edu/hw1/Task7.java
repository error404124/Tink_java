package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateRight(int n, int shift) {
        String binary = Integer.toBinaryString(n);
        int copyShift = shift;
        copyShift %= binary.length();
        StringBuilder array = new StringBuilder();

        for (int i = binary.length() - copyShift; i < binary.length(); ++i) {
            array.append(binary.charAt(i));
        }
        for (int i = 0; i < binary.length() - copyShift; ++i) {
            array.append(binary.charAt(i));
        }
        return Integer.parseInt(array.toString(), 2);
    }

    public static int rotateLeft(int n, int shift) {
        String binary = Integer.toBinaryString(n);
        int copyShift = shift;
        copyShift %= binary.length();
        StringBuilder array = new StringBuilder();

        for (int i = copyShift; i < binary.length(); ++i) {
            array.append(binary.charAt(i));
        }
        for (int i = 0; i < copyShift; ++i) {
            array.append(binary.charAt(i));
        }
        return Integer.parseInt(array.toString(), 2);
    }
}
