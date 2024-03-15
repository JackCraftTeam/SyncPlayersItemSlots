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
        Map<Integer, Integer> slotCounts = new HashMap<>();
        // 获取玩家
        Player player = event.getPlayer();
        // 遍历所有在线玩家
        for (Player p : Bukkit.getOnlinePlayers()) {
            int slot = p.getInventory().getHeldItemSlot();
            // 统计每个栏位的出现频率
            slotCounts.put(slot, slotCounts.getOrDefault(slot, 0) + 1);
        }
        // 找到出现频率最高的栏位
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
            // 设置槽位
            player.getInventory().setHeldItemSlot(mostCommonSlot);
        }
    }
}