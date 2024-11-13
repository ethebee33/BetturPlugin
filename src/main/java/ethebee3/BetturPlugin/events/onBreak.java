package ethebee3.BetturPlugin.events;

import ethebee3.BetturPlugin.utils.itemUtils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ethebee3.BetturPlugin.Main;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;

public class onBreak implements Listener {
    private final Main plugin;

    public onBreak(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack tool = player.getInventory().getItemInMainHand();

        event.setDropItems(false);
        Collection<ItemStack> drops = calcItems(tool, event.getBlock());
        spawnItems(drops, event);

    }

    public Collection<ItemStack> calcItems(ItemStack tool, Block block) {
        int fortuneLevel = itemUtils.hasEnchant(tool, Enchantment.FORTUNE);
        Collection<ItemStack> drops = block.getDrops(tool);

        if (fortuneLevel > 0) {
            for (ItemStack drop : drops) {
                drop.setAmount(drop.getAmount() * fortuneLevel);
            }
        }

        return drops;
    }

    public void spawnItems(Collection<ItemStack> drops, BlockBreakEvent event) {
        Block block = event.getBlock();
        PlayerInventory inventory = event.getPlayer().getInventory();
        if (event.isCancelled()) return;
        for (ItemStack drop : drops) {
            HashMap<Integer, ItemStack> remainingItems = inventory.addItem(drop);

            // Drop remaining items if inventory is full
            if (!remainingItems.isEmpty()) {
                remainingItems.values().forEach(item ->
                        block.getWorld().dropItemNaturally(block.getLocation(), item)
                );
            }
        }
    }
}
