package edu.project3;

import org.junit.jupiter.api.Test;
import static edu.project3.LogAnalyzer.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestProject3 {
    final static String[] logs = getLog();
    @Test
    void test1() {
        String answer = "216.46.173.126 : 2350";
        assertThat(answer).isEqualTo(mostPopularIP(logs));
    }
    @Test
    void test2() {
        String answer = "{MAY=42040, JUNE=9422}";
        assertThat(answer).isEqualTo(mostPopularMonth(logs).toString());
    }
    @Test
    void test3() {
        String answer = "{304=13330, 200=4028, 404=33876, 206=186, 403=38, 416=4}";
        assertThat(answer).isEqualTo(mostFrequentStatus(logs).toString());
    }
    @Test
    void test4() {
        String answer = "{/downloads/product_1=30285, /downloads/product_2=21104, /downloads/product_3=73}";
        assertThat(answer).isEqualTo(mostFrequentLog(logs).toString());
    }

    @Test
    void test5() {
        int answer = 659509;
        assertThat(answer).isEqualTo(sizeStatus(logs));
    }
}
