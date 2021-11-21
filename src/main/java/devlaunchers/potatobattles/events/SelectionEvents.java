package devlaunchers.potatobattles.events;

import devlaunchers.potatobattles.inventories.SelectionScreen;
import devlaunchers.potatobattles.inventories.SpeedClick;
import devlaunchers.potatobattles.inventories.fiftyfifty;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SelectionEvents implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getClickedInventory() == null) { return; }

        if (e.getClickedInventory().getHolder()instanceof SelectionScreen) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) { return; }
            if (e.getCurrentItem().getType() == Material.WOODEN_SWORD) {
                player.sendMessage(ChatColor.GREEN + "Starting 50/50...");
                //player.closeInventory();
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_HIT, 1, 1);
                fiftyfifty gui = new fiftyfifty();
                player.openInventory(gui.getInventory());
            }
            if(e.getCurrentItem().getType() == Material.DIAMOND_BOOTS)
            {
                System.out.println("Speed Click Initiating...");
                player.sendMessage(ChatColor.GREEN + "starting Speed Click...");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_HIT, 1, 1);
                SpeedClick gui = new SpeedClick();
                player.openInventory(gui.getInventory());
            }
        }
    }

}
