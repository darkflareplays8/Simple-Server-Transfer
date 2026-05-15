package dev.professionalflare.sst;

import dev.professionalflare.sst.listeners.LimiterListener;
import dev.professionalflare.sst.listeners.MiscListener;
import dev.professionalflare.sst.listeners.TransferListener;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleServerTransfer extends JavaPlugin {

    private static SimpleServerTransfer instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        if (!getConfig().getBoolean("proxy-mode")) {
            getLogger().info("Proxy mode is disabled. Plugin is inactive.");
            return;
        }

        getServer().getPluginManager().registerEvents(new TransferListener(this), this);
        getServer().getPluginManager().registerEvents(new MiscListener(this), this);

        if (getConfig().getBoolean("server-limiter")) {
            getServer().getPluginManager().registerEvents(new LimiterListener(), this);
            getServer().getWorlds().forEach(w -> w.setAutoSave(false));
            getLogger().info("Server limiter is active.");
        }

        if (getConfig().getBoolean("world.lock-time")) {
            getServer().getWorlds().forEach(w -> w.setGameRule(org.bukkit.GameRule.DO_DAYLIGHT_CYCLE, false));
        }

        if (getConfig().getBoolean("world.lock-weather")) {
            getServer().getWorlds().forEach(w -> {
                w.setStorm(false);
                w.setThundering(false);
                w.setGameRule(org.bukkit.GameRule.DO_WEATHER_CYCLE, false);
            });
        }

        getLogger().info("Proxy mode enabled. Transfers active.");
    }

    @Override
    public void onDisable() {
    }

    public static SimpleServerTransfer getInstance() {
        return instance;
    }
}
