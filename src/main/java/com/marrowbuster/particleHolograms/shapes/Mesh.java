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
        return createNew(transformedVectors, recalculateTriangles(transformedVectors));
    }

    protected List<Triangle> recalculateTriangles(List<Vector> transformedVectors) {
        List<Triangle> recalculatedTriangles = new ArrayList<>(triangles.size());
        for (Triangle t : triangles) {
            recalculatedTriangles.add(new Triangle(
                    transformedVectors.get(vectors.indexOf(t.v1())),
                    transformedVectors.get(vectors.indexOf(t.v2())),
                    transformedVectors.get(vectors.indexOf(t.v3()))
            ));
        }
        return recalculatedTriangles;
    }

    protected abstract Geometry createNew(List<Vector> vectors, List<Triangle> triangles);
}
