package com.marrowbuster.particleHolograms.core;

import com.marrowbuster.particleHolograms.shapes.BaseMesh;
import org.bukkit.Location;

public interface Hologram {
    void spawn();
    void tick();
    void remove();
    BaseMesh getMesh();
    Location getLocation();
}
