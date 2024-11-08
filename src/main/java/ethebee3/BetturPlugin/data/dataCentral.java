package ethebee3.BetturPlugin.data;

import ethebee3.BetturPlugin.Main;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataCentral {

    private Main plugin;

    private YamlConfiguration yaml;



    public static void dataCentralLoad(Main plugin) {
        //tempdata
        playerData.playerData(plugin);
    }
}
