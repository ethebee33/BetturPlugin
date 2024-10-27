package ethebee3.BetturPlugin;

import ethebee3.BetturPlugin.commands.DupeCMD;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ethebee3.BetturPlugin.events.*;

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

    //more organized this way
    public void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new onAsyncPlayerChatEvent(this), this);
    }

    public void registerCommands() {
        //this.getCommand("dupe").setExecutor(new DupeCMD());
    }

    public void initYml() {}



}
