package com.mellowism.jwc.joinworldcommand.commands;

import com.mellowism.jwc.joinworldcommand.JoinWorldCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * com.mellowism.jwc.joinworldcommand.commands was created by mellowism on 25-Apr-19.
 * <p>
 * www.mellowism.com (mellow@mellowism.com)
 */
public class JwcCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin plugin = JoinWorldCommand.getPlugin(JoinWorldCommand.class);

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage(ChatColor.GOLD + "Type '/jwc reload' to reload plugin");

            }else if (args[0].equalsIgnoreCase("reload")){

                player.sendMessage(ChatColor.GREEN + "JoinWorldCommand reloaded");
                plugin.reloadConfig();

            }else{
                player.sendMessage(ChatColor.DARK_PURPLE + "You need to add arguments to your command.");
                player.sendMessage(ChatColor.DARK_PURPLE + "Type '/jwc reload' to reload plugin");

            }
        }else{

            System.out.println("JoinWorldCommand reloaded");
            plugin.reloadConfig();
        }

        return false;
    }
}
