package me.notdew.com.removeref;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)){return true;}
        Player p = (Player) commandSender;
        if (args.length == 0) {
            TextComponent component = new TextComponent(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&a&lClick to confirm.")));
            component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + "removeref confirm"));

            commandSender.spigot().sendMessage(component);
            return true;
        }
        if (args[0].equalsIgnoreCase("confirm")) {

            //do
            String name = ((Player) commandSender).getDisplayName();
            getServer().dispatchCommand(getServer().getConsoleSender(), "lp user " + name + " group remove referee");
            p.sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "Done.");
            return true;
        }
        return true;
    }
}
