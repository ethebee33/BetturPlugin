package ethebee3.BetturPlugin.utils;

import ethebee3.BetturPlugin.Main;
import org.bukkit.plugin.java.JavaPlugin;

public class logUtils {
    private static JavaPlugin plugin;
    public static void registerLogger(Main main) {
        plugin = main;
    }

    public static void logInfo(String message) {
        plugin.getLogger().info(message);
    }

    public static void logWarning(String message) {
        plugin.getLogger().warning(message);
    }

    public static void logError(String message) {
        plugin.getLogger().warning("ERROR: "+message);
    }
}
