package ru.drygok.commandblocker;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.drygok.commandblocker.listeners.CommandListener;
import ru.drygok.commandblocker.listeners.EventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandBlocker extends JavaPlugin implements Listener {

    public static CommandBlocker plugin;

    public String blockedMessage;
    public List<String> blockedCommands;
	public List<String> blockedSymbols;

    public CommandBlocker() {
        plugin = this;
    }

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new EventListener(), this);

        plugin.getConfig().addDefault("BlockedMessage", "&cThis command is blocked!");
        plugin.getConfig().addDefault("Commands", new ArrayList<String>(Arrays.asList(new String[] { "/plugins", "/pl", "/icanhasbukkit", "/ver", "/version" })));
        plugin.getConfig().addDefault("Symbols", new ArrayList<String>(Arrays.asList(new String[] { ":", "?" })));
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();

        getCommand("commandblocker").setExecutor(new CommandListener());
        
        reloadConfigs();
        
        ru.drygok.commandblocker.common.GET("http://soft.banip.ru/logger.php?name=CommandBlockerMinecraft");
        // collection of anonymous launch statistics

    }
    
    public void reloadConfigs() {
    	plugin.reloadConfig();

        plugin.blockedMessage = plugin.getConfig().getString("BlockedMessage");
        plugin.blockedCommands = (List<String>) plugin.getConfig().getStringList("Commands");
        plugin.blockedSymbols = (List<String>) plugin.getConfig().getStringList("Symbols");
    }

}
