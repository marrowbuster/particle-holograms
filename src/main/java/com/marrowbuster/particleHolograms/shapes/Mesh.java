package com.marrowbuster.particleHolograms.shapes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Mesh<Geometry extends Mesh<Geometry>> {
    @Getter
    protected final List<Vector> vectors;
    @Getter
    protected final List<Triangle> triangles;


    protected Mesh(List<Vector> vectors, List<Triangle> triangles) {
        this.vectors = vectors;
        this.triangles = triangles;
    }

    public Geometry transform(VectorOperation vectorOperation) {
        List<Vector> transformedVectors = new ArrayList<Vector>(this.vectors.size());
            for (int i = 0; i < this.vectors.size(); i++) {
                transformedVectors.add(vectorOperation.apply(this.vectors.get(i), i));
            }
        return createNew(transformedVectors, triangles);
    }

    public Vector calculateNormal(Triangle triangle) {
        Vector v1 = vectors.get(triangle.p1());
        Vector v2 = vectors.get(triangle.p2());
        Vector v3 = vectors.get(triangle.p3());

        return v2.subtract(v1).cross(v3.subtract(v1)).normalise();
    }

    public Vector calculateCentroid(Triangle triangle) {
        Vector v1 = vectors.get(triangle.p1());
        Vector v2 = vectors.get(triangle.p2());
        Vector v3 = vectors.get(triangle.p3());

        return new Vector(
                (v1.getX() + v2.getX() + v3.getX()) / 3,
                (v1.getY() + v2.getY() + v3.getY()) / 3,
                (v1.getZ() + v2.getZ() + v3.getZ()) / 3
                );
    }

    protected abstract Geometry createNew(List<Vector> vectors, List<Triangle> triangles);
}
