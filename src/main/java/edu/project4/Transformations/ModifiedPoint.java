package edu.project4.Transformations;

import edu.project4.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("MagicNumber")
public class ModifiedPoint {
    private ModifiedPoint() {

    }

    private static final List<Transformation> TRANSFORMATION_ARRAY_LIST = new ArrayList<>(List.of(
        new Sinusoidal()
    ));

    private static final List<Coefficients> AFFINITY_COEFFICIENTS = generateCoefficients();

    public static List<Coefficients> getAffinityCoefficients() {
        return AFFINITY_COEFFICIENTS;
    }

    public static List<Coefficients> generateCoefficients() {
        List<Coefficients> coefficientsList = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            Random random = new Random();
            long ind = random.nextLong();
            Coefficients coefficients = Coefficients.getCoefficients(ind);
            coefficientsList.add(coefficients);
        }
        return coefficientsList;
    }

    public static Point nonAffinity(Point point, Random random) {
        int index = random.nextInt(TRANSFORMATION_ARRAY_LIST.size());
        Transformation transformation = TRANSFORMATION_ARRAY_LIST.get(index);
        return transformation.apply(point);
    }
}
