package devlaunchers.potatobattles.events;

import devlaunchers.potatobattles.PotatoBattles;
import devlaunchers.potatobattles.inventories.SelectionScreen;
import devlaunchers.potatobattles.inventories.fiftyfifty;
import devlaunchers.potatobattles.inventories.fiftyfiftyFIGHT;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class fiftyfiftyEvents implements Listener {

    //double winWeight = Math.random() * 100;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getClickedInventory() == null) { return; }

        if (e.getClickedInventory().getHolder()instanceof fiftyfifty) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) { return; }
            if (e.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
                JoinBattle(player);
            }
        }
    }

    public void JoinBattle(Player player) {
        //double winWeight = Math.random() * 100;
        player.sendMessage(ChatColor.GREEN + "Joining battle...");
        player.closeInventory();

        fiftyfiftyFIGHT gui = new fiftyfiftyFIGHT();
        player.openInventory(gui.getInventory());

        Bukkit.getScheduler().runTaskLater(PotatoBattles.getInstance(), () -> {
            double winWeight = Math.random() * 50;
            if(winWeight <= 25)
            {
                ItemStack item = gui.getInventory().getItem(7);
                gui.getInventory().removeItem(item);
                //playeractive = false;
                System.out.println("WIN " + winWeight);
                player.sendMessage("You Win. Congrats!");

            }
            else{
                ItemStack item = gui.getInventory().getItem(1);
                gui.getInventory().removeItem(item);
                //playeractive = false;
                System.out.println("LOSE " + winWeight);
                player.sendMessage("You Lose. Better Luck Next Time!");

            }
       }, 60);
    }
}