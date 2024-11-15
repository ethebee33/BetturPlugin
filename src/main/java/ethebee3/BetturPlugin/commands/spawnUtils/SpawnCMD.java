package ethebee3.BetturPlugin.commands.spawnUtils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;

//temp data config import
import static ethebee3.BetturPlugin.data.tempData.tempDataConfig;
import static ethebee3.BetturPlugin.data.tempData.saveTempData;

public class SpawnCMD implements CommandExecutor {

    private final JavaPlugin plugin;
    public static Location spawnLocation;

    public SpawnCMD(JavaPlugin plugin) {
        this.plugin = plugin;
        loadSpawnLocation();
    }

    private void loadSpawnLocation() {
        if (tempDataConfig.contains("spawn")) {
            double x = tempDataConfig.getDouble("spawn.x");
            double y = tempDataConfig.getDouble("spawn.y");
            double z = tempDataConfig.getDouble("spawn.z");
            float yaw = (float) tempDataConfig.getDouble("spawn.yaw");
            float pitch = (float) tempDataConfig.getDouble("spawn.pitch");
            String worldName = tempDataConfig.getString("spawn.world");
            if (worldName != null) {
                spawnLocation = new Location(Bukkit.getWorld(worldName), x, y, z, yaw, pitch);
            }
        }
    }

    private void saveSpawnLocation(Location location) {
        tempDataConfig.set("spawn.x", location.getX());
        tempDataConfig.set("spawn.y", location.getY());
        tempDataConfig.set("spawn.z", location.getZ());
        tempDataConfig.set("spawn.yaw", location.getYaw());
        tempDataConfig.set("spawn.pitch", location.getPitch());
        tempDataConfig.set("spawn.world", location.getWorld().getName());
        saveTempData();
        loadSpawnLocation();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String command2, String[] args) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("This command can only be used by players.");
            return true;
        }

        switch (command2.toLowerCase()) {
            case "spawn" -> {
                if (spawnLocation != null) {
                    player.teleport(spawnLocation);
                } else {
                    player.sendMessage("Spawn location is not set.");
                }
            }
            case "setspawn" -> {
                if (!commandSender.hasPermission("BetturPlugin.setspawn")) {
                    commandSender.sendMessage("You dont have the permission to execute this command");
                    return true;
                }
                spawnLocation = player.getLocation();
                saveSpawnLocation(spawnLocation);
                player.sendMessage("Spawn location set to your current position.");
            }
            default -> {
                return false;
            }
        }
        return true;
    }
}
