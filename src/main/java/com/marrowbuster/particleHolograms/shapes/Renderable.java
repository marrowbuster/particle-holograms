package com.marrowbuster.particleHolograms.shapes;

import java.util.List;

public interface Renderable {
    List<Vector> getWireframePoints(double step);
}
