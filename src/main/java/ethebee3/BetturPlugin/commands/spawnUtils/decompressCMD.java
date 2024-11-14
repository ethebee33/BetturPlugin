package ethebee3.BetturPlugin.commands.spawnUtils;
//this is all a test for compression
import ethebee3.BetturPlugin.utils.ItemUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;


public class decompressCMD implements CommandExecutor {
    private final JavaPlugin plugin;
    public decompressCMD(JavaPlugin plugin) {this.plugin = plugin;}
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("BetturPlugin.Compress")) {
            sender.sendMessage("You Don't Have Permission to do this!");
            return true;
        }
        if (sender instanceof Player player) {
            if (!(args == null)){
                if (args.length == 1) {
                    String compressed = String.valueOf(args);
                    ItemStack itemStack = ItemUtils.convertStringtoItem(compressed);
                    PlayerInventory inventory = player.getInventory();
                    inventory.addItem(itemStack);
                }
            }
        }
        return false;
    }

}