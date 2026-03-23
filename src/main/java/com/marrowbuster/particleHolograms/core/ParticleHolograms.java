package com.marrowbuster.particleHolograms.core;

import com.marrowbuster.particleHolograms.command.HologramCommand;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class ParticleHolograms extends JavaPlugin {

    public static ParticleHolograms instance;
    private HologramManager hologramManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        this.hologramManager = new HologramManager();

        getLifecycleManager()
                .registerEventHandler(LifecycleEvents.COMMANDS,
                        event -> event
                                .registrar()
                                .register("hologram", new HologramCommand(this)));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HologramManager getHologramManager() {
        return hologramManager;
    }
}
