package parkour.themcsoldier.plugin;

import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import parkour.themcsoldier.plugin.commands.ParkourCheckpoint;
import parkour.themcsoldier.plugin.commands.ParkourStart;
import parkour.themcsoldier.plugin.event.Pressure.Pressure.GetLastLocation;
import parkour.themcsoldier.plugin.event.Pressure.Pressure.LastPressure;
import parkour.themcsoldier.plugin.event.Pressure.Pressure.PressurePlat;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        PluginDescriptionFile pdffile = getDescription();
        Logger logger = getLogger();
        registerCommands();
        registerEvents();
        Timer timer = new Timer(this);
        timer.runTaskTimer(this,0,20);
    }
    @Override
    public void onDisable() {
        PluginDescriptionFile pdffile = getDescription();
        Logger logger = getLogger();
        logger.info(pdffile.getName() + " has been disabled (V." + pdffile.getVersion() + ")");
    }
    public void registerCommands() {
        getCommand("ParkourStart").setExecutor(new ParkourStart());
        getCommand("ParkourCheckpoint").setExecutor(new ParkourCheckpoint());
    }
    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PressurePlat(), this);
        pm.registerEvents(new GetLastLocation(), this);
        pm.registerEvents(new LastPressure(), this);
    }


}
