package com.marrowbuster.particleHolograms.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TetrahedronTest {

    @Test
    public void translatesTetrahedronByAddingOneToX() {
        Tetrahedron tetrahedron = new Tetrahedron();
        Tetrahedron transformedTetrahedron = tetrahedron.transform((v, i) ->
                new Vector(v.getX() + 1, v.getY(), v.getZ()));

        assertNotSame(tetrahedron, transformedTetrahedron);
        assertEquals(tetrahedron.getTriangles(), transformedTetrahedron.getTriangles());

        List<Vector> originalVectors = tetrahedron.getVectors();
        List<Vector> transformedVectors = transformedTetrahedron.getVectors();

        for (int i = 0; i < originalVectors.size(); i++) {
            Vector originalVector = originalVectors.get(i);
            Vector transformedVector = transformedVectors.get(i);

            assertEquals(originalVector.getX() + 1, transformedVector.getX());
            assertEquals(originalVector.getY(), transformedVector.getY());
            assertEquals(originalVector.getZ(), transformedVector.getZ());
        }
    }
}
