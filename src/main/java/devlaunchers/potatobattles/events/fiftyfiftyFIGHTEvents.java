package devlaunchers.potatobattles.events;

import devlaunchers.potatobattles.inventories.fiftyfiftyFIGHT;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class fiftyfiftyFIGHTEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }

        if(e.getClickedInventory().getHolder()instanceof fiftyfiftyFIGHT) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) { return; }
          // ItemStack item = e.getClickedInventory().getItem(1);
           // e.getClickedInventory().removeItem(item);
        }
    }
}
