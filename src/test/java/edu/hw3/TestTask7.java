package edu.hw3;

import edu.hw3.Task7.Task7;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask7 {
    @Test
    void ComparatorTest1() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7.NullComparator<>());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }

    @Test
    void ComparatorTest2() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7.NullComparator<>());
        tree.put(null, "test");
        assertThat(tree.containsValue("test")).isTrue();
    }
}
