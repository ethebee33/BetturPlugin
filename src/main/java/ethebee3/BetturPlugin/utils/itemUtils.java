package ethebee3.BetturPlugin.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class itemUtils {
    public static int hasEnchant(ItemStack item, Enchantment enchant) {
        int enchant2 = -1;
        enchant2 = item.getEnchantments().get(enchant);
        if (enchant2 == -1) {return enchant2;}
        return 0;
    }

    public static String convertItem(ItemStack item) {
        Material material = item.getType();
        int amount = item.getAmount();
        StringBuilder itemString = new StringBuilder(material.name() + ":" + amount);
        Map<Enchantment, Integer> enchantments = item.getEnchantments();
        if (!enchantments.isEmpty()) {
            for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
                Enchantment enchantment = entry.getKey();
                int level = entry.getValue();
                itemString.append(";").append(enchantment.getKey().getKey()).append("=").append(level);
            }
        }

        return itemString.toString();
    }

    public static ItemStack convertItem(String string) {
        String[] parts = string.split(";");
        String[] baseParts = parts[0].split(":");
        Material material = Material.getMaterial(baseParts[0]);
        int amount = Integer.parseInt(baseParts[1]);
        ItemStack item = new ItemStack(material, amount);
        for (int i = 1; i < parts.length; i++) {
            String[] enchantParts = parts[i].split("=");
            Enchantment enchantment = Enchantment.getByKey(org.bukkit.NamespacedKey.minecraft(enchantParts[0]));
            int level = Integer.parseInt(enchantParts[1]);
            item.addEnchantment(enchantment, level);
        }

        return item;
    }
}


