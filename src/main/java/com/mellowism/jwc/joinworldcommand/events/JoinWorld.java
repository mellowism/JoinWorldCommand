package com.mellowism.jwc.joinworldcommand.events;

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

        Player player = e.getPlayer();
        player.sendMessage("Hello" + e.getPlayer().getWorld());

    }
}
