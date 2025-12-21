package com.marrowbuster.particleHolograms.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RegularTetrahedronTest {

    private static final double N = 1.0 / Math.sqrt(3.0);

    @Test
    @DisplayName("creates a tetrahedron")
    public void createsTetrahedron() {
        RegularTetrahedron regularTetrahedron = new RegularTetrahedron();
        assertNotNull(regularTetrahedron);

        assertEquals(regularTetrahedron.getTriangles(), List.of(
                new Triangle(0, 1, 2),
                new Triangle(0, 2, 3),
                new Triangle(0, 3, 1),
                new Triangle(1, 3, 2)
        ));

        assertEquals(regularTetrahedron.getVectors(), List.of(
                new Vector( N,  N,  N),
                new Vector(-N, -N,  N),
                new Vector(-N,  N, -N),
                new Vector( N, -N, -N)
        ));
    }

    @Test
    public void translatesTetrahedronByAddingOneToXCoordinates() {
        RegularTetrahedron regularTetrahedron = new RegularTetrahedron();
        RegularTetrahedron transformedRegularTetrahedron = regularTetrahedron.transform((v, i) ->
                new Vector(v.x() + 1, v.y(), v.z()));

        assertNotSame(regularTetrahedron, transformedRegularTetrahedron);
        assertEquals(regularTetrahedron.getTriangles(), transformedRegularTetrahedron.getTriangles());

        List<Vector> originalVectors = regularTetrahedron.getVectors();
        List<Vector> transformedVectors = transformedRegularTetrahedron.getVectors();

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
        RegularTetrahedron regularTetrahedron = new RegularTetrahedron();
        RegularTetrahedron transformedRegularTetrahedron = regularTetrahedron.transform((v, i) ->
                new Vector(v.x(), v.y(), v.z()).scale(2));

        assertNotSame(regularTetrahedron, transformedRegularTetrahedron);
        assertEquals(regularTetrahedron.getTriangles(), transformedRegularTetrahedron.getTriangles());

        List<Vector> originalVectors = regularTetrahedron.getVectors();
        List<Vector> transformedVectors = transformedRegularTetrahedron.getVectors();

        for (int i = 0; i < originalVectors.size(); i++) {
            Vector originalVector = originalVectors.get(i);
            Vector transformedVector = transformedVectors.get(i);

            assertEquals(originalVector.scale(2), transformedVector);
        }
    }
}
