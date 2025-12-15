package com.marrowbuster.particleHolograms.shapes.util;

import com.marrowbuster.particleHolograms.shapes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class ObjLoader {
    public static ImportedMesh load(File file) throws IOException {
        List<Vector> vertices = new ArrayList<>();
        List<RawFace> faces = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                  continue;
                }

                String[] tokens = line.split("\\s+");

                switch (tokens[0]) {
                    case "v" -> vertices.add(new Vector(Float.parseFloat(tokens[1]),
                                Float.parseFloat(tokens[2]),
                                Float.parseFloat(tokens[3])));
                    case "f" -> {
                        List<RawIndex> indices = new ArrayList<>();
                        for (int i = 1; i < tokens.length; i++) {
                            String[] elements = tokens[i].split("/");
                            indices.add(new RawIndex(Integer.parseInt(elements[0]), -1, -1));
                        }
                        faces.add(new RawFace(indices));
                    }
                }
            }
            List<Triangle> triangles = getTriangles(faces, vertices);

            return new ImportedMesh(vertices, triangles);
        }
    }

    private static List<Triangle> getTriangles(List<RawFace> faces, List<Vector> vertices) {
        List<Triangle> triangles = new ArrayList<>();
        for (RawFace face : faces) {
            if (face.indices().size() < 3) {
                continue;
            }
            RawIndex i0 = face.indices().get(0);
            for (int i = 1; i < face.indices().size() - 1; i++) {
                RawIndex i1 = face.indices().get(i);
                RawIndex i2 = face.indices().get(i + 1);
                triangles.add(new Triangle(resolve(i0.v(), vertices.size()),
                                            resolve(i1.v(), vertices.size()),
                                            resolve(i2.v(), vertices.size())));
            }
        }
        return triangles;
    }

    private static int resolve(int index, int size) {
        return (index > 0) ? (index - 1) : (size + index);
    }
}
