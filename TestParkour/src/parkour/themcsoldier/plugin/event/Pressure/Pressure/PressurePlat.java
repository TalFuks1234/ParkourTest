package parkour.themcsoldier.plugin.event.Pressure.Pressure;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import parkour.themcsoldier.plugin.Main;
import parkour.themcsoldier.plugin.Timer;

public class PressurePlat implements Listener {
    public static int counter = 0;
    public static int check = 0;
    public static int indi = 0;

    @EventHandler
    public void onPressure(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL) {
            if (event.getClickedBlock().getType() == Material.STONE_PLATE) {
                if (event.getPlayer().getLocation().getBlockY() == 90) {
                    if (check == 0) {
                        event.getPlayer().sendMessage(ChatColor.BLUE + "Time reseted, Good luck!");
                        this.counter = 1;
                        GetLastLocation.onPressure = null;
                        check++;
                        indi = 1;
                    }
                    else {
                        indi = 0;
                        GetLastLocation.onPressure = null;
                        counter = 0;
                        event.getPlayer().sendMessage(ChatColor.BLUE + "Time reseted, Good luck!");
                        counter = 1;
                        indi = 1;
                    }
                }
            }
        }
    }
}
