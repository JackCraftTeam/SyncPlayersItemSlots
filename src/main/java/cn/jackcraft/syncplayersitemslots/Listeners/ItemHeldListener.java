package cn.jackcraft.syncplayersitemslots.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class ItemHeldListener implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("syncplayersitemslots.bypass")) return;
        Player[] players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
        int currentSlot = event.getNewSlot();
        for (Player p : players){
            if (!p.equals(player) && !p.hasPermission("syncplayersitemslots.bypass")) {
                p.getInventory().setHeldItemSlot(currentSlot);
            }
        }
    }
}
