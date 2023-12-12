package edu.project4.Transformations;

import java.util.Random;

@SuppressWarnings({"RecordComponentName", "MagicNumber", "LocalVariableName"})
public record Coefficients(double a, double b, double d, double e, double c, double f, int R, int G, int B) {
    public static Coefficients getCoefficients(long seed) {
        Random random = new Random(seed);
        double a;
        double b;
        double c = random.nextDouble(2) - 1;
        double d;
        double e;
        double f = random.nextDouble(2) - 1;
        int R = random.nextInt(256);
        int G = random.nextInt(256);
        int B = random.nextInt(256);
        while (true) {
            a = random.nextDouble(2) - 1;
            b = random.nextDouble(2) - 1;
            d = random.nextDouble(2) - 1;
            e = random.nextDouble(2) - 1;
            if (a * a + d * d >= 1 || b * b + e * e >= 1
                || a * a + b * b + d * d + e * e >= 1 + Math.pow((a * e - b * d), 2)) {
                continue;
            }
            return new Coefficients(a, b, d, e, c, f, R, G, B);
        }
    }
}
