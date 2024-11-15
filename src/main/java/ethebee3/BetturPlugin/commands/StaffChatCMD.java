package ethebee3.BetturPlugin.commands;

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

public class StaffChatCMD implements CommandExecutor {

    private final JavaPlugin plugin;

    public StaffChatCMD(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String command2, String[] args) {
        //TODO: fix staffchat, not sure why its broken someone help :sob:
        if (!commandSender.hasPermission("BetturPlugin.staffchat")) {
            commandSender.sendMessage("You must have staff to execute this command");
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
