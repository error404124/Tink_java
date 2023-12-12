package edu.project4;

public record FractalImage(Pixel[][] data, int width, int height) {

    public static FractalImage create(int width, int height) {
        Pixel[][] data = new Pixel[width][height];
        Pixel pixel = new Pixel(0, 0, 0, 0);
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                data[i][j] = pixel;
            }
        }
        return new FractalImage(data, width, height);
    }
}
