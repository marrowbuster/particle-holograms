package com.marrowbuster.particleHolograms.shapes;

import lombok.Getter;

import java.util.List;

public class Triangle {
    @Getter
    private final List<Vector> vectors;

    @Getter
    private final Vector normal;

    @Getter
    private final Vector centroid;

    public Triangle(Vector v1, Vector v2, Vector v3) {
        this.vectors = List.of(v1, v2, v3);
        this.normal = calculateNormal(v1, v2, v3);
        this.centroid = calculateCentroid(v1, v2, v3);
    }

    public Triangle(Vector v1, Vector v2) throws IllegalArgumentException {
        if (v1.equals(v2)) {
            throw new IllegalArgumentException("Cannot construct triangle from only one vector!");
        }
        Vector v3 = v1.add(v2.subtract(v1).invert());
        this.vectors = List.of(v1, v2, v3);
        this.normal = calculateNormal(v1, v2, v3);
        this.centroid = calculateCentroid(v1, v2, v3);
    }

    public Triangle(List<Vector> newVectors) throws IllegalArgumentException {
        switch (newVectors.size()) {
            case 2 -> {
                Vector v1 = newVectors.get(0);
                Vector v2 = newVectors.get(1);
                this.vectors = List.of(v1, v2, v1.add(v2.subtract(v1).invert()));
            }
            case 3 -> this.vectors = List.copyOf(newVectors);
            default -> throw new IllegalArgumentException("Triangle must have 2 or 3 vectors defined");
        }
        this.normal = calculateNormal(this.vectors.get(0), this.vectors.get(1), this.vectors.get(2));
        this.centroid = calculateCentroid(this.vectors.get(0), this.vectors.get(1), this.vectors.get(2));
    }

    private static Vector calculateNormal(Vector v1, Vector v2, Vector v3) {
        Vector a = v2.subtract(v1);
        Vector b = v3.subtract(v1);
        return a.cross(b).normalise();
    }

    private static Vector calculateCentroid(Vector v1, Vector v2, Vector v3) {
        return new Vector(
                (v1.getX() + v2.getX() + v3.getX()) / 3d,
                (v1.getY() + v2.getY() + v3.getY()) / 3d,
                (v1.getZ() + v2.getZ() + v3.getZ()) / 3d
        );
    }

    public Vector v1() {
        return this.vectors.get(0);
    }

    public Vector v2() {
        return this.vectors.get(1);
    }

    public Vector v3() {
        return this.vectors.get(2);
    }
}
