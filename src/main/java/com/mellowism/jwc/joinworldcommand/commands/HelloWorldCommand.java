package com.mellowism.jwc.joinworldcommand.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * com.mellowism.jwc.joinworldcommand.commands was created by mellowism on 24-Apr-19.
 * <p>
 * www.mellowism.com (mellow@mellowism.com)
 */
public class HelloWorldCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GOLD + "Hello " + player.getWorld().getName());
         }
        return true;
    }
}
