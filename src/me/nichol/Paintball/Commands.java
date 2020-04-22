package me.nichol.Paintball;

import me.nichol.Paintball.Items.Weapons.Grenade;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    public String cmd1 = "test";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        switch (command.getName().toLowerCase()) {
            case "test":
                return testCommand(player, args);
            default:
                player.sendMessage(ChatColor.RED + "Command not recognized!");
                break;
        }

        return true;
    }

    public boolean testCommand(Player player, String[] args) {
        if (args.length != 0) { //Ensures there is at least one argument
            switch (args[0].toLowerCase()) {
                case "grenade":
                    Grenade grenade = new Grenade();
                    grenade.giveItem(player);
                    return true;
                default:
                    player.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.RED + " is not a recognized item!");
                    break;
            }
        }

        return true;
    }
}
