package me.ddggdd135.ddggtech;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;

import static me.ddggdd135.ddggtech.items.*;
import static org.bukkit.Material.*;

public final class DdggTech extends JavaPlugin implements SlimefunAddon {
    public static FileConfiguration Saves;
    public static FileConfiguration language;
    public static FileConfiguration config;
    public static DdggTech Instance;
    public static DdggTech getInstance(){
        return Instance;
    }
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
        Instance = this;
        ItemStack tmp = new ItemStack(REDSTONE);
        ItemMeta itemMeta = tmp.getItemMeta();
        itemMeta.setDisplayName("§e合成材料");
        tmp.setItemMeta(itemMeta);
        ItemStack tmp2 = new ItemStack(CHEST);
        ItemMeta itemMeta2 = tmp.getItemMeta();
        itemMeta2.setDisplayName("§eDdggTech物品");
        tmp2.setItemMeta(itemMeta2);
        ItemGroup DdggTech_material = new ItemGroup(new NamespacedKey(this,"MATERIAL"),tmp);
        ItemGroup DdggTech_items = new ItemGroup(new NamespacedKey(this,"ITEMS"),tmp2);
        DdggTech_material.register(this);
        DdggTech_items.register(this);
        SlimefunItem SANDPAPER = new SlimefunItem(DdggTech_material,sandpaper, RecipeType.ENHANCED_CRAFTING_TABLE, items.Recipes.sandpaper,sandpaper);
        SlimefunItem MILLSTONE = new SlimefunItem(DdggTech_material,millstone, RecipeType.ENHANCED_CRAFTING_TABLE, items.Recipes.millstone,millstone);

        SANDPAPER.register(this);
        MILLSTONE.register(this);
        DdggTech_items.add(SANDPAPER);
        DdggTech_items.add(MILLSTONE);
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

}
