package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {
    @Test
    void atbashTest1() {
        String array = "Hello world!";
        String answer = "Svool dliow!";
        assertThat(answer).isEqualTo(Task1.atbash(array));
    }
    @Test
    void atbashTest2() {
        String array = "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String answer = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        assertThat(answer).isEqualTo(Task1.atbash(array));
    }
}
