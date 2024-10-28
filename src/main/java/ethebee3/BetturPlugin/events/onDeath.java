package ethebee3.BetturPlugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ethebee3.BetturPlugin.Main;
import org.bukkit.event.entity.PlayerDeathEvent;

import static ethebee3.BetturPlugin.commands.spawnUtils.SpawnCMD.spawnLocation;

public class onDeath implements Listener {
    private final Main plugin;
    public onDeath(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.getEntity().teleport(spawnLocation);
    }
}
