package com.mellowism.jwc.joinworldcommand;

import com.mellowism.jwc.joinworldcommand.commands.HelloWorldCommand;
import com.mellowism.jwc.joinworldcommand.commands.JwcCommand;
import com.mellowism.jwc.joinworldcommand.events.JoinWorldEvent;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinWorldCommand extends JavaPlugin {

    @Override
    public void onEnable() {
        //When server starts, print this message:
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "JoinWorldCommand " + ChatColor.GREEN + "enabled!");

        //This is for enabling my events:
        getServer().getPluginManager().registerEvents(new JoinWorldEvent(), this);

        //This is for enabling config file:
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //This is for enabling my commands:
        this.getCommand("hello").setExecutor(new HelloWorldCommand());
        this.getCommand("jwc").setExecutor(new JwcCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
