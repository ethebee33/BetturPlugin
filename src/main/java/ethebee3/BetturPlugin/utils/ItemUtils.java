package ethebee3.BetturPlugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class ItemUtils {
    public static int hasEnchant(ItemStack item, Enchantment enchant) {
        int enchant2 = -1;
        try {
            enchant2 = item.getEnchantments().get(enchant);
        } catch (NullPointerException e) {
            return 0;
        }
        if (enchant2 == -1) {return enchant2;}
        return 0;
    }

    public static String convertItemToString(ItemStack item) {
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

    public static ItemStack convertStringtoItem(String string) {
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

    public static ItemStack getSmeltedItem(ItemStack item) {
        FurnaceRecipe smeltingRecipe = getSmeltingRecipe(item);
        if (smeltingRecipe != null) {
            return smeltingRecipe.getResult();
        }
        return null;
    }

    public static FurnaceRecipe getSmeltingRecipe(ItemStack item) {
        NamespacedKey key = new NamespacedKey("minecraft", "smelting/" + item.getType().name().toLowerCase());
        return (FurnaceRecipe) Bukkit.getRecipe(key);
    }

}


