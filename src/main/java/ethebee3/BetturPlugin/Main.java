package ethebee3.BetturPlugin;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
//changed to commands.spawnUtils.*;
//import ethebee3.BetturPlugin.commands.spawnUtils.pvpCMD;
//import ethebee3.BetturPlugin.commands.spawnUtils.ClearChatCMD;
//import ethebee3.BetturPlugin.commands.spawnUtils.SpawnCMD;
//import ethebee3.BetturPlugin.commands.spawnUtils.StaffChatCMD;
import ethebee3.BetturPlugin.commands.spawnUtils.*;

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

    //TODO: make tempdata and wordsFile stored in dataCentral
    public static File guiFile;
    public static FileConfiguration guiConfig;

    @Deprecated
    public void registerConfigs() {
        //GUIs.yml
        guiFile = new File(this.getDataFolder(), "GUIs.yml");
        if (!guiFile.exists()) {
            if (makeYml(guiFile)) guiConfig = YamlConfiguration.loadConfiguration(guiFile);
        } else {
            guiConfig = YamlConfiguration.loadConfiguration(guiFile);
        }
    }

    public void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new onBreak(this), this);
        this.getServer().getPluginManager().registerEvents(new onMessage(this), this);
        this.getServer().getPluginManager().registerEvents(new onDeath(this), this);
        this.getServer().getPluginManager().registerEvents(new onDamage(this), this);
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
        this.getCommand("compress").setExecutor(new compressCMD(this));
        this.getCommand("decompress").setExecutor(new decompressCMD(this));
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
