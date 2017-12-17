package Code.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Heal implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Heal(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (args.length == 0) {

			if (cmd.getName().equalsIgnoreCase("heal")) {
				if (sender instanceof Player) {
					if (sender.hasPermission("narwall.heal")) {
						if (args.length == 0) {
							Player player = (Player) sender;
							player.setHealth(20);
							player.sendMessage(org.bukkit.ChatColor.DARK_BLUE + "You have been " + org.bukkit.ChatColor.RED
									+ "Healed.");
						} else if (args.length == 1) {
							Player player = (Player) sender;
							Player t = Bukkit.getServer().getPlayer(args[0]);
							if (t == null) {
								player.sendMessage(ChatColor.DARK_RED + "Please specify a player ");
								return true;
							}
							t.setHealth(20);
							t.sendMessage(org.bukkit.ChatColor.DARK_BLUE + "You have been " + org.bukkit.ChatColor.RED
									+ "Healed.");
						}
					}
				}
			}
		}
		return false;
	}
}
