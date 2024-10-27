package ethebee3.BetturPlugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ethebee3.BetturPlugin.Main;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class onAsyncPlayerChatEvent implements Listener {
    public onAsyncPlayerChatEvent(Main serverPlugin) {}
    //random constructor, dont question it


    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        boolean swearPresent = checkSwear(event.getMessage());
        if (swearPresent) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("A word in this sentence is not allowed");
        }
    }

    public boolean checkSwear(String message) {
        if (Main.words == null) {
            return false;
        }
        List<String> warnList = Main.words.getStringList("warnList");
        for (int i = 1; i < warnList.size(); i++) {
            String word = warnList.get(i);
            if (message.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
