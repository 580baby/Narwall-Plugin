package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Reset_walk_speed implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Reset_walk_speed(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("resetwalkspeed")) {
			if (sender.hasPermission("narwall.fastwalking")) {
				if (sender instanceof Player) {
					((Player) sender).setWalkSpeed(0.2f);
					sender.sendMessage(ChatColor.BLUE + "Walking speed " + ChatColor.RED + "Reset");
				}
			}
		}
		return true;
	}
}