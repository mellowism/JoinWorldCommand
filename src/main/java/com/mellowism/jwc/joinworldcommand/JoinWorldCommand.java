package com.mellowism.jwc.joinworldcommand;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinWorldCommand extends JavaPlugin {

    @Override
    public void onEnable() {
        //When server starts, print this message:
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "JoinWorldCommand " + ChatColor.GREEN + "enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
