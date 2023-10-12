package edu.hw1;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task3.isNestable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask3 {
    @Test
    void isNestable_test1() {
        int[] mass1 = {1, 2, 3, 4};
        int[] mass2 = {0, 6};
        boolean ans = true;
        assertThat(ans).isEqualTo(isNestable(mass1, mass2));
    }
    @Test
    void isNestable_test2() {
        int[] mass1 = {1, 2, 3, 4};
        int[] mass2 = {2, 3};
        boolean ans = false;
        assertThat(ans).isEqualTo(isNestable(mass1, mass2));
    }
}
