package me.marcus.spawnerrewards;

import lombok.Getter;

import me.marcus.spawnerrewards.config.FileConfig;
import me.marcus.spawnerrewards.config.ConfigHandler;
import me.marcus.spawnerrewards.listener.PlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class SpawnerRewards extends JavaPlugin {

    @Getter
    private static SpawnerRewards instance;

    private FileConfig mainConfig;

    private void registerListener() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onEnable() {
        instance = this;

        this.mainConfig = new FileConfig(this, "config.yml");

        new ConfigHandler();

        this.registerListener();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
