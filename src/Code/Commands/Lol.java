package Code.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Code.Main;

public class Lol implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Lol(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("lol")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.lol")) {
					Player player = (Player) sender;
					ItemStack slimeball = new ItemStack(Material.SLIME_BALL);
					slimeball.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
					player.getInventory().addItem(slimeball);
					player.sendMessage(org.bukkit.ChatColor.BLUE + "You have aqired the " + org.bukkit.ChatColor.RED
							+ "lol item.");
				}
			}

		}

		return false;
	}
}
