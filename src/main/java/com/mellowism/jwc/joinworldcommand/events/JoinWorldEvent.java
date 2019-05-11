package com.mellowism.jwc.joinworldcommand.events;

import com.mellowism.jwc.joinworldcommand.JoinWorldCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

/**
 * com.mellowism.jwc.joinworldcommand.events was created by mellowism on 24-Apr-19.
 * <p>
 * www.mellowism.com (mellow@mellowism.com)
 */
public class JoinWorldEvent implements Listener {

    JoinWorldCommand plugin;
    public JoinWorldEvent(JoinWorldCommand plugin) {
        this.plugin = plugin;
    }

    @EventHandler

    public void joinWorld (PlayerChangedWorldEvent e){

        Player player = e.getPlayer();

        ConfigurationSection world_commandsSection = plugin.getConfig().getConfigurationSection("world_commands");

        for (String key : world_commandsSection.getKeys(false)){
            world_commandsSection.get(key + ".world");
            if (plugin.getConfig().getString("world_commands." + key + ".executor").equals("console")){
                if (e.getPlayer().getWorld().getName().equalsIgnoreCase(key) ){
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), plugin.getConfig().getString("world_commands." + key + ".command").replace("%player%", e.getPlayer().getName()));
                }
            }else{
                if (e.getPlayer().getWorld().getName().equalsIgnoreCase(key) ){
                    player.performCommand(plugin.getConfig().getString("world_commands." + key + ".command").replace("%player%", e.getPlayer().getName()));
                }
            }
        }
    }
}
