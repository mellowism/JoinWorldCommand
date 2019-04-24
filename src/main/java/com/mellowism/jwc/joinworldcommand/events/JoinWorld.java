package com.mellowism.jwc.joinworldcommand.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

/**
 * com.mellowism.jwc.joinworldcommand.events was created by mellowism on 24-Apr-19.
 * <p>
 * www.mellowism.com (mellow@mellowism.com)
 */
public class JoinWorld implements Listener {

    @EventHandler

    public void joinWorld (PlayerChangedWorldEvent e){

        //get the player of the event
        Player player = e.getPlayer();

        //get the world name
        String world = e.getPlayer().getWorld().getName();

        //send the player a message when changing world
        player.sendMessage("Hello " + ChatColor.GREEN + world);

        //perform command when changing world
        player.performCommand("ttest");


    }
}
