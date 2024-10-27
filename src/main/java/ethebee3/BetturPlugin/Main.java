package ethebee3.BetturPlugin;

import ethebee3.BetturPlugin.commands.DupeCMD;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ethebee3.BetturPlugin.events.*;

//discord imports
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public final class Main extends JavaPlugin {
    public static YamlConfiguration words = null;
    private DiscordApi api;


    @Override
    public void onEnable() {
        registerListeners();
        registerCommands();
        initYml();

        new DiscordApiBuilder()
                .setToken("<Bot Token>")
                .login()
                .thenAccept(this::onConnectToDiscord)
                .exceptionally(error -> {
                    getLogger().warning("Failed to connect to Discord! Disabling plugin!");
                    getPluginLoader().disablePlugin(this);
                    return null;
                });
    }

    @Override
    public void onDisable() {
        if (api != null) {
            // Make sure to disconnect the bot when the plugin gets disabled
            api.disconnect();
            api = null;
        }
    }

    //more organized this way
    public void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new onAsyncPlayerChatEvent(this), this);
    }

    public void registerCommands() {
        //this.getCommand("dupe").setExecutor(new DupeCMD());
    }

    public void initYml() {}

    private void onConnectToDiscord(DiscordApi api) {
        this.api = api;

        // Log a message that the connection was successful and log the url that is needed to invite the bot
        getLogger().info("Connected to Discord as " + api.getYourself().getDiscriminatedName());
        getLogger().info("Open the following url to invite the bot: " + api.createBotInvite());
    }

}
