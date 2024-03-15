package cn.jackcraft.syncplayersitemslots.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;

public class PlayerJoinListener implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("syncplayersitemslots.bypass")) return;
        Map<Integer, Integer> slotCounts = new HashMap<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!p.hasPermission("syncplayersitemslots.bypass")) continue;
            int slot = p.getInventory().getHeldItemSlot();
            slotCounts.put(slot, slotCounts.getOrDefault(slot, 0) + 1);
        }
        int mostCommonSlot = -1;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : slotCounts.entrySet()) {
            int slot = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount) {
                mostCommonSlot = slot;
                maxCount = count;
            }
        }
        if (mostCommonSlot != -1) {
            player.getInventory().setHeldItemSlot(mostCommonSlot);
        }
    }
}