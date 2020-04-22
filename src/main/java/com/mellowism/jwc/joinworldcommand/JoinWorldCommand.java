package com.mellowism.jwc.joinworldcommand;

import com.mellowism.jwc.joinworldcommand.commands.HelloWorldCommand;
import com.mellowism.jwc.joinworldcommand.commands.JwcCommand;
import com.mellowism.jwc.joinworldcommand.events.JoinServerEvent;
import com.mellowism.jwc.joinworldcommand.events.JoinWorldEvent;
import com.tchristofferson.configupdater.ConfigUpdater;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public final class JoinWorldCommand extends JavaPlugin {

    @Override
    public void onEnable() {
        //When server starts, print this message:
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.YELLOW + " - JoinWorldCommand " + ChatColor.GREEN + "enabled!");

        //This is for enabling my events:
        getServer().getPluginManager().registerEvents(new JoinWorldEvent(this), this);
        getServer().getPluginManager().registerEvents(new JoinServerEvent(this), this);

        //This is for enabling config file:
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Config-updater:
        File configFile = new File(getDataFolder(), "config.yml");
        try {
            ConfigUpdater.update(this, "config.yml", configFile, Arrays.asList("world_commands"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        reloadConfig();

        //This is for enabling my commands:
        this.getCommand("jwc_hello").setExecutor(new HelloWorldCommand(this));
        this.getCommand("joinworldcommand").setExecutor(new JwcCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
