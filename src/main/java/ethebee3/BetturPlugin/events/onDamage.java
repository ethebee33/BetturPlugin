package ethebee3.BetturPlugin.events;

//import com.sk89q.worldedit.bukkit.BukkitAdapter;
//import com.sk89q.worldguard.bukkit.RegionContainer;
//import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
//import com.sk89q.worldguard.protection.ApplicableRegionSet;
//import com.sk89q.worldguard.protection.managers.RegionManager;
//import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import ethebee3.BetturPlugin.Main;
import ethebee3.BetturPlugin.data.playerData;
import ethebee3.BetturPlugin.utils.worldguardUtils;

public class onDamage implements Listener {
    private final Main plugin;

    public onDamage(Main serverPlugin) {
        this.plugin = serverPlugin;
    }

    @EventHandler
    public void onMessage(EntityDamageByEntityEvent event) {
        Entity victim = event.getEntity();
        Entity attacker = event.getDamager();

        if (victim instanceof Player victimPlayer && attacker instanceof Player attackerPlayer) {
            YamlConfiguration victimPlayerData = playerData.getDataForPlayer(victimPlayer.getUniqueId());
            YamlConfiguration attackerPlayerData = playerData.getDataForPlayer(attackerPlayer.getUniqueId());

            if (victimPlayerData.getBoolean("pvp") || attackerPlayerData.getBoolean("pvp")) {
                if (!worldguardUtils.isPlayerInRegion(victimPlayer, "kothOuter")) {
                    event.setCancelled(true);
                    attackerPlayer.sendMessage("PvP is not allowed outside the 'koth' region!");
                }
            }
        }
    }

}
