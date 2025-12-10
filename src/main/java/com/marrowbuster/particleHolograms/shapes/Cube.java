package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public class Cube extends Hexahedron<Cube> {

    private static final double N = 1.0 / Math.sqrt(3.0);
    
    public static final List<Vector> BASE_VECTORS = List.of(
            new Vector( N,  N,  N),
            new Vector( N, -N,  N),
            new Vector( N, -N, -N),
            new Vector( N,  N, -N),
            new Vector(-N,  N, -N),
            new Vector(-N, -N, -N),
            new Vector(-N, -N,  N),
            new Vector(-N,  N,  N));

    public static final List<Triangle> BASE_TRIANGLES = List.of(
            new Triangle(0, 1, 6),
            new Triangle(0, 6, 7),
            new Triangle(0, 3, 2),
            new Triangle(0, 2, 1),
            new Triangle(3, 4, 5),
            new Triangle(3, 5, 2),
            new Triangle(7, 6, 5),
            new Triangle(7, 5, 4),
            new Triangle(0, 7, 4),
            new Triangle(0, 4, 3),
            new Triangle(1, 2, 5),
            new Triangle(1, 5, 6)
            );

    public static final int NUMBER_OF_VERTICES = 8;

    public Cube(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }

    public Cube() {
        super(BASE_VECTORS, BASE_TRIANGLES);
    }

    @Override
    public Cube createNew(List<Vector> vectors, List<Triangle> triangles) {
        return new Cube(vectors, triangles);
    }
}
