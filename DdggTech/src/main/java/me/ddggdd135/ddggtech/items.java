package me.ddggdd135.ddggtech;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.*;

public final class items {
    public static class Recipes{
        public static ItemStack[] millstone = new ItemStack[]{
                items.sandpaper,items.sandpaper,items.sandpaper,
                items.sandpaper,new ItemStack(IRON_INGOT),items.sandpaper,
                items.sandpaper,items.sandpaper,items.sandpaper
        };
        public static ItemStack[] sandpaper = new ItemStack[]{
                new ItemStack(SAND),new ItemStack(PAPER),null,
                null,null,null,
                null,null,null
        };
    }
    public static ItemGroup DdggTech_material = new ItemGroup(new NamespacedKey(DdggTech.getProvidingPlugin(DdggTech.class),"MATERIAL"),new ItemStack(BEDROCK));
    public static SlimefunItemStack sandpaper = new SlimefunItemStack("DDGGTECH_MATERIAL_PAPER",new ItemStack(PAPER),"&e砂纸");
    public static SlimefunItemStack millstone = new SlimefunItemStack("DDGGTECH_MATERIAL_MILLSTONE",new ItemStack(COBBLESTONE),"&e磨盘");
    public static SlimefunItem SANDPAPER = new SlimefunItem(DdggTech_material,sandpaper, RecipeType.ENHANCED_CRAFTING_TABLE,Recipes.sandpaper);
    public static SlimefunItem MILLSTONE = new SlimefunItem(DdggTech_material,millstone, RecipeType.ENHANCED_CRAFTING_TABLE,Recipes.millstone);
}
