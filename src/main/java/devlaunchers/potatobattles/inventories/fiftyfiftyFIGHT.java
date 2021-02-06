package devlaunchers.potatobattles.inventories;

import devlaunchers.potatobattles.PotatoBattles;
import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class fiftyfiftyFIGHT implements InventoryHolder {

    private Inventory inv;


    boolean enemy = true;
    boolean playeractive = true;
    //double winWeight = Math.random() * 100;


    public fiftyfiftyFIGHT() {
        inv = Bukkit.createInventory(this, 9, "50/50 BATTLE");
        init();
    }

    public void init() {
        ItemStack item;

        //wait 3 sec then define winner


        //checking whether your potato is supposed to be visable or not
        if(playeractive == true){
            //LEFT
            for (int i = 1; i < 2; i++) {
                //creating item
                item = createItem(ChatColor.YELLOW + "You", Material.POTATO, Collections.singletonList(ChatColor.DARK_RED + "Your potato. WIN!!!!"));
                inv.setItem(i, item);
            }
        }

        if(enemy == true){
            //creating item
            for (int i = 7; i < 8; i++) {
                item = createItem(ChatColor.YELLOW + "Enemy", Material.POTATO, Collections.singletonList(ChatColor.DARK_RED + "The enemy potato. Boooo!!!"));
                inv.setItem(i, item);

            }
        }
    }

   public void itemRemove(double winWeight){
        if(winWeight >= 50)
        {
            //getInventory().removeItem(item);
        }
   }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }



}