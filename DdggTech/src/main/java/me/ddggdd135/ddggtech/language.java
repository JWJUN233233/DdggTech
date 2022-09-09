package me.ddggdd135.ddggtech;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.Objects;

public class language {
    public static String getMessage(@Nonnull String path){
        return CMIChatColor.translate(DdggTech.language.getString(path));
    }

    public static String getMessage(@Nonnull String path, @Nonnull Player player){
        if(Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null){

            Location playerloc = player.getLocation();
            String playerLocation = playerloc.getX() + " " + playerloc.getY() + " " + playerloc.getZ();
            return PlaceholderAPI.setPlaceholders(player,
                    Objects.requireNonNull(
                            CMIChatColor.translate(
                                    DdggTech.language.getString(path)
                                            .replace("[playerLocation]",playerLocation)
                                            .replace("[playerWorld]",player.getLocation().getWorld().getName())
                                            .replace("[playerName]",player.getName()))));
        }
        Location playerloc = player.getLocation();
        String playerLocation = String.valueOf(playerloc.getX()) + " " + String.valueOf(playerloc.getY()) + " " + String.valueOf(playerloc.getZ());
        return CMIChatColor.translate(DdggTech.language.getString(path)
                .replace("[playerLocation]",playerLocation)
                .replace("[playerWorld]",player.getLocation().getWorld().getName())
                .replace("[playerName]",player.getName()));
    }
}

