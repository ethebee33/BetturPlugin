package ethebee3.BetturPlugin.utils;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import org.bukkit.entity.Player;

public class worldguardUtils {

    public static boolean isPlayerInRegion(Player player, String regionName) {
        // Get the WorldGuard instance
        WorldGuard worldGuard = WorldGuard.getInstance();

        // Get the region manager for the player's world
        RegionManager regionManager = worldGuard.getPlatform().getRegionContainer()
                .get(BukkitAdapter.adapt(player.getWorld()));
        if (regionManager == null) {
            return false; // No regions defined in this world
        }

        // Get the player's current location
        com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(player.getLocation());
        BlockVector3 blockVector = loc.toVector().toBlockPoint();

        // Get the regions at the player's location
        ApplicableRegionSet regions = regionManager.getApplicableRegions(blockVector);

        // Check if the specified region is among them
        for (ProtectedRegion region : regions) {
            if (region.getId().equalsIgnoreCase(regionName)) {
                return true;
            }
        }

        return false;
    }

}
