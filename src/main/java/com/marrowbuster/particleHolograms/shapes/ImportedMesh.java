package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public class ImportedMesh extends Mesh<ImportedMesh> {
    public ImportedMesh(List<Vector> vectors, List<Triangle> triangles) {
        super(vectors, triangles);
    }

    @Override
    public ImportedMesh createNew(List<Vector> vectors, List<Triangle> triangles) { return new ImportedMesh(vectors, triangles); }
}
