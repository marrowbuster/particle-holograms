package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public abstract class Hexahedron<G extends Hexahedron<G>> extends Mesh<G> {
    protected Hexahedron(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }
}
