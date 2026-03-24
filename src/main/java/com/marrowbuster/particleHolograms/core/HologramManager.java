package com.marrowbuster.particleHolograms.core;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HologramManager {
    @Getter
    private final Map<UUID, Hologram> activeHolograms = new HashMap<>();

    public void register(Hologram hologram) {
        activeHolograms.put(UUID.randomUUID(), hologram);
        hologram.spawn();
    }

    public void clearAll() {
        activeHolograms.values().forEach(Hologram::remove);
        activeHolograms.clear();
    }
}
