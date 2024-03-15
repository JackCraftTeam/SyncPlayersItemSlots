package cn.jackcraft.syncplayersitemslots;

import cn.jackcraft.syncplayersitemslots.Listeners.ItemHeldListener;
import cn.jackcraft.syncplayersitemslots.Listeners.PlayerJoinListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class SyncPlayersItemSlots extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ItemHeldListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
