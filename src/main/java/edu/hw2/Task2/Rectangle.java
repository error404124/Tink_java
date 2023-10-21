package edu.hw2.Task2;

public class Rectangle {
    protected final double width;
    protected final double height;

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;
    }

    public Rectangle setWidth(int width) {
        return new Rectangle(width, this.height);
    }

    public Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }

    public double area() {
        return width * height;
    }
}
