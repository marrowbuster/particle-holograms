package com.marrowbuster.particleHolograms.shapes;

public record Edge(int p1, int p2) {
    public Edge(int p1, int p2) {
        this.p1 = Math.min(p1, p2);
        this.p2 = Math.max(p1, p2);
    }
}
