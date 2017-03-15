package com.babyyt.Name_Tags;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.babyyt.Main;

import Generic_Classes.Get_Tag;
import net.md_5.bungee.api.ChatColor;

public class Tags implements Listener {

	public Tags(Main main) {
	}

	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String name;
		name = p.getName();
		try {
			Method getHandle = p.getClass().getMethod("getHandle", (Class<?>[]) null);
			try {
				Class.forName("com.mojang.authlib.GameProfile");
			} catch (ClassNotFoundException e1) {
			}
			Object profile = getHandle.invoke(p).getClass().getMethod("getProfile")
					.invoke(getHandle.invoke(p));
			Field ff = profile.getClass().getDeclaredField("name");
			ff.setAccessible(true);
			ff.set(profile, ChatColor.translateAlternateColorCodes('&', name));
			
			name = Get_Tag.getName(p);
			name = StringUtils.abbreviate(name, 16);
			try {
				Class.forName("com.mojang.authlib.GameProfile");
			} catch (ClassNotFoundException e1) {
			}
			ff.setAccessible(true);
			ff.set(profile, name);
			
			for (Player players : Bukkit.getOnlinePlayers()) {
				players.hidePlayer(p);
				players.showPlayer(p);
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchFieldException e1) {
			e1.printStackTrace();
		}
	}

}
