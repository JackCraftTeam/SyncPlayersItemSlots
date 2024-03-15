package cn.jackcraft.syncplayersitemslots;

import cn.jackcraft.syncplayersitemslots.Listeners.ItemHeldListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class SyncPlayersItemSlots extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ItemHeldListener(), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
