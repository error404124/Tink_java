package edu.project4;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

@SuppressWarnings({"MagicNumber", "EmptyLineSeparator", "ImportOrder"})
public class SaveCanvas {
    private SaveCanvas() {

    }

    enum ImageFormat {
        JPEG, BMP, PNG
    }

    public static void saveImage(FractalImage canvas, String path, ImageFormat format) throws IOException {
        File file = new File(path);
        String formatName = switch (format) {
            case JPEG -> "JPEG";
            case BMP -> "BMP";
            case PNG -> "PNG";
        };

        ImageIO.write(convert(canvas), formatName, file);
    }

    private static BufferedImage convert(FractalImage canvas) {
        int width = canvas.width();
        int height = canvas.height();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel pixel = canvas.data()[x][y];
                int rgb = (pixel.r() << 16) | (pixel.g() << 8) | pixel.b();
                bufferedImage.setRGB(x, y, rgb);
            }
        }

        return bufferedImage;
    }
}
