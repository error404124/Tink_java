package edu.project1;

public class HangmanGame {
    static final int COUNT_LETTER_IN_ALPHABET = 27;
    static final int MAX_MISTAKES = 5;
    static char[] alphabet = new char[COUNT_LETTER_IN_ALPHABET];
    static char[] seekingWord;
    static char[] userWord;
    int counterMistakes = 0;

    public HangmanGame(String str) {
        seekingWord = str.toCharArray();
        userWord = "*".repeat(seekingWord.length).toCharArray();
    }

    public HangmanGame() {
        this(Dictionary.randomWord().toLowerCase());
    }

    public char[] getUserWord() {
        return userWord;
    }

    public boolean rightLetter(char letter) {
        for (char elem : seekingWord) {
            if (elem == letter) {
                return true;
            }
        }
        counterMistakes++;
        return false;
    }

    public char[] replaceLetter(char letter) {
        for (int i = 0; i < userWord.length; ++i) {
            if (letter == seekingWord[i]) {
                userWord[i] = letter;
            }
        }
        return userWord;
    }

    public boolean checkLetter(char letter) {
        for (char elem : alphabet) {
            if (elem == letter || letter > 'z' || letter < 'a') {
                return false;
            }
        }
        alphabet[letter - 'a'] = letter;
        return true;
    }

    public int getMaxMistakes() {
        return MAX_MISTAKES;
    }

    public int getCounterMistakes() {
        return counterMistakes;
    }

    public boolean gameLoose() {
        return counterMistakes > MAX_MISTAKES;
    }

    public boolean gameWin() {
        for (char c : userWord) {
            if (c == '*') {
                return false;
            }
        }
        return true;
    }

    public boolean checkSeekingWord() {
        return seekingWord.length != 0;
    }

}
