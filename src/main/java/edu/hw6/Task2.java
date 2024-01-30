package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    final static String NAME = "Tinkoff Bank Biggest Secret";

    private Task2() {

    }

    public static void cloneFile(Path path) throws IOException {
        int counter = 1;
        Path copyPath = path;
        while (Files.exists(copyPath)) {
            String add = "";
            if (counter == 1) {
                add = " - копия";
            } else {
                add = "- копия (" + counter + ")";
            }
            String newName = NAME + add + ".txt";
            copyPath = path.resolveSibling(newName);
            counter++;
        }
        Files.copy(path, copyPath);
    }
}
