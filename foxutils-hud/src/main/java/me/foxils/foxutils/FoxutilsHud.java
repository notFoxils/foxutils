package me.foxils.foxutils;

import org.bukkit.plugin.java.JavaPlugin;

public final class FoxutilsHud extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        HudRegistry.registerPluginHuds(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}