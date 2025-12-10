package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public abstract class Hexahedron<Geometry extends Hexahedron<Geometry>> extends Mesh<Geometry> {
    public static final int NUMBER_OF_FACES = 6;
    protected Hexahedron(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }
}
