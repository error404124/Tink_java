package edu.project4;

public record Pixel(int r, int g, int b, int hitCount) {
    public Pixel withR(int r) {
        return new Pixel(r, this.g(), this.b(), this.hitCount());
    }

    public Pixel withG(int g) {
        return new Pixel(this.r(), g, this.b(), this.hitCount());
    }

    public Pixel withB(int b) {
        return new Pixel(this.r(), this.g(), b, this.hitCount());
    }

    public Pixel withHitCount(int hitCount) {
        return new Pixel(this.r(), this.g(), this.b(), hitCount);
    }
}
