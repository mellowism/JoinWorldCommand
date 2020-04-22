package com.mellowism.jwc.joinworldcommand.events;

import com.mellowism.jwc.joinworldcommand.JoinWorldCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class JoinServerEvent implements Listener
{
    JoinWorldCommand plugin;
    public JoinServerEvent(JoinWorldCommand plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler

    public void onJoinServer(PlayerJoinEvent e)
    {
        if (plugin.getConfig().getBoolean("enable_server_commands"))
        {

            Player player = e.getPlayer();
            ConfigurationSection server_commandsSection = plugin.getConfig().getConfigurationSection("server_commands");

            assert server_commandsSection != null;
            for (String key : server_commandsSection.getKeys(false))
            {
                if (Objects.requireNonNull(plugin.getConfig().getString("server_commands." + key + ".executor")).equalsIgnoreCase("console"))
                {
                    if (player.hasPermission("jwc.server." + key))
                    {
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), Objects.requireNonNull(plugin.getConfig().getString("server_commands."  + key + ".command")).replace("%player%", e.getPlayer().getName()));
                    }
                }else if (Objects.requireNonNull(plugin.getConfig().getString("server_commands." + key + ".executor")).equalsIgnoreCase("player"))
                {
                    if (player.hasPermission("jwc.server." + key))
                    {
                        player.performCommand(Objects.requireNonNull(plugin.getConfig().getString("server_commands." + key + ".command")).replace("%player%", e.getPlayer().getName()));
                    }
                } else{
                    plugin.getServer().getConsoleSender().sendMessage( ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.YELLOW + " - " + ChatColor.RED + "There is an error at executor under " + ChatColor.YELLOW + "server_commands" + ChatColor.RED + " in config.yml. Has to be " + ChatColor.GREEN + "player " + ChatColor.RED + "or " + ChatColor.GREEN + "console");
                }
            }
        }
    }
}
