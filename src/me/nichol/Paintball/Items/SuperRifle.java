package me.nichol.Paintball.Items;

import me.nichol.Paintball.Paintball;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class SuperRifle extends SuperWeapon implements Listener {
    private Paintball plugin = Paintball.getPlugin(Paintball.class);

    @EventHandler
    public void playerShoot(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Action action = event.getAction();
        Player player = event.getPlayer();
        Location ploc = player.getLocation();

        if (item == null)
            return;

//        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
//            if (item.isSimilar(getItem())) {
//                Entity drop = ploc.getWorld().dropItemNaturally(ploc, getItem());
//                drop.setVelocity(ploc.getDirection().multiply(1.2));
//
//                new BukkitRunnable() {
//                    @Override
//                    public void run() {
//                        ploc.getWorld();
//                        explodeGrenade(drop.getLocation(), getFragments());
//                        drop.remove();
//                    }
//                }.runTaskLater(plugin, 20 * getFuse());
//            }
//        }
    }

    public void shoot() {

    }
}
