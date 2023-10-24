package edu.hw2;

import edu.hw2.Task4.Task4;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {
    @Test
    void test1() {
        String ans = "CallingInfo[className=org.apache.maven.surefire.booter.ForkedBooter, methodName=main]";
        assertThat(ans).isEqualTo(Task4.getMethodsAndClasses() + "");
    }

    @Test
    void test2() {
        String ans = "org.apache.maven.surefire.booter.ForkedBooter";
        assertThat(ans).isEqualTo(Task4.getMethodsAndClasses().className());
    }

    @Test
    void test3() {
        String ans = "main";
        assertThat(ans).isEqualTo(Task4.getMethodsAndClasses().methodName());
    }

}
