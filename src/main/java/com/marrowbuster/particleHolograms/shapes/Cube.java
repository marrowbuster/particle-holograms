package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public class Cube extends Hexahedron {
    
    public static final List<Vector> BASE_VECTORS = List.of(new Vector(1/Math.sqrt(3), 1/Math.sqrt(3), 1/Math.sqrt(3)),
            new Vector(1/Math.sqrt(3), -1/Math.sqrt(3), 1/Math.sqrt(3)),
            new Vector(1/Math.sqrt(3), -1/Math.sqrt(3), -1/Math.sqrt(3)),
            new Vector(1/Math.sqrt(3), 1/Math.sqrt(3), -1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), 1/Math.sqrt(3), -1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), -1/Math.sqrt(3), -1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), -1/Math.sqrt(3), 1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), 1/Math.sqrt(3), 1/Math.sqrt(3)));

    public static final List<Triangle> BASE_TRIANGLES = List.of(
            new Triangle(
                    BASE_VECTORS.get(1).subtract(BASE_VECTORS.get(0)),
                    BASE_VECTORS.get(3).subtract(BASE_VECTORS.get(1)),
                    BASE_VECTORS.get(0).subtract(BASE_VECTORS.get(3))
            ),
            new Triangle(
                    BASE_VECTORS.get(3).subtract(BASE_VECTORS.get(2)),
                    BASE_VECTORS.get(1).subtract(BASE_VECTORS.get(3)),
                    BASE_VECTORS.get(2).subtract(BASE_VECTORS.get(1))
            ),
            new Triangle(
                    BASE_VECTORS.get(7).subtract(BASE_VECTORS.get(6)),
                    BASE_VECTORS.get(5).subtract(BASE_VECTORS.get(7)),
                    BASE_VECTORS.get(6).subtract(BASE_VECTORS.get(5))
            ),
            new Triangle(
                    BASE_VECTORS.get(5).subtract(BASE_VECTORS.get(4)),
                    BASE_VECTORS.get(7).subtract(BASE_VECTORS.get(5)),
                    BASE_VECTORS.get(4).subtract(BASE_VECTORS.get(7))
            ),
            new Triangle(
                    BASE_VECTORS.get(0).subtract(BASE_VECTORS.get(1)),
                    BASE_VECTORS.get(6).subtract(BASE_VECTORS.get(0)),
                    BASE_VECTORS.get(1).subtract(BASE_VECTORS.get(6))
            ),
            new Triangle(
                    BASE_VECTORS.get(6).subtract(BASE_VECTORS.get(7)),
                    BASE_VECTORS.get(0).subtract(BASE_VECTORS.get(6)),
                    BASE_VECTORS.get(7).subtract(BASE_VECTORS.get(0))
            ),
            new Triangle(
                    BASE_VECTORS.get(0).subtract(BASE_VECTORS.get(4)),
                    BASE_VECTORS.get(7).subtract(BASE_VECTORS.get(0)),
                    BASE_VECTORS.get(4).subtract(BASE_VECTORS.get(7))
            ),
            new Triangle(
                    BASE_VECTORS.get(4).subtract(BASE_VECTORS.get(3)),
                    BASE_VECTORS.get(0).subtract(BASE_VECTORS.get(4)),
                    BASE_VECTORS.get(3).subtract(BASE_VECTORS.get(0))
            )
            );

    public static final int NUMBER_OF_VERTICES = 8;

    public Cube(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }

    public Cube() {
        super(BASE_VECTORS, BASE_TRIANGLES);
    }

    public Cube createNew(List<Vector> vectors, List<Triangle> triangles) {
        return new Cube(vectors, triangles);
    }
}
