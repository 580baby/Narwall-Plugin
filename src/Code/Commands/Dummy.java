package Code.Commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import Code.Main;
import net.md_5.bungee.api.ChatColor;

public class Dummy implements CommandExecutor {
	private Main core;

	public Dummy(Main main) {
		this.core = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("dummy")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (sender.hasPermission("narwall.dummy")) {
					if (args.length >= 1) {
						 if (args[0].equalsIgnoreCase("spec-item")) {
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
						} else if (args[0].equalsIgnoreCase("test")) {
							Map<String, Object> one = p.getInventory().getItem(0).serialize();
							Map<String, Object> two = p.getInventory().getItem(1).serialize();
							Map<String, Object> three = p.getInventory().getItem(2).serialize();
							Map<String, Object> four = p.getInventory().getItem(3).serialize();
							ArrayList<Map<String, Object>> l = new ArrayList<Map<String, Object>>();
							l.add(one);
							l.add(two);
							l.add(three);
							l.add(four);	
							FileOutputStream fos;
							try {
								fos = new FileOutputStream(core.getDataFolder() + "text.txt");
								BukkitObjectOutputStream boos = new BukkitObjectOutputStream(fos);
								boos.writeObject(l);
								boos.close();
								FileInputStream fis = new FileInputStream(core.getDataFolder() + "text.txt");
								BukkitObjectInputStream bois = new BukkitObjectInputStream(fis);
								@SuppressWarnings("unchecked")
								ArrayList<Map<String, Object>> o = (ArrayList<Map<String, Object>>) bois.readObject();
								bois.close();
								p.getInventory().addItem(ItemStack.deserialize(o.get(0)));
								p.getInventory().addItem(ItemStack.deserialize(o.get(1)));
								p.getInventory().addItem(ItemStack.deserialize(o.get(2)));
								p.getInventory().addItem(ItemStack.deserialize(o.get(3)));
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
							
							
						} else {
							p.sendMessage(ChatColor.DARK_RED + "Unknown Argument!");
						}
					}
				} else {
					p.sendMessage(ChatColor.DARK_RED + "Wrong amout of arguments!");
				}
			}
		}
		return false;
	}

}