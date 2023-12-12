package edu.project4;

public class PostRender {
    private PostRender() {

    }

    public static void correction(FractalImage canvas) {
        double max = 0;
        double gamma = 2;
        for (int i = 0; i < canvas.width(); ++i) {
            for (int j = 0; j < canvas.height(); ++j) {
                if (canvas.data()[i][j].hitCount() != 0) {
                    if (Math.log10(canvas.data()[i][j].hitCount()) > max) {
                        max = Math.log10(canvas.data()[i][j].hitCount());
                    }
                }
            }
        }
        for (int i = 0; i < canvas.width(); ++i) {
            for (int j = 0; j < canvas.height(); ++j) {
                double normal = Math.log10(canvas.data()[i][j].hitCount()) / max;
                canvas.data()[i][j] =
                    canvas.data()[i][j].withR((int) (canvas.data()[i][j].r() * Math.pow(normal, (1 / gamma))));
                canvas.data()[i][j] =
                    canvas.data()[i][j].withG((int) (canvas.data()[i][j].g() * Math.pow(normal, (1 / gamma))));
                canvas.data()[i][j] =
                    canvas.data()[i][j].withB((int) (canvas.data()[i][j].b() * Math.pow(normal, (1 / gamma))));
            }
        }
    }
}
