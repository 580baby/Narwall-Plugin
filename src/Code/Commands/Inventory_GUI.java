package Code.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Code.Main;

public class Inventory_GUI implements CommandExecutor, Listener {
	@SuppressWarnings("unused")
	private Main core;

	public Inventory_GUI(Main main) {
		this.core = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("menu")) {
			if (sender.hasPermission("narwall.menu")) {
				if (!(sender instanceof Player)) {
					sender.sendMessage(ChatColor.DARK_PURPLE + "You are not a Player");
					return false;
				}

				Player player = (Player) sender;
				Inventory inv = Bukkit.createInventory(null, 45, ChatColor.DARK_PURPLE + "Teleport Selector");

				ItemStack spawnItem = nameItem(Material.COMPASS, ChatColor.LIGHT_PURPLE + "Teleport to Spawn!");
				inv.setItem(22, spawnItem);
				ItemStack Arena_Blue_Side = nameItem(Material.LAPIS_BLOCK,
						ChatColor.BLUE + "Teleport to Blue side of Arena!");
				inv.setItem(19, Arena_Blue_Side);
				ItemStack Arena_Red_Side = nameItem(Material.REDSTONE_BLOCK,
						ChatColor.RED + "Teleport to Red side of Arena!");
				inv.setItem(25, Arena_Red_Side);
				ItemStack Arena_Spectator = nameItem(Material.EMERALD_BLOCK,
						ChatColor.DARK_GREEN + "Spectate the Arena!");
				inv.setItem(4, Arena_Spectator);
				ItemStack Out_of_spawn = nameItem(Material.HARD_CLAY,
						ChatColor.LIGHT_PURPLE + "Teleport out of spawn!");
				inv.setItem(40, Out_of_spawn);
				player.openInventory(inv);
			}
		}
		return false;
	}

	private ItemStack nameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}

	private ItemStack nameItem(Material item, String name) {
		return nameItem(new ItemStack(item), name);
	}
}
