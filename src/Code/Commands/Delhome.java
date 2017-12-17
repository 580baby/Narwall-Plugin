package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Delhome implements CommandExecutor {
	private Main core;

	public Delhome(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		Player player = (Player) sender;
		int locx = core.getConfig().getInt("." + player.getName() + args[0] + ".x");
		if (args.length == 0) {
			player.sendMessage(ChatColor.DARK_RED + "Please specify a name!");
		}
		if (args.length == 1)

		{

			if (cmd.getName().equalsIgnoreCase("delhome")) {
				if (sender instanceof Player) {
					if (sender.hasPermission("narwall.home")) {
						if (locx != 0) {
							core.getConfig().set("." + player.getName() + args[0] + ".lol", null);
							core.getConfig().set("." + player.getName() + args[0] + ".x", null);
							core.getConfig().set("." + player.getName() + args[0] + ".y", null);
							core.getConfig().set("." + player.getName() + args[0] + ".z", null);
							core.getConfig().set("." + player.getName() + args[0] + ".world", null);
							core.saveConfig();
							player.sendMessage(ChatColor.DARK_BLUE + "Home successfully deleted");

						} else {
							player.sendMessage(ChatColor.DARK_RED + "That is not a valid home!");
						}
					}
				}
			}
		}
		return false;
	}
}