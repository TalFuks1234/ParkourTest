package parkour.themcsoldier.plugin.commands;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ParkourStart implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("ParkourStart"))
        {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You must be a player to use this command");
                return false;
            }
            sender.sendMessage(ChatColor.BLUE + "Sending you to the start!");
            Location l = new Location(((Player) sender).getWorld(), 0, 90, 0);
            ((Player) sender).teleport(l);
            return true;
        }
        return false;
    }
}
