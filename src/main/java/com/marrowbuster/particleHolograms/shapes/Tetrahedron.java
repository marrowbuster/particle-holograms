package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public abstract class Tetrahedron<G extends Tetrahedron<G>> extends Mesh<G> {
    public Tetrahedron(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }
}
