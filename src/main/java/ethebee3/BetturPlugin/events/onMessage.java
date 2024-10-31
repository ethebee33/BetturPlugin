package ethebee3.BetturPlugin.events;

import ethebee3.BetturPlugin.utils.ChatUtils.SwearUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ethebee3.BetturPlugin.Main;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onMessage implements Listener {
    private final Main plugin;
    public onMessage(Main serverPlugin) {
        this.plugin = serverPlugin;
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        SwearUtils.checkForSwearing(event);

    }
}
