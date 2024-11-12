package ethebee3.BetturPlugin;

import ethebee3.BetturPlugin.commands.spawnUtils.pvpCMD;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

import ethebee3.BetturPlugin.commands.spawnUtils.ClearChatCMD;
import ethebee3.BetturPlugin.commands.spawnUtils.SpawnCMD;
import ethebee3.BetturPlugin.commands.spawnUtils.StaffChatCMD;

import ethebee3.BetturPlugin.events.*;

import static ethebee3.BetturPlugin.data.dataCentral.dataCentralLoad;
import static ethebee3.BetturPlugin.discord.discordBot.registerBot;
import static ethebee3.BetturPlugin.discord.discordBot.unregisterBot;
import static ethebee3.BetturPlugin.utils.logUtils.registerLogger;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        registerConfigs();
        dataCentralLoad(this);
        registerListeners();
        registerCommands();
        registerLogger(this);
        registerBot(this);
    }

    @Override
    public void onDisable() {
        unregisterBot();
    }

    //TODO: make a default config, to store configurations
    public static File tempDataFile;
    public static File wordsFile;
    public static FileConfiguration tempDataConfig;
    public static FileConfiguration wordsConfig;

    @Deprecated
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
        this.getServer().getPluginManager().registerEvents(new onBreak(this), this);
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
        //pvp
        this.getCommand("pvp").setExecutor(new pvpCMD(this));
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
