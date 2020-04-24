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
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Type '/jwc reload' to reload plugin");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Type '/jwc world for world commands");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Type '/jwc server for server commands");
                    //If 1st argument (0) is reload, reload config!
                }else if (args[0].equalsIgnoreCase("reload"))
                {
                    player.sendMessage(ChatColor.YELLOW + "JoinWorldCommand " + ChatColor.GREEN +  "reloaded");
                    plugin.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "JoinWorldCommand " + ChatColor.GREEN + "reloaded");
                    plugin.reloadConfig();

                }else if(args[0].equalsIgnoreCase("world"))
                {
//                    if(args[1].equalsIgnoreCase("set"))
//                    {
//                        //set world commands
//                        //en for loop, som setter alle args etter, basert på prefix w:worldname c:command e:executor
//                    }
//                    else
                    if (args[1].equalsIgnoreCase("enable"))
                    {
                        //enable world commands
                        if(!plugin.getConfig().getBoolean("enable_world_commands"))
                        {
                            plugin.getConfig().set("enable_world_commands", true);
                            plugin.saveConfig();
                            plugin.updateConfig();
                            player.sendMessage("World commands is now enabled.");
                        }else
                        {
                            player.sendMessage("World commands is already enabled. Use /jwc world disable to disable.");
                        }
                    }else if (args[1].equalsIgnoreCase("disable"))
                    {
                        //disable world commands
                        if(plugin.getConfig().getBoolean("enable_world_commands"))
                        {
                            plugin.getConfig().set("enable_world_commands", false);
                            plugin.saveConfig();
                            plugin.updateConfig();
                            player.sendMessage("World commands is now disabled.");
                        }else
                        {
                            player.sendMessage("World commands is already disabled. Use /jwc world enable to enable.");
                        }
                    }
//                    else if (args[1].equalsIgnoreCase("list"))
//                    {
//                        //lists world commands
//                    }else if (args[1].equalsIgnoreCase("delete"))
//                    {
//                        //deletes a world commands
//                    }
                    else
                    {
                        player.sendMessage("Usage: /jwc world set or /jwc world enable");
                    }
                }else if(args[0].equalsIgnoreCase("server"))
                {
//                    if(args[1].equalsIgnoreCase("set"))
//                    {
//                        //set server commands
//                    }else
                    if (args[1].equalsIgnoreCase("enable"))
                    {
                        //enable server commands
                        if(!plugin.getConfig().getBoolean("enable_server_commands"))
                        {
                            plugin.getConfig().set("enable_server_commands", true);
                            plugin.saveConfig();
                            plugin.updateConfig();
                            player.sendMessage("Server commands is now enabled.");
                        }else
                        {
                            player.sendMessage("Server commands is already enabled. Use /jwc server disable to disable.");
                        }
                    }else if (args[1].equalsIgnoreCase("disable"))
                    {
                        //disable server commands
                        if(plugin.getConfig().getBoolean("enable_server_commands"))
                        {
                            plugin.getConfig().set("enable_server_commands", false);
                            plugin.saveConfig();
                            plugin.updateConfig();
                            player.sendMessage("Server commands is now disabled.");
                        }else
                        {
                            player.sendMessage("Server commands is already disabled. Use /jwc server enable to enable.");
                        }
                    }
//                    else if (args[1].equalsIgnoreCase("list"))
//                    {
//                        //lists server commands
//                    }else if (args[1].equalsIgnoreCase("delete"))
//                    {
//                        //deletes a server commands
//                    }else
                    {
                        player.sendMessage("Usage: /jwc server set or /jwc server enable");
                    }
                }else
                {
                    //If no arguments are present, send message to player:
                    player.sendMessage(ChatColor.RED + "You need to add the correct arguments to your command.");
                    player.sendMessage(ChatColor.RED + "Type " + ChatColor.GRAY + "/" + ChatColor.GREEN + "jwc reload" + ChatColor.RED + " to reload plugin");
                }
            }else
            {
                player.sendMessage(ChatColor.RED + "You do not have the permission " + ChatColor.GREEN +  "jwc.admin");
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "[" + ChatColor.YELLOW + "JWC" + ChatColor.BLUE + "]" + ChatColor.YELLOW + " - " + ChatColor.GREEN + player.getDisplayName() + ChatColor.RED + " does not have the permission " + ChatColor.GREEN +  "jwc.admin.");
            }
        //If you are not player executing command:
        }else
        {
            if(args.length == 0)
            {
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Type '/jwc reload' to reload plugin");
                //If 1st argument (0) is reload, reload config!
            }else if (args[0].equalsIgnoreCase("reload"))
            {
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "JoinWorldCommand " + ChatColor.GREEN + "reloaded");
                plugin.reloadConfig();
            }
        }
        return true;
    }
}