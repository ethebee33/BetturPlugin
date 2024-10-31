package ethebee3.BetturPlugin.commands.spawnUtils;

import ethebee3.BetturPlugin.utils.ChatUtils.StaffUtils;
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
import java.util.Arrays;

//temp data config import
import static ethebee3.BetturPlugin.Main.tempDataConfig;
import static ethebee3.BetturPlugin.Main.tempDataFile;

public class StaffChatCMD implements CommandExecutor {

    private final JavaPlugin plugin;

    public StaffChatCMD(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String command2, String[] args) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("This command can only be used by players.");
            return true;
        }

        if (args == null) {
            if (StaffUtils.hasSCon.contains(commandSender.getName())) {
                StaffUtils.hasSCon.remove(commandSender.getName());
            } else {
                StaffUtils.hasSCon.add(commandSender.getName());
            }
        } else {
            StaffUtils.sendStaffChatMessage(((Player) commandSender), Arrays.toString(args));
        }

        return true;
    }
}
