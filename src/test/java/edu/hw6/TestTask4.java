package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask4 {
    @Test
    void testOutputStreamComposition1() throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        try {
            Task4.outputStreamComposition(tempFile);
            assertTrue(Files.size(tempFile) > 0);
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }
    @Test
    void testOutputStreamComposition2() throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        try {
            Task4.outputStreamComposition(tempFile);
            assertTrue(Files.exists(tempFile));
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }
}
