package me.marcus.spawnerrewards.config;

import me.marcus.spawnerrewards.SpawnerRewards;
import me.marcus.spawnerrewards.util.SpawnerType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ConfigHandler {

    public static String FISHING_PERMISSION;
    public static String MINING_PERMISSION;

    public static String RECEIVED_SPAWNER_MESSAGE;

    public static int CHANCE_FISHING;
    public static int CHANCE_MINING;

    public static ItemStack SPAWNER;

    public static List<String> MINING_BLOCKS = new ArrayList<>();

    public ConfigHandler() {
        ConfigCursor mainConfigCursor = new ConfigCursor(SpawnerRewards.getInstance().getMainConfig(), "");

        FISHING_PERMISSION = mainConfigCursor.getString("FISHING_PERMISSION");
        MINING_PERMISSION = mainConfigCursor.getString("MINING_PERMISSION");

        RECEIVED_SPAWNER_MESSAGE = mainConfigCursor.getString("RECEIVED_SPAWNER_MESSAGE");

        CHANCE_FISHING = mainConfigCursor.getInt("CHANCE_FISHING");
        CHANCE_MINING = mainConfigCursor.getInt("CHANCE_MINING");

        SPAWNER = new ItemStack(Material.MOB_SPAWNER, 1, (short) SpawnerType.valueOf(mainConfigCursor.getString("MOB_SPAWNER")).getId());

        MINING_BLOCKS.addAll(mainConfigCursor.getStringList("MINING_BLOCKS"));
    }
}
