package devlaunchers.potatobattles.commands;

import devlaunchers.potatobattles.inventories.SelectionScreen;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SelectionCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only Players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("pb")) {
            SelectionScreen gui = new SelectionScreen();
            player.openInventory(gui.getInventory());
            player.sendMessage("Opening selection screen");
        }

    return true;
    }
}
