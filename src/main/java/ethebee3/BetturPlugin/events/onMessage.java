package ethebee3.BetturPlugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ethebee3.BetturPlugin.Main;
import ethebee3.BetturPlugin.utils.ChatUtils;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class onMessage implements Listener {
    private final Main plugin;
    public onMessage(Main serverPlugin) {
        this.plugin = serverPlugin;
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        String swear = checkSwear(event.getMessage());
        if (swear != null) {
            event.setCancelled(true);
            ChatUtils.sendMessage(event.getPlayer(), String.join("A word in this sentence is not allowed:", swear), true);
            ChatUtils.sendMessage(event.getPlayer(), event.getMessage(), false);
            ChatUtils.sendMessage(event.getPlayer(), "If you think this is wrong, please report it", false); //change this to true?? idrk might look better
        }
    }

    public String checkSwear(String message) {
        if (Main.wordsConfig == null) {
            return null;
        }
        List<String> warnList = Main.wordsConfig.getStringList("warnList");
        for (int i = 1; i < warnList.size(); i++) {
            String word = warnList.get(i);
            if (message.contains(word)) {
                return word;
            }
        }
        return null;
    }
}
