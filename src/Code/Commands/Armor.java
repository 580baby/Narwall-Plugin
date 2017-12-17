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

public class Armor implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Armor(Main main) {
		this.core = main;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("armor"))
			if (sender instanceof Player){
				if(sender.hasPermission("narwall.armor")){
				Player player = (Player) sender;
				ItemStack Boots = (new ItemStack(313));
				ItemStack Chestplate = (new ItemStack(Material.DIAMOND_CHESTPLATE));
				ItemStack Helmet = (new ItemStack(Material.DIAMOND_HELMET));
				ItemStack Leggings = (new ItemStack(Material.DIAMOND_LEGGINGS));
				Boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 255);
				Boots.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 255);
				Boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 255);
				Boots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 255);
				Boots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 255);
				Helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 255);
				Helmet.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 255);
				Helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 255);
				Helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 255);
				Helmet.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 255);
				Chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 255);
				Chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 255);
				Chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 255);
				Chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 255);
				Chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 255);
				Leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 255);
				Leggings.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 255);
				Leggings.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 255);
				Leggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 255);
				Leggings.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 255);
				Leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 255);
				Chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 255);
				Helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 255);
				Boots.addUnsafeEnchantment(Enchantment.DURABILITY, 255);
				player.getEquipment().setBoots(Boots);
				player.getEquipment().setLeggings(Leggings);
				player.getEquipment().setHelmet(Helmet);
				player.getEquipment().setChestplate(Chestplate);
				player.sendMessage(ChatColor.BLUE + "You now have " + ChatColor.RED + "OP Armor!");
				}
			}
		return false;
	}
}
