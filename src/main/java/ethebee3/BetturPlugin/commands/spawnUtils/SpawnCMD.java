package ethebee3.BetturPlugin.commands.spawnUtils;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpawnCMD implements CommandExecutor {

    public void init() {

    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player player) {

        }
        return true;
    }

    public boolean spawn() {
        return true;
    }
    public boolean setSpawn() {
        return true;
    }
    public boolean delSpawn() {
        return true;
    }
}
