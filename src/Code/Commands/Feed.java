package Code.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Feed implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Feed(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("feed")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					if (sender.hasPermission("narwall.feed")) {
						Player player = (Player) sender;
						player.setFoodLevel(20);
						player.setSaturation(100);
						player.sendMessage(ChatColor.BLUE + "Your hunger has been " + ChatColor.RED + "Crushed");
					}
					return true;

				}

			}
		}
		Player target = Bukkit.getServer().getPlayer(args[0]);
		if (target == null) {

			return true;
		}
		Player t = Bukkit.getServer().getPlayer(args[0]);
		t.setFoodLevel(20);
		t.setSaturation(100);
		t.sendMessage(ChatColor.BLUE + "Your hunger has been " + ChatColor.RED + "Crushed");
		return false;

	}
}
