package dev.professionalflare.sst.listeners;

import dev.professionalflare.sst.SimpleServerTransfer;
import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MiscListener implements Listener {

    private final SimpleServerTransfer plugin;

    public MiscListener(SimpleServerTransfer plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPing(PaperServerListPingEvent event) {
        if (plugin.getConfig().getBoolean("motd.hide-online-count")) {
            event.setNumPlayers(-1);
        }
        if (plugin.getConfig().getBoolean("motd.hide-max-count")) {
            event.setMaxPlayers(-1);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        if (plugin.getConfig().getBoolean("messages.hide-join-message")) {
            event.setJoinMessage(null);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQuit(PlayerQuitEvent event) {
        if (plugin.getConfig().getBoolean("messages.hide-quit-message")) {
            event.setQuitMessage(null);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onChat(AsyncPlayerChatEvent event) {
        if (plugin.getConfig().getBoolean("player.block-chat")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (plugin.getConfig().getBoolean("player.block-commands")) {
            if (!event.getPlayer().isOp()) {
                event.setCancelled(true);
            }
        }
    }
}
