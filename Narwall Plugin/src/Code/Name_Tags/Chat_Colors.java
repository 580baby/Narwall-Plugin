package com.babyyt.Name_Tags;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.babyyt.Main;

public class Chat_Colors implements Listener {

	public Chat_Colors(Main main) {
	}

	@EventHandler
	public void chatEvent(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String words;
		String name;
		name = p.getName();
		words = e.getMessage();
		e.setCancelled(true);
		Bukkit.getServer().broadcastMessage(name + " " + words);
	}
}
