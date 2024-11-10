package ethebee3.BetturPlugin.utils;

import com.google.common.base.Strings;
import com.sun.jdi.Value;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class ItemUtils {

    public String compressItemString(ItemStack item) {
        String itemType = String.valueOf(item.getType());
        String amount = String.valueOf(item.getAmount());
        //String itemName = item.getItemMeta().getItemName();
        // Set<ItemFlag> flags = item.getItemMeta().getItemFlags();
        //String itemEnchants = "";
        //String unbreakable = String.valueOf(item.getItemMeta().isUnbreakable());
        String attributes = item.getItemMeta().getAsString();

        //for(int x = 1; x < item.getItemMeta().getEnchants().size(); x++) {
          //  itemEnchants = String.join(";", String.valueOf(item.getItemMeta().getEnchants()));
        //}
        String Compressed = String.join(",", itemType, amount, attributes);
        // itemType, itemName, itemEnchants
        return Compressed;


    }

    public ItemStack decompressItemString(String string){
        //type and amount
        List<String> strings = new ArrayList<String>(Arrays.asList(string.split(",")));

        ItemStack itemsToGive = new ItemStack(Material.valueOf(strings.get(1)), Integer.parseInt(strings.get(2)));
        //enchants
       // String enchantsToSplit = new String(strings.get(4));
       // List<String> enchants = new ArrayList<String>(Arrays.asList(enchantsToSplit.split(";")));
       // List<HashMap> addEnchants = new ArrayList<HashMap>();
      //  for (int e = 1; e < enchants.size(); e++) {
            //enchant=value -> enchant, value
        //    String EnchVal = enchants.get(e);
        //    List<String> SepEnchVal = new ArrayList<String>(Arrays.asList(EnchVal.split("=")));
            //List: Ench, Value
        //    Enchantment Enchant = Enchantment.getByName(SepEnchVal.get(1));
        //    Integer Value = Integer.valueOf(SepEnchVal.get(2));
        //    HashMap<Enchantment, Integer> enchantmentsToAdd = new HashMap<Enchantment, Integer>();
        //    enchantmentsToAdd.put(Enchant, Value);
         //   addEnchants.add(enchantmentsToAdd);
        //}
        //for (int enchant = 1; enchant < addEnchants.size(); enchant++) {
        //    HashMap neededEnchant = addEnchants.get(enchant);
        //    itemsToGive.addEnchantments(neededEnchant);
        //}
        // item name

        itemsToGive.getItemMeta().setItemName(strings.get(3));
        // other flags (hiding attributes like unbreakable)
        ItemFlag flags = ItemFlag.valueOf(strings.get(5));
        itemsToGive.getItemMeta().addItemFlags(flags);

        // unbreakable
        //boolean isUnbreakable = Boolean.parseBoolean(strings.get(6));
       // itemsToGive.getItemMeta().setUnbreakable(isUnbreakable);

        //attributes (all)

        String attFromString = strings.get(5);
        //turn into a string?

        return  itemsToGive;
    }
}