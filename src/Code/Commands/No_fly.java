package Code.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class No_fly implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public No_fly(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("nofly")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.fly")) {
					Player player = (Player) sender;
					player.setAllowFlight(false);
					player.setFlying(false);
					player.setFlySpeed(0.25f);
					player.sendMessage(org.bukkit.ChatColor.BLUE + "Fly mode" + org.bukkit.ChatColor.RED + " Disabled");
				}
			}
		}
		return false;
	}
}
