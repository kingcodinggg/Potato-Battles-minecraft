package devlaunchers.potatobattles.commands;

import devlaunchers.potatobattles.PotatoBattles;
import devlaunchers.potatobattles.inventories.SelectionScreen;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;


public class SelectionCommands implements CommandExecutor {

    File f = new File("path/to/your/YAML/file.yml");
    YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);

    @Override



    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only Players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("pb")) {



            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            SelectionScreen gui = new SelectionScreen();
            player.openInventory(gui.getInventory());
            player.sendMessage("Opening selection screen");
        }

    return true;
    }
}
