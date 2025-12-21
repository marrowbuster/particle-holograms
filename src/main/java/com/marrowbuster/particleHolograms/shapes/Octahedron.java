package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public abstract class Octahedron<G extends Octahedron<G>> extends Mesh<G> {
    public Octahedron(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }
}
