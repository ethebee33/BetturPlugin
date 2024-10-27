package ethebee3.ServerPlugin;

import ethebee3.ServerPlugin.commands.DupeCMD;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ethebee3.ServerPlugin.events.*;

import java.io.File;
import java.util.List;

public final class ServerPlugin extends JavaPlugin {
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

    //more organized this way
    public void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new onAsyncPlayerChatEvent(this), this);
    }

    public void registerCommands() {
        this.getCommand("dupe").setExecutor(new DupeCMD());
    }

    public void initYml() {}



}
