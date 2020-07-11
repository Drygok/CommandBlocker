package ru.drygok.commandblocker.listeners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.drygok.commandblocker.CommandBlocker;
import ru.drygok.commandblocker.Permissions;

import static ru.drygok.commandblocker.common.translateColor;

public class CommandListener implements CommandExecutor {

    private static CommandBlocker plugin = CommandBlocker.plugin;

	@Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if ((args.length == 1) && (args[0].equalsIgnoreCase("reload")) && (commandSender.hasPermission(Permissions.COMMAND_RELOAD.getPermission())))  {
            
        	plugin.reloadConfigs();
        	
            commandSender.sendMessage("Config reloaded!");
            return true;
        }

        commandSender.sendMessage(translateColor("&7[&aCommand&cBlocker&7] &eVersion: &b1.0.0 &7(11.07.2020)"));
        commandSender.sendMessage(translateColor("&7[&aCommand&cBlocker&7] &eAuthor: &bDrygok &7// &dvk.com/Drygok &7// &dDrygok.ru &7// &dяМаксим.рф"));
        if (commandSender.hasPermission(Permissions.COMMAND_RELOAD.getPermission())) {
        	commandSender.sendMessage(translateColor("&7[&aCommand&cBlocker&7] &eTo reload the list, use: &f/commandblocker reload"));
        }
        
        return true;
    }
}
