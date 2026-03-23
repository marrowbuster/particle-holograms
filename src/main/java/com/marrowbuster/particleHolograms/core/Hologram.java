package com.marrowbuster.particleHolograms.core;

import org.bukkit.Location;

public interface Hologram {
    void spawn();
    void tick();
    void remove();
    Location getLocation();
}
