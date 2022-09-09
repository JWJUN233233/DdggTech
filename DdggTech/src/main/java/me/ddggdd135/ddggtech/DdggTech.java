package me.ddggdd135.ddggtech;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;

public final class DdggTech extends JavaPlugin implements SlimefunAddon {
    public static FileConfiguration Saves;
    public static FileConfiguration language;
    public static FileConfiguration config;
    public FileConfiguration GetConfig(String ConfigName){
        File tmp = new File(DdggTech.getPlugin(DdggTech.class).getDataFolder(),ConfigName + ".yml");
        if(!tmp.exists()){
            try {
                saveResource(ConfigName + ".yml", false);
            } finally {
                try {
                    tmp.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return YamlConfiguration.loadConfiguration(tmp);
    }
    public static void SaveConfig(FileConfiguration configuration, String ConfigName){
        try {
            configuration.save(new File(DdggTech.getPlugin(DdggTech.class).getDataFolder(),ConfigName + ".yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        items.DdggTech_material.register(this);
        items.SANDPAPER.register(this);
        items.MILLSTONE.register(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return null;
    }

    @Nonnull
    @Override
    public String getPluginVersion() {
        return SlimefunAddon.super.getPluginVersion();
    }

    @Override
    public boolean hasDependency(@Nonnull String dependency) {
        return SlimefunAddon.super.hasDependency(dependency);
    }

    @Nullable
    @Override
    public String getWikiURL() {
        return SlimefunAddon.super.getWikiURL();
    }
}
