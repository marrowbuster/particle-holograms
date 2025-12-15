package com.marrowbuster.particleHolograms.shapes.util;

import com.marrowbuster.particleHolograms.shapes.ImportedMesh;
import com.marrowbuster.particleHolograms.shapes.Triangle;
import com.marrowbuster.particleHolograms.shapes.Vector;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ObjLoaderTest {

    @Test
    public void loadsTetrahedronObjFile() {
        try {
            ImportedMesh importedMesh = ObjLoader.load(new File("./src/test/java/com/marrowbuster/particleHolograms/shapes/Tetrahedron.obj"));
            assertNotNull(importedMesh);

            assertEquals(importedMesh.getVectors(), List.of(new Vector(1, 1, 1),
                                                            new Vector(-1, -1, 1),
                                                            new Vector(-1, 1, -1),
                                                            new Vector(1, -1, -1)));

            assertEquals(importedMesh.getTriangles(), List.of(new Triangle(0, 1, 2),
                                                              new Triangle(0, 2, 3),
                                                              new Triangle(0, 3, 1),
                                                              new Triangle(1, 3, 2)));

        } catch (IOException ioException) {
            System.out.println("Obj file not found");
        }
    }
}
