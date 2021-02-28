package devlaunchers.potatobattles.inventories;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class SpeedClick implements InventoryHolder {

    private Inventory inv;

    public SpeedClick() {
        inv = Bukkit.createInventory(this, 54, "Speed Click Mode");
        init();
    }

    private void init() {
        ItemStack item;

        //LEFT
        for (int i = 3; i < 4; i++) {
            item = createItem(ChatColor.YELLOW + "Potato Battles v0.7", Material.POTATO, Collections.singletonList(ChatColor.DARK_RED + "Please select one of the following options"));
            inv.setItem(i, item);
        }

        for (int i = 5; i < 6; i++) {
            item = createItem(ChatColor.YELLOW + "Potato Battles v0.7", Material.POTATO, Collections.singletonList(ChatColor.DARK_RED + "Please select one of the following options"));
            inv.setItem(i, item);
        }

        for (int i = 4; i <5; i++) {
            item = createItem(ChatColor.YELLOW + "Speed Click", Material.ENCHANTED_BOOK, Collections.singletonList(ChatColor.RED + "You can win, I believe in you!"));
            inv.setItem(i, item);
        }

        for (int i = 29; i < 30; i++) {
            item = createItem(ChatColor.GREEN + "Begin", Material.GREEN_STAINED_GLASS_PANE, Collections.singletonList(ChatColor.DARK_PURPLE + "Start a Speed Click battle"));
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