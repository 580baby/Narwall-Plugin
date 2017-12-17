package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Fast_walking implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Fast_walking(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fastwalking")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.fastwalking")) {
					((Player) sender).setWalkSpeed(1);
					sender.sendMessage(ChatColor.BLUE + "Walking speed set to " + ChatColor.RED + "Fast");
				}
			}
		}
		return true;
	}
}
