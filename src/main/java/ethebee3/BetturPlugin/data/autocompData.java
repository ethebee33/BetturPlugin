package ethebee3.BetturPlugin.data;

import ethebee3.BetturPlugin.utils.logUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

import static ethebee3.BetturPlugin.data.dataCentral.makeYml;

public class autocompData {
    static File autocompDataFile;
    public static YamlConfiguration autocompDataConfig = new YamlConfiguration();

    public static void autocompData(JavaPlugin plugin){
        autocompDataFile = new File(plugin.getDataFolder(), "autocompData.yml");
        if (!autocompDataFile.exists()) {
            if (makeYml(autocompDataFile)) autocompDataConfig = YamlConfiguration.loadConfiguration(autocompDataFile);
        } else {
            autocompDataConfig = YamlConfiguration.loadConfiguration(autocompDataFile);
        }
    }

    public static void saveautocompData() {
        try {
            autocompDataConfig.save(autocompDataFile);
        } catch (IOException e) {
            logUtils.logError(e.getMessage());
        }
    }
}