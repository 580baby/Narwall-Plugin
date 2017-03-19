package com.babyyt.Name_Tags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.babyyt.Main;

import Generic_Classes.Get_Tag;

public class Goodbye_Message implements Listener {
	private Main core;

	public Goodbye_Message(Main main) {
		this.core = main;
	}

	@EventHandler
	public void goodbyeEvent(PlayerQuitEvent e) {
		String name;
		Player p = e.getPlayer();
		name = Get_Tag.getName(p);
		e.setQuitMessage(null);
		String goodbyeMessage = ChatColor.translateAlternateColorCodes('&',
				core.getConfig().getString("Goodbye Message"));
		String goodbyeMessage2 = ChatColor.translateAlternateColorCodes('&',
				core.getConfig().getString("Goodbye Message2"));
		core.getServer().broadcastMessage("");
		core.getServer().broadcastMessage(ChatColor.DARK_PURPLE + goodbyeMessage + " " + name + " " + goodbyeMessage2);
		core.getServer().broadcastMessage("");
	}
}
