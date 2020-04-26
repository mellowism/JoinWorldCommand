package com.mellowism.jwc.joinworldcommand.commands;

import com.mellowism.jwc.joinworldcommand.JoinWorldCommand;
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

    JoinWorldCommand plugin;

    public HelloWorldCommand(JoinWorldCommand plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
                if (player.hasPermission("jwc.hello"))
                {
                    player.sendMessage(ChatColor.GOLD + "Hello " + player.getWorld().getName());
                }else{
                    plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[" + ChatColor.YELLOW + "JWC" + ChatColor.GREEN + "]" + ChatColor.YELLOW + " - " + ChatColor.GREEN + player.getDisplayName() + ChatColor.RED + " does not have the permission " + ChatColor.GREEN +  "jwc.hello.");
                }
         }else{
            System.out.println("Command <Hello> has to be sent by a player.");
        }
        return true;
    }
}
