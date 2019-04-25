package com.mellowism.jwc.joinworldcommand.events;

import com.mellowism.jwc.joinworldcommand.JoinWorldCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.Plugin;


/**
 * com.mellowism.jwc.joinworldcommand.events was created by mellowism on 24-Apr-19.
 * <p>
 * www.mellowism.com (mellow@mellowism.com)
 */
public class JoinWorldEvent implements Listener {

    Plugin plugin = JoinWorldCommand.getPlugin(JoinWorldCommand.class);

    @EventHandler

    public void joinWorld (PlayerChangedWorldEvent e){

        //get the player of the event
        Player player = e.getPlayer();

        //get the world name
        //String world = e.getPlayer().getWorld().getName();

        //send the player a message when changing world
        //player.sendMessage("Hello " + ChatColor.GREEN + world);

        //Player perform command when changing world
        player.performCommand(plugin.getConfig().getString("world.command"));

        //Console perform command when changing world
        //Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"")


    }
}
