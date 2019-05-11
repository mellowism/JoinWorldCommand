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
                if (player.hasPermission("jwc.hello")){
                    player.sendMessage(ChatColor.GOLD + "Hello " + player.getWorld().getName());
                }else{
                    System.out.println(ChatColor.GREEN + player.getDisplayName() + ChatColor.RED + " does not have permission to say hello to the world. " + ChatColor.GREEN + "[" + ChatColor.YELLOW + "JWC" + ChatColor.GREEN + "]" );
                }
         }else{
            System.out.println("Command <Hello> has to be sent by a player.");
        }
        return true;
    }
}
