package edu.project1;

import java.util.Scanner;

public final class Main {
    private Main() {
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        char[] userWord = game.getUserWord();
        if (userWord.length == 0) {
            System.exit(0);
        }
        System.out.println(userWord);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNextLine()) {
                System.out.println("You give up!");
                break;
            }
            String word = scanner.nextLine().toLowerCase();
            if (word.length() != 1) {
                System.out.println("Incorrect length, repeat input please!");
                continue;
            }
            char letter = word.charAt(0);
            if (!game.checkLetter(letter)) {
                System.out.println("Invalid input, repeat please!");
                continue;
            }
            if (game.rightLetter(letter)) {
                System.out.println("Hit!");
                System.out.println(game.replaceLetter(letter));
                if (game.gameWin()) {
                    System.out.println("You win!");
                    break;
                } else {
                    System.out.println("Game continue!");
                }
            } else {
                System.out.println(
                    "Missed, mistake" + " " + game.getCounterMistakes() + " " + "out of" + " " + game.getMaxMistakes());
                System.out.println(game.getUserWord());
                if (game.gameLoose()) {
                    System.out.println("You loose!");
                    break;
                }
            }
        }
    }
}

