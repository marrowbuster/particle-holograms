package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public class Tetrahedron implements Hedron<Tetrahedron> {
    public static final List<Vector> VECTOR_LIST = List.of(new Vector(1/Math.sqrt(3), 1/Math.sqrt(3), 1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), -1/Math.sqrt(3), 1/Math.sqrt(3)),
            new Vector(-1/Math.sqrt(3), 1/Math.sqrt(3), -1/Math.sqrt(3)),
            new Vector(1/Math.sqrt(3), -1/Math.sqrt(3), -1/Math.sqrt(3)));

    public static final List<Face> FACES = List.of(
            new Face(List.of(VECTOR_LIST.get(0), VECTOR_LIST.get(1), VECTOR_LIST.get(2))),
            new Face(List.of(VECTOR_LIST.get(0), VECTOR_LIST.get(2), VECTOR_LIST.get(3))),
            new Face(List.of(VECTOR_LIST.get(0), VECTOR_LIST.get(3), VECTOR_LIST.get(1))),
            new Face(List.of(VECTOR_LIST.get(1), VECTOR_LIST.get(3), VECTOR_LIST.get(2)))
    );

    public static final int NUMBER_OF_FACES = 4;
    public static final int NUMBER_OF_VERTICES = 4;

    public Tetrahedron() {}

    @Override
    public List<Vector> getVectors() {
        return VECTOR_LIST;
    }

    @Override
    public List<Face> getFaces() {
        return FACES;
    }

    public Tetrahedron getGeometry() {
        return this;
    }
}
