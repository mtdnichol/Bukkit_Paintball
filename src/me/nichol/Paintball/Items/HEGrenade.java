package me.nichol.Paintball.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class HEGrenade extends GrenadeBomb {
    public HEGrenade() {
        this.name = "High Explosive Grenade";
        this.damage = 8;
        this.fireRate = 0;
    }

    @Override
    Material getMaterial() {
        return Material.COAL;
    }

    @Override
    String getName() {
        return ChatColor.RED + "HE Grenade";
    }

    @Override
    List<String> getLore() {
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "High Explosive Grenade");
        lore.add(ChatColor.WHITE + "4 Second Fuse");
        return lore;
    }

    @Override
    int getFragments() {
        return 10;
    }

    @Override
    int getFuse() {
        return 4;
    }

    @Override
    double getDamage() {
        return 8;
    }
}