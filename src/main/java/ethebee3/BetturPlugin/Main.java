package ethebee3.BetturPlugin;

import ethebee3.BetturPlugin.commands.spawnUtils.ClearChatCMD;
import ethebee3.BetturPlugin.commands.spawnUtils.SpawnCMD;
import ethebee3.BetturPlugin.commands.spawnUtils.StaffChatCMD;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ethebee3.BetturPlugin.events.*;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        registerConfigs();
        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {

    }

    //TODO: make a default config, to store configurations
    public static File tempDataFile;
    public static File wordsFile;
    public static FileConfiguration tempDataConfig;
    public static FileConfiguration wordsConfig;
    public void registerConfigs() {
        //tempdata.yml
        tempDataFile = new File(this.getDataFolder(), "tempData.yml");
        if (!tempDataFile.exists()) {
            if (makeYml(tempDataFile)) tempDataConfig = YamlConfiguration.loadConfiguration(tempDataFile);
        } else {
            tempDataConfig = YamlConfiguration.loadConfiguration(tempDataFile);
        }
        //words.yml
        wordsFile = new File(this.getDataFolder(), "words.yml");
        if (!wordsFile.exists()) {
            if (makeYml(wordsFile)) wordsConfig = YamlConfiguration.loadConfiguration(wordsFile);
        } else {
            wordsConfig = YamlConfiguration.loadConfiguration(wordsFile);
        }
    }

    public void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new onMessage(this), this);
        this.getServer().getPluginManager().registerEvents(new onDeath(this), this);
    }

    public void registerCommands() {
        //spawn commands
        this.getCommand("spawn").setExecutor(new SpawnCMD(this));
        this.getCommand("setspawn").setExecutor(new SpawnCMD(this));
        //clear chat
        this.getCommand("clearchat").setExecutor(new ClearChatCMD(this));
        //staffchat command
        this.getCommand("staffchat").setExecutor(new StaffChatCMD(this));
    }

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
