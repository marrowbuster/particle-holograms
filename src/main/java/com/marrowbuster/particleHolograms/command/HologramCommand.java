package com.marrowbuster.particleHolograms.command;

import com.marrowbuster.particleHolograms.core.Hologram;
import com.marrowbuster.particleHolograms.core.HologramBuilder;
import com.marrowbuster.particleHolograms.core.ParticleHolograms;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HologramCommand implements BasicCommand {
    private final ParticleHolograms plugin;
    public final List<String> hologramShapes = List.of("cube", "regularoctahedron", "regulartetrahedron");

    public HologramCommand(ParticleHolograms plugin) {
        this.plugin = plugin;
    }
    @Override
    public void execute(@NotNull CommandSourceStack source, String[] args) {
        if (args[0].equalsIgnoreCase("clear")) {
            plugin.getHologramManager().clearAll();
            source.getSender().sendRichMessage("<green>All holograms purged.");
            return;
        } else if (args[0].equalsIgnoreCase("list")) {
            plugin.getHologramManager().getActiveHolograms().forEach(
                    (uuid, hologram) ->
                        source
                                .getSender()
                                .sendRichMessage("<green>UUID: " +
                                        uuid.toString() +
                                        ", mesh is " +
                                        hologram
                                                .getMesh()
                                                .getClass()
                                                .getSimpleName()));
            return;
        } else if (args.length < 3) {
            source.getSender().sendRichMessage("<red>Usage: /hologram <shape> <particle> <size>");
            return;
        }

        String shape = args[0].toLowerCase();
        String particleName = args[1].toUpperCase();
        double size = Double.parseDouble(args[2]);
        try {
            Particle particle = Particle.valueOf(particleName);
            Location loc = source.getLocation();

            Hologram hologram = new HologramBuilder()
                    .type(shape)
                    .at(loc)
                    .withParticle(particle)
                    .size(size)
                    .withColor(Color.AQUA)
                    .build();

            plugin.getHologramManager().register(hologram);
            source.getSender().sendRichMessage("<green>Spawned " + shape + " hologram!");
        } catch (IllegalArgumentException e) {
            source.getSender().sendRichMessage("<red>Invalid particle or shape.");
        }
    }
}
