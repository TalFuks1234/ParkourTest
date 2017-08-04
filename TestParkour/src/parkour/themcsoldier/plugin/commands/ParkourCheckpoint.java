package parkour.themcsoldier.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import parkour.themcsoldier.plugin.event.Pressure.Pressure.GetLastLocation;

public class ParkourCheckpoint implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Location l = GetLastLocation.onPressure;
        if (s.equalsIgnoreCase("ParkourCheckpoint")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("You're not allowed to do that.");
                return false;
            }
            if (l == null)
            {
                commandSender.sendMessage(ChatColor.RED + "No checkpoint found");
            }
            else {
                ((Player) commandSender).teleport(l);
                commandSender.sendMessage(ChatColor.AQUA + "Teleported you to your last checkpoint!");
                return true;
            }
        }
        return false;
    }

}
