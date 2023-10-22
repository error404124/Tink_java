package edu.hw2;

import edu.hw2.Task4.Task4;
import org.junit.jupiter.api.Test;
import java.util.Objects;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {
    @Test
    void testMethodName() {
        var ans = "main";
        assertThat(ans).isEqualTo(Objects.requireNonNull(Task4.getMethodsAndClasses().methodName()));
    }

    @Test
    void testClassName() {
        var ans = "com.intellij.rt.junit.JUnitStarter";
        assertThat(ans).isEqualTo(Task4.getMethodsAndClasses().className());
    }
}
