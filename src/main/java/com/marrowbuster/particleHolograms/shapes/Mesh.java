package com.marrowbuster.particleHolograms.shapes;

import java.util.ArrayList;
import java.util.List;

public abstract class Mesh<G extends Mesh<G>> extends BaseMesh {

    protected Mesh(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }

    public G transform(VectorOperation vectorOperation) {
        List<Vector> transformedVectors = new ArrayList<Vector>(this.vectors.size());
            for (int i = 0; i < this.vectors.size(); i++) {
                transformedVectors.add(vectorOperation.apply(this.vectors.get(i), i));
            }
        return createNew(transformedVectors, this.triangles);
    }

    protected abstract G createNew(List<Vector> vectors, List<Triangle> triangles);
}
