package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Damage implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Damage(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("damage")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.damage")) {
					Player player = (Player) sender;
					player.damage(10);
					player.sendMessage(org.bukkit.ChatColor.BLUE + "You have been" + ChatColor.RED + " damaged.");
				}
				return true;

			}

		}

		return false;
	}
}
