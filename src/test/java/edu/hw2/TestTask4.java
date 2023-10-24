package edu.hw2;

import edu.hw2.Task4.Task4;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {
    @Test
    void test1() {
        String ans = "CallingInfo[className=com.intellij.rt.junit.JUnitStarter, methodName=main]";
        assertThat(ans).isEqualTo(Task4.getMethodsAndClasses() + "");
    }

    @Test
    void test2() {
        String ans = "com.intellij.rt.junit.JUnitStarter";
        assertThat(ans).isEqualTo(Task4.getMethodsAndClasses().className());
    }

    @Test
    void test3() {
        String ans = "main";
        assertThat(ans).isEqualTo(Task4.getMethodsAndClasses().methodName());
    }

}
