package edu.project1;
import org.jetbrains.annotations.NotNull;

interface Dictionary {
    String[] words = {"Wednesday", "Statistics", "February", "Look", "Apple"};
    @NotNull public default String randomWord(){
        return words[(int) Math.round(Math.random() * (words.length - 1))].toLowerCase();
    }
}
