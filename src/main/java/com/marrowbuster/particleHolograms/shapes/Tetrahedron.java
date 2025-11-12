package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public class Tetrahedron extends Mesh<Tetrahedron> {
    public static final List<Vector> BASE_VECTORS = List.of(new Vector(1/Math.sqrt(3), 1/Math.sqrt(3), 1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), -1/Math.sqrt(3), 1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), 1/Math.sqrt(3), -1/Math.sqrt(3)),
            new Vector(1/Math.sqrt(3), -1/Math.sqrt(3), -1/Math.sqrt(3)));

    public static final List<Triangle> BASE_TRIANGLES = List.of(
            new Triangle(List.of(BASE_VECTORS.get(0), BASE_VECTORS.get(1), BASE_VECTORS.get(2))),
            new Triangle(List.of(BASE_VECTORS.get(0), BASE_VECTORS.get(2), BASE_VECTORS.get(3))),
            new Triangle(List.of(BASE_VECTORS.get(0), BASE_VECTORS.get(3), BASE_VECTORS.get(1))),
            new Triangle(List.of(BASE_VECTORS.get(1), BASE_VECTORS.get(3), BASE_VECTORS.get(2)))
    );

    public static final int NUMBER_OF_FACES = 4;
    public static final int NUMBER_OF_VERTICES = 4;

    public Tetrahedron(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }

    public Tetrahedron() {
        super(BASE_VECTORS, BASE_TRIANGLES);
    }

    @Override
    protected Tetrahedron createNew(List<Vector> vectors, List<Triangle> triangles) {
        return new Tetrahedron(vectors, triangles);
    }
}
