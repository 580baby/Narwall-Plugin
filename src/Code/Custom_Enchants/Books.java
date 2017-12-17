package Code.Custom_Enchants;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Code.Main;

public class Books implements CommandExecutor, Listener {
	private Main core;

	public Books(Main main) {
		this.core = main;
	}

	public void onInventoryClick(InventoryClickEvent event) {
		if (event.getWhoClicked() instanceof Player) {
			ItemStack sb = new ItemStack(Material.BOOK);
			ItemMeta meta = sb.getItemMeta();
			meta.setDisplayName(ChatColor.WHITE + "Simple Book!");
			sb.setItemMeta(meta);
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.DARK_GRAY + "Right click this book to open and see what you get! :)");
			sb.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Simple Book!");
			meta.setLore(lore);
			sb.setItemMeta(meta);
			Player player = (Player) event.getWhoClicked();
			ItemStack item = event.getCurrentItem();
			if (event.getInventory().getName().equals(ChatColor.DARK_PURPLE + "Get yur books here!")) {
				if (item.getType().equals(Material.BOOK)) {
					if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Simple Book!")) {
						int pp = core.getConfig().getInt("." + player.getName() + ".points");
						if (pp >= 50) {
							player.getInventory().addItem(sb);
							int hh = pp - 50;
							core.getConfig().set("." + player.getName() + ".points", hh);
							player.sendMessage(ChatColor.DARK_PURPLE + "You have recived one simple book!");
							event.setCancelled(true);
						} else {
							player.sendMessage(ChatColor.DARK_RED + "You do not have enough points!");
							event.setCancelled(true);
							player.closeInventory();
						}
					}
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("rb"))
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.rb")) {
					Player player = (Player) sender;
					player.closeInventory();
					Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Get yur books here!");
					ItemStack sb = new ItemStack(Material.BOOK);
					ItemMeta meta = sb.getItemMeta();
					meta.setDisplayName(ChatColor.WHITE + "Simple Book!");
					sb.setItemMeta(meta);
					ArrayList<String> lore = new ArrayList<String>();
					lore.add(ChatColor.DARK_GRAY + "Right click this book to open and see what you get! :)");
					sb.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Simple Book!");
					meta.setLore(lore);
					sb.setItemMeta(meta);
					inv.setItem(0, sb);
					player.openInventory(inv);
					return false;
				}
			}
		return false;
	}

}
