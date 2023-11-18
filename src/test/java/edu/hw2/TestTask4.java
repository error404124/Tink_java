package edu.hw2;

import edu.hw2.Task4.Task4;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {
    @Test
    void test1() {
        String ans = "CallingInfo[className=edu.hw2.TestTask4, methodName=test1]";
        assertThat(ans).isEqualTo(Task4.getMethodsAndClasses().toString());
    }

    @Test
    void test2() {
        String ans = "edu.hw2.TestTask4";
        assertThat(ans).isEqualTo(Task4.getMethodsAndClasses().className());
    }

    @Test
    void test3() {
        String ans = "test3";
        assertThat(ans).isEqualTo(Task4.getMethodsAndClasses().methodName());
    }

}
