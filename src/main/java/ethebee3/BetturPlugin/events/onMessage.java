package ethebee3.BetturPlugin.events;

import ethebee3.BetturPlugin.utils.chatUtils;
import ethebee3.BetturPlugin.utils.color.ColorFormat;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;
import ethebee3.BetturPlugin.utils.ChatUtils.SwearUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ethebee3.BetturPlugin.Main;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.logging.Level;

public class onMessage implements Listener {
    private final Main plugin;
    public onMessage(Main serverPlugin) {
        this.plugin = serverPlugin;
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        //SwearUtils.checkForSwearing(event);
        for(Player player : Bukkit.getOnlinePlayers()) {
            String e = ColorFormat.formatText(event.getMessage());
            plugin.getLogger().log(Level.INFO, e);
            chatUtils.sendMessage(player, e, false);
        }

    }
}
