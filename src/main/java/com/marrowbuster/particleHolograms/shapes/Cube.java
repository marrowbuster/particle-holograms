package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public class Cube extends Hexahedron<Cube>{

    public static final List<Vector> VECTORS = List.of(new Vector(1/Math.sqrt(3), 1/Math.sqrt(3), 1/Math.sqrt(3)),
            new Vector(1/Math.sqrt(3), -1/Math.sqrt(3), 1/Math.sqrt(3)),
            new Vector(1/Math.sqrt(3), -1/Math.sqrt(3), -1/Math.sqrt(3)),
            new Vector(1/Math.sqrt(3), 1/Math.sqrt(3), -1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), 1/Math.sqrt(3), -1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), -1/Math.sqrt(3), -1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), -1/Math.sqrt(3), 1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), 1/Math.sqrt(3), 1/Math.sqrt(3)));

    public static final List<Face> FACES = List.of(
            new Face(
                    VECTORS.get(1).subtract(VECTORS.get(0)),
                    VECTORS.get(3).subtract(VECTORS.get(1)),
                    VECTORS.get(0).subtract(VECTORS.get(3))
            ),
            new Face(
                    VECTORS.get(3).subtract(VECTORS.get(2)),
                    VECTORS.get(1).subtract(VECTORS.get(3)),
                    VECTORS.get(2).subtract(VECTORS.get(1))
            ),
            new Face(
                    VECTORS.get(7).subtract(VECTORS.get(6)),
                    VECTORS.get(5).subtract(VECTORS.get(7)),
                    VECTORS.get(6).subtract(VECTORS.get(5))
            ),
            new Face(
                    VECTORS.get(5).subtract(VECTORS.get(4)),
                    VECTORS.get(7).subtract(VECTORS.get(5)),
                    VECTORS.get(4).subtract(VECTORS.get(7))
            ),
            new Face(
                    VECTORS.get(0).subtract(VECTORS.get(1)),
                    VECTORS.get(6).subtract(VECTORS.get(0)),
                    VECTORS.get(1).subtract(VECTORS.get(6))
            ),
            new Face(
                    VECTORS.get(6).subtract(VECTORS.get(7)),
                    VECTORS.get(0).subtract(VECTORS.get(6)),
                    VECTORS.get(7).subtract(VECTORS.get(0))
            )
            );
    public Cube() {}

    public List<Vector> getVectors() {
        return VECTORS;
    }
    public List<Face> getFaces() {
        return FACES;
    }
}
