package com.marrowbuster.particleHolograms.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TetrahedronTest {

    private static final double N = 1.0 / Math.sqrt(3.0);

    @Test
    public void createsTetrahedron() {
        Tetrahedron tetrahedron = new Tetrahedron();
        assertNotNull(tetrahedron);

        assertEquals(tetrahedron.getTriangles(), List.of(
                new Triangle(0, 1, 2),
                new Triangle(0, 2, 3),
                new Triangle(0, 3, 1),
                new Triangle(1, 3, 2)
        ));

        assertEquals(tetrahedron.getVectors(), List.of(
                new Vector( N,  N,  N),
                new Vector(-N, -N,  N),
                new Vector(-N,  N, -N),
                new Vector( N, -N, -N)
        ));
    }

    @Test
    public void translatesTetrahedronByAddingOneToXCoordinates() {
        Tetrahedron tetrahedron = new Tetrahedron();
        Tetrahedron transformedTetrahedron = tetrahedron.transform((v, i) ->
                new Vector(v.x() + 1, v.y(), v.z()));

        assertNotSame(tetrahedron, transformedTetrahedron);
        assertEquals(tetrahedron.getTriangles(), transformedTetrahedron.getTriangles());

        List<Vector> originalVectors = tetrahedron.getVectors();
        List<Vector> transformedVectors = transformedTetrahedron.getVectors();

        for (int i = 0; i < originalVectors.size(); i++) {
            Vector originalVector = originalVectors.get(i);
            Vector transformedVector = transformedVectors.get(i);

            assertEquals(originalVector.x() + 1, transformedVector.x());
            assertEquals(originalVector.y(), transformedVector.y());
            assertEquals(originalVector.z(), transformedVector.z());
        }
    }

    @Test
    public void scalesTetrahedronByTwo() {
        Tetrahedron tetrahedron = new Tetrahedron();
        Tetrahedron transformedTetrahedron = tetrahedron.transform((v, i) ->
                new Vector(v.x(), v.y(), v.z()).scale(2));

        assertNotSame(tetrahedron, transformedTetrahedron);
        assertEquals(tetrahedron.getTriangles(), transformedTetrahedron.getTriangles());

        List<Vector> originalVectors = tetrahedron.getVectors();
        List<Vector> transformedVectors = transformedTetrahedron.getVectors();

        for (int i = 0; i < originalVectors.size(); i++) {
            Vector originalVector = originalVectors.get(i);
            Vector transformedVector = transformedVectors.get(i);

            assertEquals(originalVector.scale(2), transformedVector);
        }
    }
}
