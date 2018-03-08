package Code.Commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import Code.Main;

public class Fill implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Fill(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fill2")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (sender.hasPermission("narwall.fill")) {
					if (args.length == 2) {
						Location loc = p.getLocation();
						int x = loc.getBlockX() - Integer.parseInt(args[0]);
						int y = loc.getBlockY() - Integer.parseInt(args[0]);
						int z = loc.getBlockZ() - Integer.parseInt(args[0]);
						int xn = x + Integer.parseInt(args[0]) * 2;
						int yn = y + Integer.parseInt(args[0]) * 2;
						int zn = z + Integer.parseInt(args[0]) * 2;
						for (int xi = x; xi < xn; xi++) {
							for (int yi = y; yi < yn; yi++) {
								for (int zi = z; zi < zn; zi++) {
									System.out.println(xi);
									System.out.println(yi);
									System.out.println(zi);
									if (p.getWorld().getBlockAt(xi, yi, zi).getType() == Material.DISPENSER) {
										InventoryHolder dispenser = (InventoryHolder) p.getWorld().getBlockAt(xi, yi, zi)
												.getState();
										for(int i = 0; i <= Integer.parseInt(args[1]); i++) {
											dispenser.getInventory().addItem(new ItemStack(Material.TNT));
										}
									} else {
										continue;
									}
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
