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
        double[] vec2 = {4d, 5d, 6d};
        assertEquals(new Vector(5, 7, 9), v1.add(vec2[0], vec2[1], vec2[2]));
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
}
