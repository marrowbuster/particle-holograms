package com.marrowbuster.particleHolograms.shapes;

public record Triangle(int p1, int p2, int p3) {
    public int[] indices() {
        return new int[]{p1, p2, p3};
    }
}
