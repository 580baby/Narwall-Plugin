package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Code.Main;

public class Ultimate_pickaxe implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Ultimate_pickaxe(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ultpick"))
			if (sender.hasPermission("narwall.ultpick")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					ItemStack myItem = (new ItemStack(Material.BOW));
					myItem.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 30000);
					myItem.addUnsafeEnchantment(Enchantment.DURABILITY, 30000);
					myItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 30000);
					player.getInventory().addItem(myItem);
					player.sendMessage(org.bukkit.ChatColor.RED + "Ultimate pickaxe" + ChatColor.RED + "aqiured");
				}
			}
		return false;
	}
}
