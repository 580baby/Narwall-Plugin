package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import Code.Main;

public class PSA implements CommandExecutor {
	private Main core;

	public PSA(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("psa")) {
			if (sender.hasPermission("narwall.psa")) {
				if (args.length >= 1) {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < args.length; i++) {
						sb.append(args[i]).append(" ");
					}
					String allArgs = sb.toString().trim();
					String h = allArgs.toUpperCase();
					core.getServer().broadcastMessage("");
					core.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "PUBLIC SERVICE ANNOUNCEMENT: " + h);
					core.getServer().broadcastMessage("");

				}
			} else {
				sender.sendMessage(ChatColor.DARK_RED + "Please specify a message!");
			}
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to do that " +
					ChatColor.BOLD + "command!");
		}
		return false;
	}
}
