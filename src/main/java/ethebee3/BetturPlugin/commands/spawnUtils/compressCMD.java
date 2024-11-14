package ethebee3.BetturPlugin.commands.spawnUtils;
//this is all a test for compression
import ethebee3.BetturPlugin.utils.ItemUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ethebee3.BetturPlugin.utils.ItemUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class compressCMD implements CommandExecutor {
    private final JavaPlugin plugin;
    public compressCMD(JavaPlugin plugin) {this.plugin = plugin;}

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("BetturPlugin.Compress")) {
            sender.sendMessage("You Don't Have Permission to do this!");
            return true;
        }
        if (sender instanceof Player player) {
            ItemStack itemStack = player.getItemInHand();
            String compressed = ItemUtils.convertItemToString(itemStack);
            player.sendMessage(compressed);
        }
        return false;
    }

}
