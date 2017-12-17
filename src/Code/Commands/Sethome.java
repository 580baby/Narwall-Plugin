package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Sethome implements CommandExecutor {
	private Main core;

	public Sethome(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		Player player = (Player) sender;
		if (sender.hasPermission("narwall.home")) {
			if (args.length == 0) {
				player.sendMessage(ChatColor.DARK_RED + "Plese specify a name!");
			}
			if (args.length == 1) {

				if (cmd.getName().equalsIgnoreCase("sethome")) {
					if (sender instanceof Player) {
						int x = player.getLocation().getBlockX();
						int y = player.getLocation().getBlockY();
						int z = player.getLocation().getBlockZ();
						String w = player.getWorld().getName();
						core.getConfig().set("." + player.getName() + args[0] + ".lol", args[0]);
						core.getConfig().set("." + player.getName() + args[0] + ".x", x);
						core.getConfig().set("." + player.getName() + args[0] + ".y", y);
						core.getConfig().set("." + player.getName() + args[0] + ".z", z);
						core.getConfig().set("." + player.getName() + args[0] + ".w", w);
						core.saveConfig();
						player.sendMessage(ChatColor.DARK_BLUE + "Home successfully set!");

					}
				}

			}
		}
		return false;
	}
}
