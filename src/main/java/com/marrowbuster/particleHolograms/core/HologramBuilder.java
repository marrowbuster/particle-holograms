package com.marrowbuster.particleHolograms.core;

import com.marrowbuster.particleHolograms.shapes.BaseMesh;
import com.marrowbuster.particleHolograms.shapes.Cube;
import com.marrowbuster.particleHolograms.shapes.RegularTetrahedron;
import com.marrowbuster.particleHolograms.shapes.RegularOctahedron;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;

public class HologramBuilder {
    private String shapeType;
    private Location location;
    private Particle particle;
    private double size;
    private Color color;

    public HologramBuilder type(String shapeType) {
        this.shapeType = shapeType.toLowerCase();
        return this;
    }

    public HologramBuilder at(Location location) {
        this.location = location;
        return this;
    }

    public HologramBuilder withParticle(Particle particle) {
        this.particle = particle;
        return this;
    }

    public HologramBuilder size(double size) {
        this.size = size;
        return this;
    }

    public HologramBuilder withColor(Color color) {
        this.color = color;
        return this;
    }

    public Hologram build() throws IllegalArgumentException {
        BaseMesh mesh = switch (shapeType.toLowerCase()) {
            case "cube" -> new Cube();
            case "regularoctahedron" -> new RegularOctahedron();
            case "regulartetrahedron" -> new RegularTetrahedron();
            default -> throw new IllegalArgumentException("Unknown shape: " + shapeType);
        };

        return new MeshHologram(mesh, location, particle, size, color);
    }
}
