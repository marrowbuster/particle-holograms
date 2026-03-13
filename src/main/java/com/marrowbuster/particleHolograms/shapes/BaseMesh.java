package com.marrowbuster.particleHolograms.shapes;

import lombok.Getter;

import java.util.*;

public abstract class BaseMesh {
    @Getter
    protected final List<Vector> vectors;
    @Getter
    protected final List<Triangle> triangles;

    protected final Set<Edge> cachedEdges;

    protected BaseMesh(List<Vector> vectors, List<Triangle> triangles) {
        this.vectors = vectors;
        this.triangles = triangles;
        this.cachedEdges = generateEdges(triangles);
    }

    private void addEdgePoints(List<Vector> points, Vector start, Vector end, double step) {
        double distance = start.subtract(end).magnitude();
        int count = (int) (distance / step);
        for (int index = 0; index <= count; index++) {
            double t = (double) index / count;
            points.add(new Vector(
                    start.x() + (end.x() - start.x()) * t,
                    start.y() + (end.y() - start.y()) * t,
                    start.z() + (end.z() - start.z()) * t
            ));
        }
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

    private Set<Edge> generateEdges(List<Triangle> triangles) {
        Set<Edge> edges = new HashSet<>();
        for (Triangle triangle : triangles) {
            edges.add(new Edge(triangle.p1(), triangle.p2()));
            edges.add(new Edge(triangle.p2(), triangle.p3()));
            edges.add(new Edge(triangle.p1(), triangle.p3()));
        }

        return Collections.unmodifiableSet(edges);
    }

    public List<Vector> getTriangleNormals() {
        List<Vector> triangleNormals = new ArrayList<>(this.triangles.size());
        for (Triangle triangle : this.triangles) {
            triangleNormals.add(calculateNormal(triangle));
        }

        return triangleNormals;
    }

    public List<Vector> getVertexNormals() {
        Vector[] normals = new Vector[this.vectors.size()];
        Arrays.fill(normals, Vector.ZERO);

        for (Triangle triangle : this.triangles) {
            Vector triangleNormal = calculateNormal(triangle);
            for (int index : triangle.indices()) {
                normals[index] = normals[index].add(triangleNormal);
            }
        }

        return Arrays.stream(normals)
                .map(vector -> vector.magnitude() < Vector.EPSILON ? vector : vector.normalise())
                .toList();
    }

    public List<Vector> getWireframePoints(double particleDistance) {
        List<Vector> points = new ArrayList<>();
        Set<Edge> processedEdges = new HashSet<>();

        for (Triangle triangle : this.triangles) {
            Edge[] edges = {
                    new Edge(triangle.p1(), triangle.p2()),
                    new Edge(triangle.p2(), triangle.p3()),
                    new Edge(triangle.p1(), triangle.p3())
            };

            for (Edge edge : edges) {
                if (processedEdges.add(edge)) {
                    Vector vStart = this.vectors.get(edge.p1());
                    Vector vEnd = this.vectors.get(edge.p2());

                    addEdgePoints(points, vStart, vEnd, particleDistance);
                }
            }
        }

        return points;
    }
}
