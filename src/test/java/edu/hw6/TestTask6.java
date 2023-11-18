package edu.hw6;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask6 {
    @Test
    void test1() {
        String resultTCP = Task6.checkPort("TCP", 8080);
        String answer = "TCP\t8080\tЗанят";
        assertThat(answer).isEqualTo(resultTCP);
    }

    @Test
    void test2() {
        String resultUDP = Task6.checkPort("UDP", 8080);
        String answer = "UDP\t8080\tСвободен";
        assertThat(answer).isEqualTo(resultUDP);
    }
}
