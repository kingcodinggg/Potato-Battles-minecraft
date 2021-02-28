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

public class SpeedClickBattleEvents implements Listener {
    public static boolean Clicked;

    @EventHandler


    public void onClick(InventoryClickEvent e) {
        Clicked = false;

        if (e.getClickedInventory() == null) {
            return;
        }

        if (e.getClickedInventory().getHolder()instanceof SpeedClickBattle) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
                Clicked = true;
                player.sendMessage(ChatColor.GREEN + "You Win!");
                SelectionScreen gui = new SelectionScreen();
                player.openInventory(gui.getInventory());
            }

        }
    }

}