package edu.project1;

import org.jetbrains.annotations.NotNull;

public class Dictionary {
    private Dictionary() {
    }

    static final String[] WORDS = {"Wednesday", "Statistics", "February", "Look", "Apple"};

    @NotNull public static String randomWord() {
        return WORDS[(int) Math.round(Math.random() * (WORDS.length - 1))].toLowerCase();
    }
}
