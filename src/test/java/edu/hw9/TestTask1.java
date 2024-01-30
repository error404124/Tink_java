package edu.hw9;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {

    @Test
    void statsCollectorTest1(){
        Task1.StatsCollector collector = new Task1.StatsCollector();
        double[] val = {0.1, 1.5, 0.99, 5.3};
        collector.push("metric1", val);
        var stats = collector.stats();
        double answer = stats.get("metric1").get("sum");
        assertThat(answer).isEqualTo(7.89);
    }

    @Test
    void statsCollectorTest2(){
        Task1.StatsCollector collector = new Task1.StatsCollector();
        double[] val = {0.1, 1.5, 0.99, 5.3};
        collector.push("metric1", val);
        var stats = collector.stats();
        double answer = stats.get("metric1").get("min");
        assertThat(answer).isEqualTo(0.1);
    }

    @Test
    void statsCollectorTest3(){
        Task1.StatsCollector collector = new Task1.StatsCollector();
        double[] val = {0.1, 1.5, 0.99, 5.3};
        collector.push("metric1", val);
        var stats = collector.stats();
        double answer = stats.get("metric1").get("max");
        assertThat(answer).isEqualTo(5.3);
    }

    @Test
    void statsCollectorTest4(){
        Task1.StatsCollector collector = new Task1.StatsCollector();
        double[] val = {0.1, 1.5, 0.99, 5.3};
        collector.push("metric1", val);
        var stats = collector.stats();
        double answer = stats.get("metric1").get("average");
        assertThat(answer).isEqualTo(1.9725);
    }
}
