package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public class RegularOctahedron extends Octahedron<RegularOctahedron> {

    private static final double N = 1.0 / Math.sqrt(3.0);

    public static final List<Vector> BASE_VECTORS = List.of(
            new Vector( N,  0,  0),
            new Vector(-N,  0,  0),
            new Vector( 0,  N,  0),
            new Vector( 0, -N,  0),
            new Vector( 0,  0,  N),
            new Vector( 0,  0, -N)
    );

    public static final List<Triangle> BASE_TRIANGLES = List.of(
            new Triangle(4, 0, 2),
            new Triangle(4, 2, 1),
            new Triangle(4, 1, 3),
            new Triangle(4, 3, 0),

            new Triangle(5, 2, 0),
            new Triangle(5, 1, 2),
            new Triangle(5, 3, 1),
            new Triangle(5, 0, 3)
    );

    private RegularOctahedron(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }

    public RegularOctahedron() {
        super(BASE_VECTORS, BASE_TRIANGLES);
    }

    @Override
    protected RegularOctahedron createNew(List<Vector> vectors, List<Triangle> triangles) {
        return new RegularOctahedron(vectors, triangles);
    }
}
