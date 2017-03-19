package com.babyyt.Name_Tags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.babyyt.Main;

import Generic_Classes.Get_Tag;

public class Hello_Message implements Listener {
	private Main core;

	public Hello_Message(Main main) {
		this.core = main;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		String name;
		Player p = e.getPlayer();
		name = Get_Tag.getName(p);
		String welcomeMessage = ChatColor.translateAlternateColorCodes('&',
				core.getConfig().getString("Welcome Message"));
		String welcomeMessage2 = ChatColor.translateAlternateColorCodes('&',
				core.getConfig().getString("Welcome Message2"));
		e.setJoinMessage(null);
		core.getServer().broadcastMessage("");
		core.getServer().broadcastMessage(welcomeMessage + " " + name + " " + welcomeMessage2);
		core.getServer().broadcastMessage("");

	}
}
