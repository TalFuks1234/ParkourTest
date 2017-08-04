package parkour.themcsoldier.plugin.event.Pressure.Pressure;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import parkour.themcsoldier.plugin.Timer;

public class LastPressure implements Listener {

        @EventHandler
        public void onPressure(PlayerInteractEvent event) {
            if(event.getAction() == Action.PHYSICAL) {
                if (event.getClickedBlock().getType() == Material.GOLD_PLATE) {
                    if (parkour.themcsoldier.plugin.Timer.timer == 0)
                    {
                        event.getPlayer().sendMessage(ChatColor.RED + "Hey! don't cheat :)");
                    }
                    else {
                        event.getPlayer().sendMessage(ChatColor.YELLOW + "You finished the parkour! Your time was " + parkour.themcsoldier.plugin.Timer.timer / 60 + " Minutes and " + parkour.themcsoldier.plugin.Timer.timer % 60 + " Seconds!");
                        PressurePlat.counter = 0;
                        GetLastLocation.onPressure = null;
                        parkour.themcsoldier.plugin.Timer.timer = 0;
                        }
                    }
                }
            }
        }



