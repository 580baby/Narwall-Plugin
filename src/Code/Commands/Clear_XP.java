package Code.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Clear_XP implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Clear_XP(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("cxp")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.cxp")) {
					Player player = (Player) sender;
					player.setExp(0);
					player.setTotalExperience(0);
					player.giveExpLevels(-Integer.MAX_VALUE);
				}
			}
		}
		return false;
	}
}
