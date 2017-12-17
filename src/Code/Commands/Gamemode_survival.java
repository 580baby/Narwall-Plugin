package Code.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Gamemode_survival implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Gamemode_survival(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gs")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.gs")) {
					Player player = (Player) sender;
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(
							org.bukkit.ChatColor.BLUE + "Gamemode set to " + org.bukkit.ChatColor.RED + "Survival");
				}
			}
		}

		return false;
	}
}
