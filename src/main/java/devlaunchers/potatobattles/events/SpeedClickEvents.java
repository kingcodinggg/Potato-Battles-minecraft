package devlaunchers.potatobattles.events;

import devlaunchers.potatobattles.PotatoBattles;
import devlaunchers.potatobattles.inventories.SelectionScreen;
import devlaunchers.potatobattles.inventories.SpeedClick;
import devlaunchers.potatobattles.inventories.SpeedClickBattle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class SpeedClickEvents implements Listener {
    @EventHandler


    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }

        if (e.getClickedInventory().getHolder()instanceof SpeedClick) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
                player.sendMessage(ChatColor.GREEN + "Starting Battle...");
                SpeedClickBattle gui = new SpeedClickBattle(player);
                player.openInventory(gui.getInventory());
            }

        }
    }



    /*private void lose(Player player, Boolean Clicked)
    {
        if(Clicked == false)
        {
            player.sendMessage(ChatColor.RED + "You lose. Better luck next time!");
        }
    } */
}
