package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {
    @Test
    void clusterizeTest1() {
        String array = "()()()";
        String[] answer = {"()", "()", "()"};
        assertThat(answer).isEqualTo(Task2.clusterize(array));
    }
    @Test
    void clusterizeTest2() {
        String array = "((()))";
        String[] answer = {"((()))"};
        assertThat(answer).isEqualTo(Task2.clusterize(array));
    }
    @Test
    void clusterizeTest3() {
        String array = "((()))(())()()(()())";
        String[] answer = {"((()))", "(())", "()", "()", "(()())"};
        assertThat(answer).isEqualTo(Task2.clusterize(array));
    }
    @Test
    void clusterizeTest4() {
        String array = "((())())(()(()()))";
        String[] answer = {"((())())", "(()(()()))"};
        assertThat(answer).isEqualTo(Task2.clusterize(array));
    }
    @Test
    void clusterizeTest5() {
        String array = "";
        String[] answer = {};
        assertThat(answer).isEqualTo(Task2.clusterize(array));
    }
}
