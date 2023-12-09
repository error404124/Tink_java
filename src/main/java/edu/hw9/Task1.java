package edu.hw9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Task1 {
    private Task1() {

    }

    static class StatsCollector {
        private final Map<String, List<Double>> data;

        StatsCollector() {
            this.data = new ConcurrentHashMap<>();
        }

        public void push(String name, double[] values) {
            if (!data.containsKey(name)) {
                data.put(name, Collections.synchronizedList(new ArrayList<>()));
            }
            List<Double> metricData = data.get(name);
            synchronized (metricData) {
                for (double val : values) {
                    metricData.add(val);
                }
            }
        }

        public Map<String, Map<String, Double>> stats() {
            Map<String, Map<String, Double>> result = new HashMap<>();

            for (Map.Entry<String, List<Double>> entry : data.entrySet()) {
                String name = entry.getKey();
                List<Double> metricData = entry.getValue();

                synchronized (metricData) {
                    double sum = 0;
                    double min = Double.MAX_VALUE;
                    double max = Double.MIN_VALUE;
                    double average = 0;

                    for (double value : metricData) {
                        if (value >= max) {
                            max = value;
                        }
                        if (value <= min) {
                            min = value;
                        }
                        sum += value;
                    }
                    average = sum / metricData.size();
                    HashMap<String, Double> metricStat = new HashMap<>();
                    metricStat.put("sum", sum);
                    metricStat.put("min", min);
                    metricStat.put("max", max);
                    metricStat.put("average", average);

                    result.put(name, metricStat);
                }

            }
            return result;
        }
    }
}
