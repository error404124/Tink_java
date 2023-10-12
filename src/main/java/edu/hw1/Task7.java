package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateRight(int n, int shift) {
        String binary = Integer.toBinaryString(n);
        int copyShift = shift;
        copyShift %= binary.length();
        String array = new String();

        for (int i = binary.length() - copyShift; i < binary.length(); ++i) {
            array += binary.charAt(i);
        }
        for (int i = 0; i < binary.length() - copyShift; ++i) {
            array += binary.charAt(i);
        }
        int answer = Integer.parseInt(array, 2);
        return answer;
    }

    public static int rotateLeft(int n, int shift) {
        String binary = Integer.toBinaryString(n);
        int copyShift = shift;
        copyShift %= binary.length();
        String array = new String();

        for (int i = copyShift; i < binary.length(); ++i) {
            array += binary.charAt(i);
        }
        for (int i = 0; i < copyShift; ++i) {
            array += binary.charAt(i);
        }
        int answer = Integer.parseInt(array, 2);
        return answer;
    }
}
