package parkour.themcsoldier.plugin;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import static parkour.themcsoldier.plugin.event.Pressure.Pressure.PressurePlat.counter;

public class Timer extends BukkitRunnable {
    public static int timer = 0;
    Main plugin;
    public Timer(Main plugin)
    {
        this.plugin = plugin;
    }
    @Override
    public void run() {
        if (counter == 1) {
            timer++;
        }
        else {
            timer = 0;
        }
    }
}
