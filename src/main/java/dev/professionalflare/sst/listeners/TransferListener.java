package dev.professionalflare.sst.listeners;

import dev.professionalflare.sst.SimpleServerTransfer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TransferListener implements Listener {

    private final SimpleServerTransfer plugin;

    public TransferListener(SimpleServerTransfer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = plugin.getConfig();
        int delay = config.getInt("transfer-delay-ticks", 40);

        plugin.getServer().getRegionScheduler().runDelayed(plugin, player.getLocation(), scheduledTask -> {
            if (!player.isOnline()) return;

            if (config.getBoolean("geyser-support") && isBedrockPlayer(player)) {
                String host = config.getString("bedrock-transfer-host", "play.example.com");
                int port = config.getInt("bedrock-transfer-port", 19132);
                player.transfer(host, port);
            } else {
                String host = config.getString("transfer-host", "play.example.com");
                int port = config.getInt("transfer-port", 25565);
                player.transfer(host, port);
            }
        }, delay);
    }

    private boolean isBedrockPlayer(Player player) {
        try {
            Class<?> apiClass = Class.forName("org.geysermc.floodgate.api.FloodgateApi");
            Object api = apiClass.getMethod("getInstance").invoke(null);
            return (boolean) apiClass.getMethod("isFloodgatePlayer", java.util.UUID.class)
                    .invoke(api, player.getUniqueId());
        } catch (Exception e) {
            return false;
        }
    }
}