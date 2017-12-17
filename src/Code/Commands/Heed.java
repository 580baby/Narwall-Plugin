package Code.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Heed implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Heed(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("heed")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.heed")) {
					Player player = (Player) sender;
					player.setHealth(20);
					player.setFoodLevel(20);
					player.setSaturation(20);
					player.sendMessage(org.bukkit.ChatColor.BLUE + "You have been " + org.bukkit.ChatColor.RED
							+ "Healed" + org.bukkit.ChatColor.BLUE + " And " + org.bukkit.ChatColor.RED + "Fed.");
				}
			}
		}
		return false;
	}
}
