package devlaunchers.potatobattles.events;

import devlaunchers.potatobattles.PotatoBattles;
import devlaunchers.potatobattles.inventories.SelectionScreen;
import devlaunchers.potatobattles.inventories.fiftyfifty;
import devlaunchers.potatobattles.inventories.fiftyfiftyFIGHT;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
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
                player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1, 1);
                player.sendMessage(ChatColor.DARK_GREEN + "You Win. Congrats!");
                SelectionScreen gui2 = new SelectionScreen();
                player.openInventory(gui2.getInventory());
            }
            else{
                ItemStack item = gui.getInventory().getItem(1);
                gui.getInventory().removeItem(item);
                //playeractive = false;
                System.out.println("LOSE " + winWeight);
                player.sendMessage(ChatColor.DARK_RED + "You Lose. Better Luck Next Time!");
                player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, 1);
                SelectionScreen gui2 = new SelectionScreen();
                player.openInventory(gui2.getInventory());
            }
       }, 60);
        Bukkit.getScheduler().runTaskLater(PotatoBattles.getInstance(), () -> {
                ItemStack item = gui.getInventory().getItem(2);
                gui.getInventory().setContents(removeItemAtIndex(gui.getInventory(), 2));
        }, 20);

        Bukkit.getScheduler().runTaskLater(PotatoBattles.getInstance(), () -> {
                ItemStack item = gui.getInventory().getItem(6);
            gui.getInventory().setContents(removeItemAtIndex(gui.getInventory(), 6));
        }, 20);

        Bukkit.getScheduler().runTaskLater(PotatoBattles.getInstance(), () -> {
                ItemStack item = gui.getInventory().getItem(3);
            gui.getInventory().setContents(removeItemAtIndex(gui.getInventory(), 3));
        }, 40);

        Bukkit.getScheduler().runTaskLater(PotatoBattles.getInstance(), () -> {
                ItemStack item = gui.getInventory().getItem(5);
            gui.getInventory().setContents(removeItemAtIndex(gui.getInventory(), 5));

        }, 40);

        Bukkit.getScheduler().runTaskLater(PotatoBattles.getInstance(), () -> {
            ItemStack item = gui.getInventory().getItem(4);
            gui.getInventory().setContents(removeItemAtIndex(gui.getInventory(), 4));

        }, 60);


    }
    public ItemStack[] removeItemAtIndex(Inventory inventory, int index) {
        ItemStack[] itemStacks = inventory.getContents();
        itemStacks[index] = new ItemStack(Material.AIR);

        return itemStacks;
    }
}