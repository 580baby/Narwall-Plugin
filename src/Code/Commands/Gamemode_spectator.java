package Code.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Gamemode_spectator implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Gamemode_spectator(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gsp")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.gsp")) {
					Player player = (Player) sender;
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(
							org.bukkit.ChatColor.BLUE + "Gamemode set to " + org.bukkit.ChatColor.RED + "Spectator");
				}
			}
		}

		return false;
	}

}
