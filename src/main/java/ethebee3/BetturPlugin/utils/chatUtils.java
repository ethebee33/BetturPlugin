package ethebee3.BetturPlugin.utils;

import org.bukkit.entity.Player;

public class chatUtils {
    //TODO: make prefix set by default config
    static String prefix = "&#5FE2C5&lB&#73E6CC&le&#87E9D4&lt&#9BEDDB&lt&#AFF1E2&lu&#C3F4E9&lr&#D7F8F1&lB&#EBFBF8&lo&#FFFFFF&lx: &r";

    public static void sendMessage(Player player, String message, Boolean usePrefix) {
        if (usePrefix) {
            player.sendMessage(String.join(prefix, message));
        } else {
            player.sendMessage(message);
        }
    }


}
