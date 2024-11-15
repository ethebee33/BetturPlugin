package ethebee3.BetturPlugin.commands;

import ethebee3.BetturPlugin.events.onInvClose;
import ethebee3.BetturPlugin.utils.guiUtils;
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


public class autocompconfigCMD implements CommandExecutor {

    private final JavaPlugin plugin;
    public static Location spawnLocation;

    public autocompconfigCMD(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    //TODO: finish command later (ethebee3 only)

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String command2, String[] args) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("This command can only be used by players.");
            return true;
        }

        switch (command2.toLowerCase()) {
            case "input" -> {

            }
            case "output" -> {

            }
            default -> {
                return false;
            }
        }
        return true;
    }
}
