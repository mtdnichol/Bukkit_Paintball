package me.nichol.Paintball.Items.Weapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Grenade extends SuperWeapon {
    private ItemStack item;

    public Grenade () {
        this.name = "Grenade";
        this.damage = 8;
        this.fireRate = 0;

        ItemStack item = new ItemStack(Material.COAL, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.RED + "HE Grenade");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "High Explosive Grenade");
        lore.add(ChatColor.WHITE + "4 Second Fuse");
        meta.setLore(lore);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);

        this.item = item;
    }

    public void giveItem(Player player) {
        player.getInventory().addItem(this.item);
    }

    public ItemStack getItem() { return item; }
}
