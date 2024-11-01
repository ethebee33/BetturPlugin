package ethebee3.BetturPlugin.events;

import ethebee3.BetturPlugin.utils.itemUtils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ethebee3.BetturPlugin.Main;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;



public class onBreak implements Listener {
    private final Main plugin;
    public onBreak(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (event.getPlayer().getItemInUse() != null) {
            event.setDropItems(false);
            Collection<ItemStack> drops = calcItems(event.getPlayer().getItemInUse(), event.getBlock());
            spawnItems(drops, event);
        }
    }

    public Collection<ItemStack> calcItems(ItemStack tool, Block block) {
        int fortuneLevel = itemUtils.hasEnchant(tool, Enchantment.LOOT_BONUS_BLOCKS);
        Collection<ItemStack> drops = block.getDrops(tool);

        if (fortuneLevel > 0) {
            for (ItemStack drop : drops) {
                drop.setAmount(drop.getAmount() * fortuneLevel);
            }
        }

        return drops;
    }

    public void spawnItems(Collection<ItemStack> drops, BlockBreakEvent event) {
        //finish
    }

}
