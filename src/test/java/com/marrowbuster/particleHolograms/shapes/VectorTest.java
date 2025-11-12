package com.marrowbuster.particleHolograms.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VectorTest {

    @Test
    @DisplayName("[1, 2, 3] + [4, 5, 6] = [5, 7, 9]")
    void addsTwoVectors() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        assertEquals(new Vector(5, 7, 9), v1.add(v2));
    }

    @Test
    @DisplayName("[1, 2, 3] + {x: 4d, y: 5d, z: 6d} = [5, 7, 9]")
    void addsThreeDoublesToVector() {
        Vector v1 = new Vector(1, 2, 3);
        double[] v2 = {4d, 5d, 6d};
        assertEquals(new Vector(5d, 7d, 9d), v1.add(v2[0], v2[1], v2[2]));
    }

    @Test
    @DisplayName("[1, 2, 3] + {x: 4, y: 5f, z: 6d} = [5, 7, 9]")
    void addsThreeNumbersToVector() {
        Vector v1 = new Vector(1, 2, 3);
        int v2x = 4;
        float v2y = 5f;
        double v2z = 6d;
        assertEquals(new Vector(5, 7f, 9d), v1.add(v2x, v2y, v2z));
    }

    @Test
    @DisplayName("[1, 2, 3] + {4, 5, 6} = [5, 7, 9]")
    void addsListOfIntegersToVector() {
        Vector v1 = new Vector(1, 2, 3);
        List<Integer> v2 = List.of(4, 5, 6);
        assertEquals(new Vector(5, 7, 9), v1.add(v2));
    }

    @Test
    @DisplayName("[1, 2, 3] + map:{'x': 4, 'y': 5, 'z': 6} = [5, 7, 9]")
    void addsMapOfIntegersToVector() {
        Vector v1 = new Vector(1, 2, 3);
        Map<String, Integer> v2 = Map.of("x", 4,
                "y", 5,
                "z", 6);
        assertEquals(new Vector(5, 7, 9), v1.add(v2));
    }

    @Test
    @DisplayName("[4, 5, 6] - [1, 2, 3] = [3, 3, 3]")
    void subtractsTwoVectors() {
        Vector v1 = new Vector(4, 5, 6);
        Vector v2 = new Vector(1, 2, 3);
        assertEquals(new Vector(3, 3, 3), v1.subtract(v2));
    }

    @Test
    @DisplayName("[1, 2, 3] - [4, 5, 6] = [-3, -3, -3]")
    void subtractsTwoVectorsAndResultsInNegativeValues() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        assertEquals(new Vector(-3, -3, -3), v1.subtract(v2));
    }

    @Test
    @DisplayName("[4, 5, 6] - {x: 1d, y: 2d, z: 3d} = [3, 3, 3]")
    void subtractsThreeDoublesFromVector() {
        Vector v1 = new Vector(4, 5, 6);
        double[] v2 = {1d, 2d, 3d};
        assertEquals(new Vector(3d, 3d, 3d), v1.subtract(v2[0], v2[1], v2[2]));
    }


    @Test
    @DisplayName("[1, 2, 3] - {x: 4d, y: 5d, z: 6d} = [-3, -3, -3]")
    void subtractsThreeDoublesFromVectorAndResultsInNegativeValues() {
        Vector v1 = new Vector(1, 2, 3);
        double[] v2 = {4d, 5d, 6d};
        assertEquals(new Vector(-3d, -3d, -3d), v1.subtract(v2[0], v2[1], v2[2]));
    }

    @Test
    @DisplayName("[4, 5, 6] - {x: 1, y: 2f, z: 3d} = [3, 3, 3]")
    void subtractsThreeNumbersFromVector() {
        Vector v1 = new Vector(4, 5, 6);
        int v2x = 1;
        float v2y = 2f;
        double v2z = 3d;
        assertEquals(new Vector(3, 3f, 3d), v1.subtract(v2x, v2y, v2z));
    }

    @Test
    @DisplayName("[1, 2, 3] - {x: 4, y: 5f, z: 6d} = [-3, -3, -3]")
    void subtractsThreeNumbersFromVectorAndResultsInNegativeValues() {
        Vector v1 = new Vector(1, 2, 3);
        int v2x = 4;
        float v2y = 5f;
        double v2z = 6d;
        assertEquals(new Vector(-3, -3f, -3d), v1.subtract(v2x, v2y, v2z));
    }

    @Test
    @DisplayName("[4, 5, 6] - {1, 2, 3} = [3, 3, 3]")
    void subtractsListOfIntegersFromVector() {
        Vector v1 = new Vector(4, 5, 6);
        List<Integer> v2 = List.of(1, 2, 3);
        assertEquals(new Vector(3, 3, 3), v1.subtract(v2));
    }

    @Test
    @DisplayName("[1, 2, 3] - {4, 5, 6} = [-3, -3, -3]")
    void subtractsListOfIntegersFromVectorAndResultsInNegativeValues() {
        Vector v1 = new Vector(1, 2, 3);
        List<Integer> v2 = List.of(4, 5, 6);
        assertEquals(new Vector(-3, -3, -3), v1.subtract(v2));
    }

    @Test
    @DisplayName("[4, 5, 6] - map:{'x': 1, 'y': 2, 'z': 3} = [3, 3, 3]")
    void SubtractsMapOfIntegersFromVector() {
        Vector v1 = new Vector(4, 5, 6);
        Map<String, Integer> v2 = Map.of("x", 1,
                "y", 2,
                "z", 3);
        assertEquals(new Vector(3, 3, 3), v1.subtract(v2));
    }

    @Test
    @DisplayName("[1, 2, 3] - map:{'x': 4, 'y': 5, 'z': 6} = [-3, -3, -3]")
    void SubtractsMapOfIntegersFromVectorAndResultsInNegativeValues() {
        Vector v1 = new Vector(1, 2, 3);
        Map<String, Integer> v2 = Map.of("x", 4,
                "y", 5,
                "z", 6);
        assertEquals(new Vector(-3, -3, -3), v1.subtract(v2));
    }

    @Test
    @DisplayName("[1, 2, 3] * 2 = [2, 4, 6]")
    void ScalesVector() {
        Vector v1 = new Vector(1, 2, 3);
        assertEquals(new Vector(2, 4, 6), v1.scale(2));
    }

    @Test
    @DisplayName("[1, 2, 3] * -2 = [-2, -4. -6]")
    void scalesVectorAndResultsInNegativeValues() {
        Vector v1 = new Vector(1, 2, 3);
        assertEquals(new Vector(-2, -4, -6), v1. scale(-2));
    }

    @Test
    @DisplayName("[1, 2, 3] • [4, 5, 6] = 32")
    void calculatesDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        assertEquals(32, v1.dot(v2));
    }

    @Test
    @DisplayName("[1, 2, 3] x [4, 5, 6] = [-3, 6, -3")
    void calculatesCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        assertEquals(new Vector(-3, 6, -3), v1.cross(v2));
    }

    @Test
    @DisplayName("magnitude([1, 2, 3]) = sqrt(14)")
    void computesMagnitude() {
        Vector v1 = new Vector(1, 2, 3);
        assertEquals(Math.sqrt(14), v1. magnitude());
    }

    @Test
    @DisplayName("normalise([1, 2, 3]) = [1/sqrt(14), 2/sqrt(14), 3/sqrt(14)]")
    void normalises() {
        Vector v1 = new Vector(1, 2, 3);
        assertEquals(new Vector(1 / Math.sqrt(14), 2/Math.sqrt(14), 3/Math.sqrt(14)), v1.normalise());
    }

    @Test
    @DisplayName("normalize([1, 2, 3]) = [1/sqrt(14), 2/sqrt(14), 3/sqrt(14)]")
    void normalizes() {
        Vector v1 = new Vector(1, 2, 3);
        assertEquals(new Vector(1 / Math.sqrt(14), 2/Math.sqrt(14), 3/Math.sqrt(14)), v1.normalize());
    }

    @Test
    @DisplayName("new Vector({1, 2, 3}) = [1, 2, 3]")
    void createsVectorFromList() {
        List<Byte> v1 = List.of((byte) 1, (byte) 2, (byte) 3);
        assertEquals(new Vector(1, 2, 3), Vector.of(v1));
    }

    @Test
    @DisplayName("[1, 2, 3].toList() = {1, 2, 3}")
    void convertsVectorToList() {
        Vector v1 = new Vector(1, 2, 3);
        assertEquals(List.of(1d, 2d, 3d), v1.toList());
    }

    @Test
    @DisplayName("new Vector(map:{'x': 1, 'y': 2, 'z': 3}) = [1, 2, 3]")
    void createsVectorFromMap() {
        Map<String, Short> v1 = Map.of("x", (short) 1,
                "y", (short) 2,
                "z", (short) 3);
        assertEquals(new Vector(1, 2, 3), Vector.of(v1));
    }

    @Test
    @DisplayName("[1, 2, 3].toMap() = map:{'x': 1, 'y': 2, 'z': 3}")
    void convertsVectorToMap() {
        Vector v1 = new Vector(1, 2, 3);
        assertEquals(Map.of("x", 1d,
                "y", 2d,
                "z", 3d), v1.toMap());
    }

    @Test
    @DisplayName("[1, 2, 3].invert() = [-1, -2, -3]")
    void InvertsVector() {
        Vector v1 = new Vector(1, 2, 3);
        assertEquals(new Vector(-1, -2, -3), v1.invert());
    }
}
