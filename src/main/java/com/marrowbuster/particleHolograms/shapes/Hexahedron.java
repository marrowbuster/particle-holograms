package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public abstract class Hexahedron<G extends Hexahedron<G>> extends Mesh<G> {
    public static final int NUMBER_OF_FACES = 6;
    protected Hexahedron(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }
}
