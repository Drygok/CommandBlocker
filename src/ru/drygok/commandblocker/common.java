package ru.drygok.commandblocker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class common {

    public static void say(Player player, String text) {
        if ((player == null) || (text == null)) return;
        player.sendMessage(translateColor(text));
    }
    public static String translateColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    
    public static String GET(String url) {
    	try {
	    	URL obj = new URL(url);
	    	HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
	
	    	connection.setRequestMethod("GET");
	
	    	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    	String inputLine;
	    	StringBuffer response = new StringBuffer();
	
	    	while ((inputLine = in.readLine()) != null) {
	    	    response.append(inputLine);
	    	}
	    	in.close();
	
	    	return response.toString();
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

}
