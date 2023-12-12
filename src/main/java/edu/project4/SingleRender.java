package edu.project4;

import edu.project4.Transformations.Coefficients;
import edu.project4.Transformations.ModifiedPoint;
import java.util.List;
import java.util.Random;
import static edu.project4.Transformations.ModifiedPoint.getAffinityCoefficients;

@SuppressWarnings({"MagicNumber", "NestedIfDepth"})

public class SingleRender implements Renderer {
    @Override
    public FractalImage render(
        FractalImage canvas,
        int samples,
        short iterPerSample,
        long seed,
        int symmetry
    ) {
        double phi;
        List<Coefficients> coefficients = getAffinityCoefficients();
        Random random = new Random(seed);
        for (int num = 0; num < samples; ++num) {
            Point startPoint = new Point(random.nextDouble(2) - 1, random.nextDouble(2) - 1);
            for (short step = -20; step < iterPerSample; ++step) {

                int affineIndex = random.nextInt(coefficients.size());
                Coefficients currentCoefficient = coefficients.get(affineIndex);

                double pointX = startPoint.x() * currentCoefficient.a() + startPoint.y() * currentCoefficient.b()
                    + currentCoefficient.c();

                double pointY = startPoint.x() * currentCoefficient.d() + startPoint.y() * currentCoefficient.e()
                    + currentCoefficient.f();

                startPoint = new Point(pointX, pointY);

                startPoint = ModifiedPoint.nonAffinity(startPoint, random);
                if (step > 0 && Math.abs(startPoint.x()) < 1 && Math.abs(startPoint.y()) < 1) {

                    for (int k = 0; k < symmetry; ++k) {
//                        double x = (startPoint.x() + 1) * canvas.width() / 2;
//                        double y = (startPoint.y() + 1) * canvas.height() / 2;
                        if (symmetry > 0) {
                            phi = k * Math.PI * 2 / symmetry;
                        } else {
                            throw new IllegalArgumentException("Симметрия больше нуля обязаня быть!");
                        }
                        if (Math.abs(startPoint.x() * Math.cos(phi) - startPoint.y() * Math.sin(phi)) < 1
                            && Math.abs(startPoint.x() * Math.sin(phi) + startPoint.y() * Math.cos(phi)) < 1) {

                            double x =
                                (startPoint.x() * Math.cos(phi) - startPoint.y() * Math.sin(phi) + 1) * canvas.width()
                                    / 2;
                            double y = (startPoint.x() * Math.sin(phi) + startPoint.y() * Math.cos(phi) + 1)
                                * canvas.height() / 2;

                            if (x < canvas.height() && y < canvas.width() && x > 0 && y > 0) {

                                Point canvasPoint =
                                    new Point(
                                        x * Math.cos(phi) - y * Math.sin(phi),
                                        x * Math.sin(phi) + y * Math.cos(phi)
                                    );

                                int r = currentCoefficient.R();
                                int g = currentCoefficient.G();
                                int b = currentCoefficient.B();

                                Pixel pixel;
                                if (canvas.data()[(int) x][(int) y].hitCount() == 0) {
                                    pixel = new Pixel(r, g, b, 1);
                                } else {
                                    pixel = new Pixel(
                                        (r + canvas.data()[(int) x][(int) y].r()) / 2,
                                        (g + canvas.data()[(int) x][(int) y].g()) / 2,
                                        (b + canvas.data()[(int) x][(int) y].b()) / 2,
                                        canvas.data()[(int) x][(int) y].hitCount() + 1
                                    );
                                }
                                canvas.data()[(int) x][(int) y] = pixel;
                            }
                        }
                    }
                }
            }
        }
        return canvas;
    }
}
