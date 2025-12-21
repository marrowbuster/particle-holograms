package com.marrowbuster.particleHolograms.shapes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMesh {
    @Getter
    protected final List<Vector> vectors;
    @Getter
    protected final List<Triangle> triangles;

    protected BaseMesh(List<Vector> vectors, List<Triangle> triangles) {
        this.vectors = vectors;
        this.triangles = triangles;
    }

    public Vector calculateCentroid(Triangle triangle) {
        Vector v1 = this.vectors.get(triangle.p1());
        Vector v2 = this.vectors.get(triangle.p2());
        Vector v3 = this.vectors.get(triangle.p3());

        return new Vector(
                (v1.x() + v2.x() + v3.x()) / 3,
                (v1.y() + v2.y() + v3.y()) / 3,
                (v1.z() + v2.z() + v3.z()) / 3
        );
    }

    public Vector calculateNormal(Triangle triangle) {
        Vector v1 = this.vectors.get(triangle.p1());
        Vector v2 = this.vectors.get(triangle.p2());
        Vector v3 = this.vectors.get(triangle.p3());

        return v2.subtract(v1).cross(v3.subtract(v1)).normalise();
    }

    public List<Vector> getTriangleNormals() {
        List<Vector> triangleNormals = new ArrayList<>(this.triangles.size());
        for (Triangle triangle : this.triangles) {
            triangleNormals.add(calculateNormal(triangle));
        }

        return triangleNormals;
    }

    public List<Vector> getVertexNormals() {
        List<Vector> vertexNormals = new ArrayList<>(this.vectors.size());
        for (int i = 0; i < this.vectors.size(); i++) {
            vertexNormals.add(new Vector(0, 0, 0));
        }

        for (Triangle triangle : this.triangles) {
            Vector triangleNormal = calculateNormal(triangle);

            for (int index : triangle.indices()) {
                vertexNormals.set(index, vertexNormals.get(index).add(triangleNormal));
            }
        }

        vertexNormals.replaceAll(vector -> vector.magnitude() == 0 ? vector : vector.normalise());
        return vertexNormals;
    }
}
