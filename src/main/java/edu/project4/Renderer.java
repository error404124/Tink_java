package edu.project4;

@SuppressWarnings("EmptyLineSeparator")
public interface Renderer {
    FractalImage render(
        FractalImage canvas,
        int samples,
        short iterPerSample,
        long seed,
        int symmetry
    );
}
