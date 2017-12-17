package Code.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Reset_fly_speed implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Reset_fly_speed(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("resetflyspeed")) {
			if (sender.hasPermission("narwall.fastfly")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					player.setFlySpeed(0.2f);
					player.sendMessage(org.bukkit.ChatColor.BLUE + "Fly speed " + org.bukkit.ChatColor.RED + "Reset");
				}
			}
		}
		return false;
	}
}
