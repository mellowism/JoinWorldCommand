package com.mellowism.jwc.joinworldcommand.events;

import com.mellowism.jwc.joinworldcommand.JoinWorldCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import java.util.Objects;

public class JoinWorldEvent implements Listener
{

    JoinWorldCommand plugin;
    public JoinWorldEvent(JoinWorldCommand plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler

    public void joinWorld (PlayerChangedWorldEvent e)
    {
        if(plugin.getConfig().getBoolean("enable_world_commands"))
        {

            Player player = e.getPlayer();
            ConfigurationSection world_commandsSection = plugin.getConfig().getConfigurationSection("world_commands");

            assert world_commandsSection != null;
            for (String key : world_commandsSection.getKeys(false))
            {
                if (Objects.requireNonNull(plugin.getConfig().getString("world_commands." + key + ".executor")).equalsIgnoreCase("console"))
                {
                    if (player.getWorld().getName().equalsIgnoreCase(key) )
                    {
                        if (player.hasPermission("jwc.world." + key))
                        {
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), Objects.requireNonNull(plugin.getConfig().getString("world_commands." + key + ".command")).replace("%player%", e.getPlayer().getName()));
                        }
                    }
                }else if (Objects.requireNonNull(plugin.getConfig().getString("world_commands." + key + ".executor")).equalsIgnoreCase("player"))
                {
                    if (player.getWorld().getName().equalsIgnoreCase(key) )
                    {
                        if (player.hasPermission("jwc.world." + key))
                        {
                            player.performCommand(Objects.requireNonNull(plugin.getConfig().getString("world_commands." + key + ".command")).replace("%player%", e.getPlayer().getName()));
                        }
                    }
                }else{
                    plugin.getServer().getConsoleSender().sendMessage( ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.YELLOW + " - " + ChatColor.RED + "There is an error at executor under " + ChatColor.YELLOW + "world_commands" + ChatColor.RED + " in config.yml. Has to be " + ChatColor.GREEN + "player " + ChatColor.RED + "or " + ChatColor.GREEN + "console");
                }
            }
        }
    }
}
