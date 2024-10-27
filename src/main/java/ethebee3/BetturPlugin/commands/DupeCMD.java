package ethebee3.BetturPlugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DupeCMD implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player player) {
            ItemStack heldItem = player.getInventory().getItemInMainHand();
            boolean shouldDupe = checkItemType(heldItem);
            int dupeAmount;
            try { // makes dupe amount an int if its set
                dupeAmount = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                dupeAmount = 1;
            }
            if (shouldDupe) {
                int numItems = heldItem.getAmount() * dupeAmount;
                ItemStack newItem = new ItemStack(heldItem.getType(), numItems);
                player.getInventory().addItem(newItem);
            } else {
                //send message to say you need to hold air
            }
        }
        return true;
    }


    public boolean checkItemType(ItemStack heldItem) {
        if (heldItem.getType() == Material.AIR) return false;
        if (heldItem.getType() == Material.ENCHANTED_GOLDEN_APPLE) return false;
        return true;
    }
}
