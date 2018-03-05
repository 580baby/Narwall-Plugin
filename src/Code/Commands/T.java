package Code.Commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;
import net.md_5.bungee.api.ChatColor;

public class T implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public T(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("t")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (sender.hasPermission("narwall.t")) {
					if (args.length == 1) {
						int maxx = p.getLocation().getBlockX() + Integer.parseInt(args[0]);
						int minx = p.getLocation().getBlockX() - Integer.parseInt(args[0]);
						int maxy = p.getLocation().getBlockY() + Integer.parseInt(args[0]);
						int miny = p.getLocation().getBlockY() - Integer.parseInt(args[0]);
						int maxz = p.getLocation().getBlockZ() + Integer.parseInt(args[0]);
						int minz = p.getLocation().getBlockZ() - Integer.parseInt(args[0]);
						for (int i = minx; i <= maxx && i >= minx; i++) {
							for (int ii = miny; ii <= maxy && ii >= miny; ii++) {
								for (int iii = minz; iii <= maxz && iii >= minz; iii++) {
									Location l = new Location(p.getWorld(), i, ii, iii);
									Block b = l.getBlock();
									if (b.getType().equals(Material.COAL_ORE) || b.getType().equals(Material.GRAVEL)
											|| b.getType().equals(Material.YELLOW_FLOWER)
											|| b.getType().equals(Material.RED_ROSE)) {
										b.breakNaturally();
									}
								}
							}
						}
						p.sendMessage(ChatColor.GOLD + "Done!");
					}
				}
			}
		}
		return false;
	}
}
