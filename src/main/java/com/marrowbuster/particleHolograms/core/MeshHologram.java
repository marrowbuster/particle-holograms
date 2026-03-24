package com.marrowbuster.particleHolograms.core;

import com.marrowbuster.particleHolograms.shapes.BaseMesh;
import com.marrowbuster.particleHolograms.shapes.Vector;
import lombok.Getter;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

public class MeshHologram implements Hologram {
    private final BaseMesh mesh;
    private final Location location;
    private final Particle particle;
    private final double size;
    private final Color color;

    private BukkitTask task;
    private final List<Vector> cachedPoints;

    public MeshHologram(BaseMesh mesh, Location location, Particle particle, double size, Color color) {
        this.mesh = mesh;
        this.location = location;
        this.particle = particle;
        this.size = size;
        this.color = color;
        this.cachedPoints = mesh.getWireframePoints(0.1);
    }

    @Override
    public void spawn() {
        if (this.task != null) {
            this.task.cancel();
        }

        ParticleHolograms plugin = ParticleHolograms.getInstance();
        if (plugin != null && plugin.isEnabled()) {
            this.task = plugin.getServer().getScheduler().runTaskTimer(plugin, this::tick, 0, 1);
        }
    }

    @Override
    public void tick() {
        for (Vector v : cachedPoints) {
            Location particleLocation = location.clone().add(v.x() * size, v.y() * size, v.z() * size);

            if (particle == Particle.DUST) {
                particleLocation.getWorld().spawnParticle(Particle.DUST, particleLocation, 1, new Particle.DustOptions(color, (float) size));
            } else {
                particleLocation.getWorld().spawnParticle(particle, particleLocation, 1, 0, 0, 0);
            }
        }
    }

    @Override
    public void remove() {
        if (task != null) {
            task.cancel();
        }
    }

    @Override
    public BaseMesh getMesh() {
        return mesh;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
