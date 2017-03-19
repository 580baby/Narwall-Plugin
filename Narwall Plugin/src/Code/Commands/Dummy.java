package com.babyyt.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.babyyt.Main;
import com.babyyt.Save_Inventory;

import net.md_5.bungee.api.ChatColor;

public class Dummy implements CommandExecutor {
	public Dummy(Main main) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("dummy")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (sender.hasPermission("narwall.dummy")) {
					if (args.length >= 1) {
						if (args[0].equalsIgnoreCase("save-inv")) {
							Save_Inventory.saveInventory(p, p.getWorld());
							p.sendMessage(ChatColor.DARK_BLUE + "Inventory Saved!");
						} else if (args[0].equalsIgnoreCase("spec-item")) {
							if (args[1].equalsIgnoreCase("sweep-sword")) {
								ItemStack item = new ItemStack(Material.GOLD_SWORD);
									ItemMeta im = item.getItemMeta();
									im.addEnchant(Enchantment.SWEEPING_EDGE, 10, true);
									im.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
									im.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
									item.setItemMeta(im);
									p.getInventory().addItem(item);
							} else {
								p.sendMessage(ChatColor.DARK_RED + "Unknown Item!");
							}
						} else {
							p.sendMessage(ChatColor.DARK_RED + "Unknown Argument!");
						}
					} else {
						p.sendMessage(ChatColor.DARK_RED + "Wrong amout of arguments!");
					}
				}
			}
		}
		return false;
	}

}