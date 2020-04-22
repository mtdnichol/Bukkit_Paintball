package me.nichol.Paintball.Events;

import me.nichol.Paintball.Items.Weapons.Grenade;
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

public class GrenadeBomb implements Listener {
    private Paintball plugin = Paintball.getPlugin(Paintball.class);
    private Grenade grenade = new Grenade();

    @EventHandler
    public void throwGrenade(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Action action = event.getAction();
        Player player = event.getPlayer();
        Location ploc = player.getLocation();

        if (item == null)
            return;

        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (item.getType().equals(grenade.getItem().getType())) {
                System.out.println(1);

                item.setAmount(item.getAmount() - 1);
                Entity drop = ploc.getWorld().dropItemNaturally(ploc, grenade.getItem());
                drop.setVelocity(ploc.getDirection().multiply(1.2));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        ploc.getWorld().createExplosion(drop.getLocation(), 0, false);
                        drop.remove();
                    }
                }.runTaskLater(plugin, 80);
            }
        }
    }
}
