package devlaunchers.potatobattles.inventories;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class SelectionScreen implements InventoryHolder {




    private Inventory inv;

    public SelectionScreen() {
        inv = Bukkit.createInventory(this, 54, "Potato Battles!");
        init();
    }

    private void init() {
        ItemStack item;




        //LEFT
        for (int i = 3; i < 4; i++) {
            item = createItem(ChatColor.YELLOW + "Potato Battles v0.7", Material.POTATO, Collections.singletonList(ChatColor.DARK_RED + "Please select one of the following modes"));
            inv.setItem(i, item);
        }

        for (int i = 5; i < 6; i++) {
            item = createItem(ChatColor.YELLOW + "Potato Battles v0.7", Material.POTATO, Collections.singletonList(ChatColor.DARK_RED + "Please select one of the following modes"));
            inv.setItem(i, item);
        }

        for (int i = 4; i <5; i++) {
            item = createItem(ChatColor.YELLOW + "Make a selection", Material.ENCHANTED_BOOK, Collections.singletonList(ChatColor.RED + "You can win, I believe in you!"));
            inv.setItem(i, item);
        }

        for (int i = 19; i < 20; i++) {
            item = createItem(ChatColor.GREEN + "50/50 fight", Material.WOODEN_SWORD, Collections.singletonList(ChatColor.DARK_PURPLE + "A chance battle between two potatoes."));
            item.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            inv.setItem(i, item);
        }

        for(int i = 25; i < 26; i++)
        {
            item = createItem(ChatColor.GREEN + "Speed Click", Material.DIAMOND_BOOTS, Collections.singletonList(ChatColor.DARK_PURPLE + "Click the button when it appears."));
            item.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            inv.setItem(i, item);
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
