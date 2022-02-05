//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.notdew.com.removeref;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveCommand implements CommandExecutor {
    public RemoveCommand() {
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length != 1 && args.length != 2) {
            return true;
        } else if (!(commandSender instanceof Player)) {
            return true;
        } else if (!(Bukkit.getPlayer(args[0]) instanceof Player)) {
            return true;
        }
        Player p = (Player)commandSender;
        Player pl = Bukkit.getPlayer(args[0]);
        if (pl.getName().equals(p.getName())) {
            if (!(commandSender.hasPermission("ref.give"))) commandSender.sendMessage(ChatColor.RED + "No Permission."); return true;
        } else {
            if (args.length == 1) {
                TextComponent component = new TextComponent(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&a&lClick to confirm.")));
                component.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/removeref " + pl.getName() + " confirm"));
                commandSender.spigot().sendMessage(component);
                return true;
            } else if (args[1].equalsIgnoreCase("confirm")) {
                pl = Bukkit.getPlayer(args[0]);
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + pl.getName() + " group removetemp referee");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + pl.getName() + " group remove referee");
                p.sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "Done.");
                return true;
            } else {
                return true;
            }
        }
    }
}
