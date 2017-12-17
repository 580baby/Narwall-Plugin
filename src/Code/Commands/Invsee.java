package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import Code.Main;

public class Invsee implements CommandExecutor {
	private Main core;

	public Invsee(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {

		if (cmd.getName().equalsIgnoreCase("invsee")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;

				if (player.hasPermission("narwall.invsee")) {
					if (args.length == 1) {
						Player t = core.getServer().getPlayer(args[0]);
						Inventory h = t.getInventory();
						player.openInventory(h);
					}

				} else {
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission!");
				}

			}

		}
		return false;
	}
}