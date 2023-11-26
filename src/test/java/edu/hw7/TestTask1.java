package edu.hw7;

import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicInteger;
import static edu.hw7.Task1.parallelCount;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {
    @Test
    void parallelCountTest() {
        Task1.Counter a = new Task1.Counter();
        AtomicInteger answer = new AtomicInteger(200);
        assertThat(answer.get()).isEqualTo(parallelCount(a).getCounter().get());
    }

}
