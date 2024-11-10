package ethebee3.BetturPlugin.utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class itemUtils {
    public static int hasEnchant(ItemStack item, Enchantment enchant) {
        int enchant2 = -1;
        enchant2 = item.getEnchantments().get(enchant);
        if (enchant2 == -1) {return enchant2;}
        return 0;
    }

}
