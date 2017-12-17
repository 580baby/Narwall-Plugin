package Code.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Code.Main;

public class GetPoints implements CommandExecutor {
	private Main core;

	public GetPoints(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("getpoints")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					if (sender.hasPermission("narwall.getpoints")) {
						Player player = (Player) sender;
						ItemStack[] inv = player.getInventory().getContents();
						for (int i = 0; i < inv.length; i++) {
							if (inv[i] != null) {
								if (inv[i].getType().equals(Material.ROTTEN_FLESH)) {
									int o = inv[i].getAmount();
									player.getInventory().remove(Material.ROTTEN_FLESH);
									int y = (Integer) core.getConfig().getInt("." + player.getName() + ".points");
									String s = Integer.toString(y);
									player.sendMessage(s);
									int p = y + o;
									String h = Integer.toString(p);
									player.sendMessage(h);
									core.getConfig().set("." + player.getName() + ".points", p);
									core.saveConfig();
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
