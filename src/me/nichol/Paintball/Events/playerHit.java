package me.nichol.Paintball.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class playerHit implements Listener {
    @EventHandler
    public void hit(ProjectileHitEvent event) {
        if (event.getHitEntity() instanceof Player) {
            System.out.println(1);
        }
    }
}
