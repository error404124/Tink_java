package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;

public class TestTask8 {
    @Test
    void BackwardIteratorTest1() {
        BackwardIterator<Object> a = new BackwardIterator<>(List.of(1, 2));
        int answer = 3;
        assertThat(answer).isEqualTo(a.next());
    }

    @Test
    void BackwardIteratorTest2() {
        BackwardIterator<Object> a = new BackwardIterator<>(List.of(1, 2));
        int answer = 2;
        assertThat(answer).isEqualTo(a.next());
    }

    @Test
    void BackwardIteratorTest3() {
        BackwardIterator<Object> a = new BackwardIterator<>(List.of(1));
        int answer = 1;
        assertThat(answer).isEqualTo(a.next());
    }

    @Test
    void BackwardIteratorTest4() {
        BackwardIterator<Object> a = new BackwardIterator<>(List.of());
        Boolean answer = null;
        assertThat(answer).isEqualTo(a.next());
    }

    @Test
    void BackwardIteratorTes5() {
        BackwardIterator<Object> a = new BackwardIterator<>(List.of(1));
        Boolean answer = true;
        assertThat(answer).isEqualTo(a.hasNext());
    }

    @Test
    void BackwardIteratorTes6() {
        BackwardIterator<Object> a = new BackwardIterator<>(List.of());
        Boolean answer = false;
        assertThat(answer).isEqualTo(a.hasNext());
    }
}
