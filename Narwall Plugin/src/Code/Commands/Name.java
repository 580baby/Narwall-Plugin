package com.babyyt.commands;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.babyyt.Main;

import Generic_Classes.Get_Tag;
import net.md_5.bungee.api.ChatColor;

public class Name implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Name(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender instanceof Player) {
			if (sender.hasPermission("narwall.name")) {
				String name = args[0];
				Player player = ((Player) sender).getPlayer();
				if (cmd.getName().equalsIgnoreCase("name")) {
					if (args.length >= 1 && args.length <= 16) {
						try {
							Method getHandle = player.getClass().getMethod("getHandle", (Class<?>[]) null);
							try {
								Class.forName("com.mojang.authlib.GameProfile");
							} catch (ClassNotFoundException e) {
							}
							Object profile = getHandle.invoke(player).getClass().getMethod("getProfile")
									.invoke(getHandle.invoke(player));
							Field ff = profile.getClass().getDeclaredField("name");
							ff.setAccessible(true);
							ff.set(profile, ChatColor.translateAlternateColorCodes('&', name));
							
							name = Get_Tag.getName(player);
							try {
								Class.forName("com.mojang.authlib.GameProfile");
							} catch (ClassNotFoundException e) {
							}
							ff.setAccessible(true);
							ff.set(profile, name);
							
							for (Player players : Bukkit.getOnlinePlayers()) {
								players.hidePlayer(player);
								players.showPlayer(player);
							}
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException
								| IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
							e.printStackTrace();
						}

					}
				}
				player.setPlayerListName(name);
				player.setDisplayName(name);
				player.setCustomName(name);
				player.setCustomNameVisible(true);
			} else if (args.length < 1) {
				((Player) sender).getPlayer().sendMessage(ChatColor.DARK_RED + "Too little args!");
			}
		}

		return false;
	}
}
