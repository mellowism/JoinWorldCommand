package com.mellowism.jwc.joinworldcommand.commands;

import com.mellowism.jwc.joinworldcommand.JoinWorldCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * com.mellowism.jwc.joinworldcommand.commands was created by mellowism on 25-Apr-19.
 * <p>
 * www.mellowism.com (mellow@mellowism.com)
 */
public class JwcCommand implements CommandExecutor
{

    //Access to config from main class.
    JoinWorldCommand plugin;
    public JwcCommand(JoinWorldCommand plugin)
    {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        //Start of arguments with command /jwc
        if(sender instanceof Player)
        {
            //Cast sender to Player
            Player player = (Player) sender;
            if(player.hasPermission("jwc.admin"))
            {
                //If you don't use any arguments after /jwc:
                if(args.length == 0)
                {
                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc reload" + ChatColor.GREEN + " to reload plugin.");
                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc world" + ChatColor.GREEN + " for world commands.");
                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc server" + ChatColor.GREEN + " for server commands.");
                }else
                {
                    //If 1st argument (0) is reload, reload config!
                    if (args[0].equalsIgnoreCase("reload"))
                    {
                        player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.YELLOW + " - JoinWorldCommand " + ChatColor.GREEN + "reloaded");
                        plugin.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.YELLOW + " - JoinWorldCommand " + ChatColor.GREEN + "reloaded");
                        plugin.reloadConfig();

                    }else if(args[0].equalsIgnoreCase("world"))
                    {
                        if(args.length > 1)
                        {
                            if (args[1].equalsIgnoreCase("enable"))
                            {
                                //enable world commands
                                if(!plugin.getConfig().getBoolean("enable_world_commands"))
                                {
                                    plugin.getConfig().set("enable_world_commands", true);
                                    plugin.saveConfig();
                                    plugin.updateConfig();
                                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN + "World commands is now enabled.");
                                }else
                                {
                                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED + "World commands is already enabled. Use " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc world disable" + ChatColor.RED + " to disable.");
                                }
                            }else if (args[1].equalsIgnoreCase("disable"))
                            {
                                //disable world commands
                                if(plugin.getConfig().getBoolean("enable_world_commands"))
                                {
                                    plugin.getConfig().set("enable_world_commands", false);
                                    plugin.saveConfig();
                                    plugin.updateConfig();
                                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN + "World commands is now disabled.");
                                }else
                                {
                                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED + "World commands is already disabled. Use " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc world enable" + ChatColor.RED + " to enable.");
                                }
                                return true;
                            }else
                            {
                                player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED  + "Unknown argument.");
                                player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc world enable" + ChatColor.RED + " to enable world commands");
                                player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc world disable" + ChatColor.RED + " to disable world commands");
                            }
                        }else
                        {
                            player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc world enable" + ChatColor.GREEN + " to enable world commands");
                            player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc world disable" + ChatColor.GREEN + " to disable world commands");
                        }
                    }else if(args[0].equalsIgnoreCase("server"))
                        if(args.length > 1)
                        {
                            if (args[1].equalsIgnoreCase("enable"))
                            {
                                //enable world commands
                                if(!plugin.getConfig().getBoolean("enable_server_commands"))
                                {
                                    plugin.getConfig().set("enable_server_commands", true);
                                    plugin.saveConfig();
                                    plugin.updateConfig();
                                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN + "Server commands is now enabled.");
                                }else
                                {
                                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED + "Server commands is already enabled. Use " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc server disable" + ChatColor.RED + " to disable.");
                                }
                            }else if (args[1].equalsIgnoreCase("disable"))
                            {
                                //disable world commands
                                if(plugin.getConfig().getBoolean("enable_server_commands"))
                                {
                                    plugin.getConfig().set("enable_server_commands", false);
                                    plugin.saveConfig();
                                    plugin.updateConfig();
                                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN + "Server commands is now disabled.");
                                }else
                                {
                                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED + "Server commands is already disabled. Use " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc server enable" + ChatColor.RED + " to enable.");
                                }
                                return true;
                            }else
                            {
                                player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED  + "Unknown argument.");
                                player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc server enable" + ChatColor.RED + " to enable server commands");
                                player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc server disable" + ChatColor.RED + " to disable server commands");
                            }
                        }else
                        {
                            player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc server enable" + ChatColor.GREEN + " to enable server commands");
                            player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.GREEN  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc server disable" + ChatColor.GREEN + " to disable server commands");
                        }
                    }
                }else
                {
                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED + "You do not have the permission " + ChatColor.GREEN +  "jwc.admin");
                    plugin.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.YELLOW + " - " + ChatColor.GREEN + player.getDisplayName() + ChatColor.RED + " does not have the permission " + ChatColor.GREEN +  "jwc.admin.");
                }
        //If you are not player executing command:
        }else
        {
            if(args.length == 0)
            {
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED + "You need to add the correct arguments to your command.");
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.GRAY + " - " + ChatColor.RED  + "Type " + ChatColor.GRAY + "/" + ChatColor.YELLOW + "jwc reload" + ChatColor.RED + " to reload plugin.");
                //If 1st argument (0) is reload, reload config!
            }else if (args[0].equalsIgnoreCase("reload"))
            {
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.YELLOW + " - JoinWorldCommand " + ChatColor.GREEN + "reloaded");
                plugin.reloadConfig();
            }
        }
        return true;
    }
}