package org.horizons_server.radiusrender;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RenderCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        final RadiusRender plugin = RadiusRender.getPlugin();

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }
        Player player = (Player) sender;

        if (args.length < 1) return false;

        final int currentTPS = plugin.getTPSCalculator().getTPS();
        final int minimumTPS = plugin.getConfig().getInt("minimum-ticks-per-second");
        if (currentTPS < minimumTPS) {
            sender.sendMessage(ChatColor.RED + String.format("The TPS is too low to perform a render (currently at %s). The minimum allowed TPS is %s.", currentTPS, minimumTPS));
            return true;
        }

        final int requestedRadius = Integer.parseInt(args[0]);
        final int maximumRadius = plugin.getConfig().getInt("maximum-radius");
        if (requestedRadius > maximumRadius) {
            sender.sendMessage(ChatColor.RED + String.format("The maximum radius you can render is %s!", maximumRadius));
            return true;
        }

        final Location location = player.getLocation();
        plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), String.format("dynmap radiusrender %s %s %s %s", location.getWorld().getName(), location.getBlockX(), location.getBlockZ(), args[0]));
        sender.sendMessage(ChatColor.DARK_AQUA + "Your render is starting!");
        return true;
    }
}
