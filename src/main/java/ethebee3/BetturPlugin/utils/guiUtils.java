package ethebee3.BetturPlugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import ethebee3.BetturPlugin.Main;
import java.io.File;

//this file will be used to open a gui of any sort with a name and set number of slots, similar to olly's skript
public class guiUtils {

    public File guiYML = Main.guiFile;
    public FileConfiguration guiConfig = Main.guiConfig;

    public Inventory inv;
    public Inventory createGUI(Player Owner, String name, Integer slots) {
        inv = Bukkit.createInventory(Owner, slots, name);
        addToYML(inv);
        return inv;

    }

    public void addToYML(Inventory toSave) {
        String Title = toSave.toString();
        guiConfig.set(Title, toSave);
    }
}
