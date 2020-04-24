package me.nichol.Paintball.Items;

import me.nichol.Paintball.Paintball;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.type.Snow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GrenadeBomb extends SuperWeapon implements Listener {
    private Paintball plugin = Paintball.getPlugin(Paintball.class);
    Random rand = new Random();


    @EventHandler
    public void throwGrenade(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Action action = event.getAction();
        Player player = event.getPlayer();
        Location ploc = player.getLocation();

        if (item == null)
            return;

        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (item.isSimilar(getItem())) {
                item.setAmount(item.getAmount() - 1);
                Entity drop = ploc.getWorld().dropItemNaturally(ploc, getItem());
                drop.setVelocity(ploc.getDirection().multiply(1.2));



                new BukkitRunnable() {
                    @Override
                    public void run() {
                        ploc.getWorld().createExplosion(drop.getLocation(), 0, false);
                        explodeGrenade(drop.getLocation(), getFragments());
                        drop.remove();
                    }
                }.runTaskLater(plugin, 20 * getFuse());
            }
        }
    }

    public ItemStack getItem() {
        ItemStack item = new ItemStack(getMaterial());
        ItemMeta meta = item.getItemMeta();

        if(meta != null) {
            meta.setDisplayName(getName());
            meta.setLore(getLore());

            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            item.setItemMeta(meta);
        }

        return item;
    }


    public void giveItem(Player player) {
        player.getInventory().addItem(getItem());
    }

    abstract Material getMaterial();
    abstract String getName();
    abstract List<String> getLore();
    abstract int getFragments();
    abstract int getFuse();
    abstract double getDamage();

    private void explodeGrenade(Location gloc, int fragments) {
        for (int i = 0; i < fragments; i++) {
            Snowball ball = gloc.getWorld().spawn(gloc, Snowball.class);

            gloc.setPitch(rand.nextInt(180) + 180);
            gloc.setYaw(rand.nextInt(180) + 180);

            ball.setVelocity(gloc.getDirection().multiply(1));
        }
    }
}
