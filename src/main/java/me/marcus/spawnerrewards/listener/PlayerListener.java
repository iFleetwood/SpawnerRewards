package me.marcus.spawnerrewards.listener;

import me.marcus.spawnerrewards.config.ConfigHandler;
import me.marcus.spawnerrewards.util.ChatUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.Random;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        Player player = event.getPlayer();

        if (event.isCancelled()) {
            return;
        }

        if (!player.hasPermission(ConfigHandler.FISHING_PERMISSION)) {
            return;
        }

        if (event.getState() != PlayerFishEvent.State.CAUGHT_FISH) {
            return;
        }

        int random = new Random().nextInt(100);

        if (random <= ConfigHandler.CHANCE_FISHING) {
            player.sendMessage(ChatUtil.toChatColor(ConfigHandler.RECEIVED_SPAWNER_MESSAGE.replace("%type%", "fishing")));

            if (player.getInventory().firstEmpty() == -1) {
                player.getWorld().dropItemNaturally(player.getLocation(), ConfigHandler.SPAWNER);

                return;
            }

            player.getInventory().addItem(ConfigHandler.SPAWNER);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (event.isCancelled()) {
            return;
        }

        if (!player.hasPermission(ConfigHandler.MINING_PERMISSION)) {
            return;
        }

        if (!ConfigHandler.MINING_BLOCKS.contains(block.getType().name())) {
            return;
        }

        int random = new Random().nextInt(100);

        if (random <= ConfigHandler.CHANCE_MINING) {
            player.sendMessage(ChatUtil.toChatColor(ConfigHandler.RECEIVED_SPAWNER_MESSAGE.replace("%type%", "mining")));

            if (player.getInventory().firstEmpty() == -1) {
                player.getWorld().dropItemNaturally(player.getLocation(), ConfigHandler.SPAWNER);

                return;
            }

            player.getInventory().addItem(ConfigHandler.SPAWNER);
        }
    }
}
