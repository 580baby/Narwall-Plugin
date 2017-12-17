package Code.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import Code.Main;

public class Nuke implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Nuke(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("nuke")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.nuke")) {
					Player player = (Player) sender;
					for(int i = 0; i < 100; i++){
						player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
					}
					player.sendMessage(org.bukkit.ChatColor.DARK_RED + "KABOOM!!!");
				}
			}
		}

		return false;
	}
}
