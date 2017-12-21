package Code.Commands;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;
import Code.Generic_Classes.Get_ChatColor;
import Code.Generic_Classes.Get_Rank;
import Code.Generic_Classes.Get_Tag;
import net.md_5.bungee.api.ChatColor;

public class Name implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Name(Main main) {
		this.core = main;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender instanceof Player) {
			if (sender.hasPermission("narwall.name")) {
				String name = args[0];
				Player player = ((Player) sender).getPlayer();
				String rank = Get_Rank.getRank(player);
				String tag = Get_Tag.getTag(player);
				if (cmd.getName().equalsIgnoreCase("name")) {
					if (1 <= args[0].length() && args[0].length() <= 16) {
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
							ff.set(profile, Get_ChatColor.getChatColor(player) + name);
							name = player.getName();
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

					} else {
						player.sendMessage(
								ChatColor.DARK_RED + "Your name: " + name + ChatColor.DARK_RED + "was too long!");
						player.sendMessage(ChatColor.DARK_RED + "So it was not set above your head!");
					}
				}
				player.setPlayerListName(rank + tag + " " + name);
				player.setDisplayName(rank + tag + " " + name);
				player.setCustomName(rank + tag + " " + name);
			} else if (args.length < 1) {
				((Player) sender).getPlayer().sendMessage(ChatColor.DARK_RED + "Too little args!");
			}
		}

		return false;
	}
}
