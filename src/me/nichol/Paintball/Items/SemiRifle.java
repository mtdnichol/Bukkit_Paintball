package me.nichol.Paintball.Items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SemiRifle extends SuperWeapon {
    public SemiRifle () {
        this.name = "Semi-Rifle";
        this.damage = 4;
        this.fireRate = 2;
    }

    public void giveItem(Player player) {
        player.getInventory().addItem(super.getItem());
    }

    public ItemStack getItem() {
        return super.item;
    }
}
