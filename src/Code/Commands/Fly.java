package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Fly implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Fly(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fly")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.fly")) {
					Player player = (Player) sender;
					player.setAllowFlight(true);
					player.setFlying(true);
					player.sendMessage(org.bukkit.ChatColor.BLUE + "Fly mode" + org.bukkit.ChatColor.RED + " Enabled");

				} else {
					sender.sendMessage(ChatColor.DARK_RED + "You do not have the permissions!");
				}

			}

		}
		return false;
	}
}