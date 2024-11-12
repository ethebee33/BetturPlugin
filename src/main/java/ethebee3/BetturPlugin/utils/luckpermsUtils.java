package ethebee3.BetturPlugin.utils;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.PrefixNode;
import org.bukkit.entity.Player;

public class luckpermsUtils {

    public static String getPrefix(Player player) {
        LuckPerms luckPerms = LuckPermsProvider.get();

        // Get the User object for the player
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
        if (user == null) {
            return null; // User not found
        }

        // Get the highest-priority prefix
        return user.getCachedData()
                .getMetaData()
                .getPrefix();
    }
}