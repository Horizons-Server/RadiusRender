package org.horizons_server.radiusrender;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.Set;
import java.util.UUID;

public class FakeCommandSender implements CommandSender {

    private final Player player;
    private final String name;

    public FakeCommandSender(Player player) {
        this.player = player;
        this.name = player.getName();
    }

    @Override
    public void sendMessage(String s) {
        RadiusRender.getPlugin().getLogger().info(String.format("Radiusrender by %s: %s", this.name, s));
        if (player.isOnline()) {
            player.sendMessage(ChatColor.AQUA + s);
        }
    }

    @Override
    public boolean isPermissionSet(String s) {
        return true;
    }

    @Override
    public boolean isPermissionSet(Permission permission) {
        return true;
    }

    @Override
    public boolean hasPermission(String s) {
        return true;
    }

    @Override
    public boolean hasPermission(Permission permission) {
        return true;
    }

    @Override
    public boolean isOp() {
        return true;
    }

    // Need to be declared but no need to use:

    @Override
    public void sendMessage(String[] strings) {

    }

    @Override
    public void sendMessage(UUID uuid, String s) {

    }

    @Override
    public void sendMessage(UUID uuid, String[] strings) {

    }

    @Override
    public Server getServer() {
        return null;
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public Spigot spigot() {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int i) {
        return null;
    }

    @Override
    public void removeAttachment(PermissionAttachment permissionAttachment) {

    }

    @Override
    public void recalculatePermissions() {

    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return null;
    }

    @Override
    public void setOp(boolean b) {

    }
}
