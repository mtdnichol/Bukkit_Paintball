package me.nichol.Paintball;

import me.nichol.Paintball.Items.GrenadeBomb;
import me.nichol.Paintball.Items.HEGrenade;
import me.nichol.Paintball.Items.ImpactGrenade;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Paintball extends JavaPlugin {
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nPaintball plugin has been enabled\n\n");

        //me.nichol.Paintball.Commands
        Commands commands = new Commands();

        this.getCommand(commands.cmd1).setExecutor(commands);

        //Events
        getServer().getPluginManager().registerEvents(new HEGrenade(), this);
        getServer().getPluginManager().registerEvents(new ImpactGrenade(), this);

        loadConfig();
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nPaintball plugin has been disabled\n\n");
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void runnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
            }
        }.run();
    }
}
