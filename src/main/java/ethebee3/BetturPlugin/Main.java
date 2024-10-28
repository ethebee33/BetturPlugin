package ethebee3.BetturPlugin;

import ethebee3.BetturPlugin.commands.DupeCMD;
import ethebee3.BetturPlugin.commands.spawnUtils.SpawnCMD;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ethebee3.BetturPlugin.events.*;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {
    public static YamlConfiguration words = null;


    @Override
    public void onEnable() {
        registerListeners();
        registerCommands();
        initYml();
    }

    @Override
    public void onDisable() {

    }

    //TODO: make a default config, to store configurations
    private File temp;
    public static FileConfiguration tempDataConfig;
    public static FileConfiguration wordsConfig;
    public void registerConfigs() {
        //tempdata.yml
        temp = new File(this.getDataFolder(), "tempData.yml");
        if (!temp.exists()) {
            if (makeYml(temp)) tempDataConfig = YamlConfiguration.loadConfiguration(temp);
        } else {
            tempDataConfig = YamlConfiguration.loadConfiguration(temp);
        }
        //words.yml
        temp = new File(this.getDataFolder(), "words.yml");
        if (!temp.exists()) {
            if (makeYml(temp)) wordsConfig = YamlConfiguration.loadConfiguration(temp);
        } else {
            wordsConfig = YamlConfiguration.loadConfiguration(temp);
        }
    }

    //more organized this way
    public void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new onMessage(this), this);
    }

    public void registerCommands() {
        //this.getCommand("dupe").setExecutor(new DupeCMD());
        //spawn commands
        this.getCommand("spawn").setExecutor(new SpawnCMD(this));
        this.getCommand("setspawn").setExecutor(new SpawnCMD(this));
    }

    public void initYml() {}

    public boolean makeYml(File temp) {
        try {
            temp.createNewFile();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
