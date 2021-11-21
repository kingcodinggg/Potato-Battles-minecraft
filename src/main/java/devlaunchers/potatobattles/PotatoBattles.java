package devlaunchers.potatobattles;

import devlaunchers.potatobattles.commands.SelectionCommands;
import devlaunchers.potatobattles.events.*;
import devlaunchers.potatobattles.inventories.SpeedClickBattle;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class PotatoBattles extends JavaPlugin {
    private static JavaPlugin instance;


    public File getFile() {
        return new File(PotatoBattles.getInstance().getDataFolder(), "config.yml");

    }


    public static JavaPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        int integerValue = 8;
        this.getConfig().set("path.to.integer", integerValue);
        // Plugin startup logic
        instance = this;
     getCommand("pb").setExecutor(new SelectionCommands());
     getServer().getPluginManager().registerEvents(new SelectionEvents(), this);
     getServer().getPluginManager().registerEvents(new fiftyfiftyEvents(), this);
     getServer().getPluginManager().registerEvents(new fiftyfiftyFIGHTEvents(), this);
     getServer().getPluginManager().registerEvents(new SpeedClickEvents(), this);
     getServer().getPluginManager().registerEvents(new SpeedClickBattleEvents(), this);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
