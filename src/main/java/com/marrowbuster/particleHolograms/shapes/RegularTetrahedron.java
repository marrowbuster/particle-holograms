package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public class RegularTetrahedron extends Tetrahedron<RegularTetrahedron> {

    private static final double N = 1.0 / Math.sqrt(3.0);

    public static final List<Vector> BASE_VECTORS = List.of(
            new Vector( N,  N,  N),
            new Vector(-N, -N,  N),
            new Vector(-N,  N, -N),
            new Vector( N, -N, -N)
    );

    public static final List<Triangle> BASE_TRIANGLES = List.of(
            new Triangle(0, 1, 2),
            new Triangle(0, 2, 3),
            new Triangle(0, 3, 1),
            new Triangle(1, 3, 2)
    );

    private RegularTetrahedron(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }

    public RegularTetrahedron() {
        super(BASE_VECTORS, BASE_TRIANGLES);
    }

    @Override
    protected RegularTetrahedron createNew(List<Vector> vectors, List<Triangle> triangles) {
        return new RegularTetrahedron(vectors, triangles);
    }
}
