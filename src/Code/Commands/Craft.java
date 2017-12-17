package Code.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Craft implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Craft(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("craft")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.craft")) {
					Player player = (Player) sender;
					player.openWorkbench(null, true);
					player.sendMessage(org.bukkit.ChatColor.RED + "Workbench" + org.bukkit.ChatColor.BLUE + " opened");
				}

			}

		}

		return false;
	}
}
