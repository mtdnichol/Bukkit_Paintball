package me.nichol.Paintball.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ImpactGrenade extends GrenadeBomb {
    public ImpactGrenade() {
        this.name = "Impact Grenade";
        this.damage = 6;
        this.fireRate = 0;
    }

    @Override
    Material getMaterial() {
        return Material.REDSTONE;
    }

    @Override
    String getName() {
        return ChatColor.RED + "Impact Grenade";
    }

    @Override
    List<String> getLore() {
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "Impact Grenade");
        lore.add(ChatColor.WHITE + "1 Second Fuse");
        return lore;
    }

    @Override
    int getFragments() {
        return 5;
    }

    @Override
    int getFuse() {
        return 1;
    }

    @Override
    double getDamage() {
        return 6;
    }
}
