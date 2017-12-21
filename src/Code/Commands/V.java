package Code.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;
import net.md_5.bungee.api.ChatColor;

public class V implements CommandExecutor {
	public static List<String> vOn = new ArrayList<String>();
	public static List<String> vIsOn = new ArrayList<String>();
	@SuppressWarnings("unused")
	private Main core;

	public V(Main main) {
		this.core = main;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (sender.hasPermission("narwall.v")) {
				if (cmd.getName().equalsIgnoreCase("v")) {
					if (args.length == 0) {
						if (vOn.contains(p.getName())) {
							p.sendMessage(vIsOn.toString());
							for (Player pl : Bukkit.getOnlinePlayers()) {
								for (String s : vIsOn) {
									Player player = Bukkit.getServer().getPlayer(s);
									pl.showPlayer(player);
								}
							}
							vOn.remove(p.getName());
							vIsOn.remove(p.getName());
						} else if (!vOn.contains(p.getName())) {
							vOn.add(p.getName());
							vIsOn.add(p.getName());
							for (Player pl : Bukkit.getOnlinePlayers()) {
								for (String s : vIsOn) {
									Player player = Bukkit.getServer().getPlayer(s);
									pl.hidePlayer(player);
								}
							}
							p.sendMessage(ChatColor.DARK_PURPLE + "You are now hidden from the " + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Average " + ChatColor.DARK_PURPLE + "player!");
						}

					}
				}
			}
		}
		return false;
	}
}
