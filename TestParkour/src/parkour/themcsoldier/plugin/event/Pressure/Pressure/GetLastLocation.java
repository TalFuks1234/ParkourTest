package parkour.themcsoldier.plugin.event.Pressure.Pressure;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static parkour.themcsoldier.plugin.event.Pressure.Pressure.PressurePlat.indi;

public class GetLastLocation implements Listener {
    public static Location onPressure = null;

    @EventHandler
    public void onPressure(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL) {
            if (event.getClickedBlock().getType() == Material.STONE_PLATE) {
                if (event.getPlayer().getLocation().getBlockY() != 90) {
                    if (indi == 1) {
                        onPressure = event.getPlayer().getLocation();
                    }
                    else
                    {
                        onPressure = null;
                        event.getPlayer().sendMessage(ChatColor.RED + "Please get to the start first.");
                    }
                }
            }
        }
    }
}

