package ethebee3.BetturPlugin.events;

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

        //event.setCancelled(true);
        /**
        for(Player player : Bukkit.getOnlinePlayers()) {
            StringBuilder gradient = Gradient.formatGradientStringBuilder(event.getMessage(), "#000000", "#FFFFFF");
            TODO: make a config part of playerData for gradient settings
            String message = chatUtils.formatMessageForPlayer(gradient, event.getPlayer());
            chatUtils.sendMessage(player, message, false);
        }*/

    }
}
