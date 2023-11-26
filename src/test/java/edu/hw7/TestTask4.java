package edu.hw7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask4 {

    @Test
    void countPiTest1() {
        assertTrue(Math.abs(Math.PI - Task4.countPI(10000000)) < Math.exp(1e-12));
    }

    @Test
    void countPiTest2() {
        assertTrue(Math.abs(Math.PI - Task4.countPI(1000000000)) < Math.exp(1e-7));
    }

    @Test
    void countPiTest3() {
        assertTrue(Math.abs(Math.PI - Task4.countPI(100000)) < Math.exp(1e-7));
    }
}
