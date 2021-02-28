package devlaunchers.potatobattles.inventories;

import devlaunchers.potatobattles.PotatoBattles;
import devlaunchers.potatobattles.events.SpeedClickBattleEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class SpeedClickBattle implements InventoryHolder{
    private Inventory inv;
    public boolean clickReady;
    //double timeforcheck = Math.random() * 100;
    // long timeforchecklong = (long) timeforcheck;
    private Player target;
    public SpeedClickBattleEvents Clicked;


    public SpeedClickBattle(Player player)
    {
        //set the player, for later used
        this.target = player;

        inv = Bukkit.createInventory(this, 9, "Speed Click");
        init();
    }

    private void init()
    {

        double timeforcheck = Math.random() * 100;
        long timeforchecklong = (long) timeforcheck;
        final ItemStack[] item = new ItemStack[1];
        System.out.println(timeforchecklong);
        System.out.println("SpeedClick Battle Initiated.");

        if(timeforchecklong == 0)
        {
            timeforcheck = Math.random() * 100;
            timeforchecklong = (long) timeforcheck;
        }

        for(int i = 1; i < 2; i++)
        {
            item[0] = createItem(ChatColor.YELLOW + "You", Material.POTATO, Collections.singletonList(ChatColor.DARK_RED + "Your potato. WIN!!!"));
            inv.setItem(i, item[0]);
        }

        for(int i = 7; i < 8; i++)
        {
            item[0] = createItem(ChatColor.YELLOW + "Enemy", Material.POTATO, Collections.singletonList(ChatColor.DARK_RED + "Enemy potato. Booo!!!"));
            inv.setItem(i, item[0]);
        }

        Bukkit.getScheduler().runTaskLater(PotatoBattles.getInstance(), () -> {
            //clickReady = true;
            for(int i = 4; i < 5; i++)
            {
                item[0] = createItem(ChatColor.GREEN + "CLICK ME NOW!!!!!", Material.GREEN_STAINED_GLASS_PANE, Collections.singletonList(ChatColor.AQUA + "Click me before you're time is up!"));
                inv.setItem(i, item[0]);
            }

            Bukkit.getScheduler().runTaskLater(PotatoBattles.getInstance(), () -> {
                getInventory().getItem(4);
                getInventory().removeItem(item);
                Bukkit.getScheduler().runTaskLater(PotatoBattles.getInstance(), () -> {
                    if(SpeedClickBattleEvents.Clicked == false)
                    {
                        target.sendMessage(ChatColor.RED + "You Lose. Better luck next time!");

                        SelectionScreen gui = new SelectionScreen();

                        target.openInventory(gui.getInventory());
                    }

                }, 15);
            }, 15);
            System.out.println("Creating Item...");
        }, timeforchecklong);

        /*if(clickReady == true)
        {
            System.out.println("Item Created.");
            for(int i = 4; i < 5; i++)
            {
                item = createItem(ChatColor.GREEN + "CLICK ME NOW!!!!!", Material.GREEN_STAINED_GLASS_PANE, Collections.singletonList(ChatColor.AQUA + "Click me before you're time is up!"));
                inv.setItem(i, item);
            }
        } */

    }

    private ItemStack createItem(String name, Material mat, List<String> lore)
    {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }


    @Override
    public Inventory getInventory()
    {
        return inv;
    }
}
