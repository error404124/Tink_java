package edu.hw6;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {
    @Test
    void test1(){
        Task1.DiskMap f = new Task1.DiskMap("Test");
        String answer = "c";
        assertThat(answer).isEqualTo(f.get("3"));
    }
    @Test
    void test2(){
        Task1.DiskMap f = new Task1.DiskMap("Test");;
        String answer = "{1=a, 2=b, 3=c, 4=d, 5=e, 6=f, 7=g}";
        assertThat(answer).isEqualTo(f.loadMapFromFile().toString());
    }
}
