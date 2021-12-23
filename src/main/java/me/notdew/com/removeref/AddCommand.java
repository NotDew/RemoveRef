package me.notdew.com.removeref;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class AddCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String label, String[] args) {

        if (!(commandSender.hasPermission("ref.give"))) return true;

        if (!(args.length == 1 || args.length == 2)) return true;
        if (!(commandSender instanceof Player)){return true;}
        if (!(Bukkit.getPlayer(args[0]) instanceof Player)){return true;}

        Player p = (Player) commandSender;
        Player pl = Bukkit.getPlayer(args[0]);




        if (args.length == 1) {
            TextComponent component = new TextComponent(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&a&lClick to confirm.")));
            component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + "addref "  + pl.getName() + " confirm"));

            commandSender.spigot().sendMessage(component);
            return true;
        }
        if (args[1].equalsIgnoreCase("confirm")) {
            pl = Bukkit.getPlayer(args[0]);

            //do
            getServer().dispatchCommand(getServer().getConsoleSender(), "lp user " + pl.getName() + " parent addtemp referee 150m");
            p.sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "Done.");
            return true;
        }
        return true;
    }


}
