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
public class JwcCommand implements CommandExecutor {

    //Access to config from main class.
    JoinWorldCommand plugin;
    public JwcCommand(JoinWorldCommand plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //Start of arguments with command /jwc
        if(sender instanceof Player) {
            //Cast sender to Player
            Player player = (Player) sender;
            //If you don't use any arguments after /jwc:
            if(args.length == 0) {
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Type '/jwc reload' to reload plugin");
                //If 1st argument (0) is reload, reload config!
            }else if (args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission("jwc.reload")){
                    player.sendMessage(ChatColor.YELLOW + "JoinWorldCommand " + ChatColor.GREEN +  "reloaded");
                    System.out.println(ChatColor.YELLOW + "JoinWorldCommand " + ChatColor.GREEN +  "reloaded");
                    plugin.reloadConfig();
                }
            }else{
                //If no arguments are present, send message to player:
                player.sendMessage(ChatColor.LIGHT_PURPLE + "You need to add the correct arguments to your command.");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Type '/jwc reload' to reload plugin");
            }
            //If you are not player executing command:
        }else{
            System.out.println(ChatColor.YELLOW + "JoinWorldCommand " + ChatColor.GREEN +  "reloaded");
            plugin.reloadConfig();
        }
        return true;
    }
}