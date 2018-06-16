package me.marcus.spawnerrewards.util;

import org.bukkit.ChatColor;

public class ChatUtil {

    public static String toChatColor(String from) {
        return ChatColor.translateAlternateColorCodes('&', from);
    }
}
