package ru.drygok.commandblocker.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import ru.drygok.commandblocker.CommandBlocker;
import ru.drygok.commandblocker.Permissions;

import static ru.drygok.commandblocker.common.say;

public class EventListener implements Listener {

    private static CommandBlocker plugin = CommandBlocker.plugin;

    @EventHandler (priority =  EventPriority.HIGHEST)
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {

        String[] args = event.getMessage().split(" ");
        Player player = event.getPlayer();

        if (!player.hasPermission(Permissions.BYPASS_COMMAND.getPermission())) {
        	for (String command : plugin.blockedCommands) {
        		if (command.equalsIgnoreCase(args[0])) {
        			say(player, plugin.blockedMessage);
                    event.setCancelled(true);
                    return;
        		}
        	}
        }

        if (!player.hasPermission(Permissions.BYPASS_SYMBOLS.getPermission())) {
            for (String symbol : plugin.blockedSymbols) {
                if (args[0].contains(symbol)) {
                    say(player, plugin.blockedMessage);
                    event.setCancelled(true);
                    return;
                }
            }
        }

    }

}
