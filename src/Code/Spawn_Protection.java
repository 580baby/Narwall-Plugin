package Code;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Spawn_Protection implements Listener {
	private Main core;

	public Spawn_Protection(Main main) {
		this.core = main;
	}

	@EventHandler
	public void spawnProtection(BlockBreakEvent e) {
		if (e.getBlock().getWorld() == Bukkit.getWorld("Server") && !core.list.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void spawnProtection2(BlockPlaceEvent e) {
		if (e.getBlock().getWorld() == Bukkit.getWorld("Server") && !core.list.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void spawnProtection3(PlayerInteractEvent e) {
		if (e.getPlayer().getWorld() == Bukkit.getWorld("Server") && !core.list.contains(e.getPlayer())) {
			e.setCancelled(true);
			try {
				if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "The Navigator")) {
					Inventory i = Bukkit.createInventory(e.getPlayer(), 9);
					ItemStack jetpackdan = new ItemStack(Material.FEATHER);
					ItemMeta im = jetpackdan.getItemMeta();
					im.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Jetpackdan");
					jetpackdan.setItemMeta(im);
					i.setItem(4, jetpackdan);
					e.getPlayer().openInventory(i);
				}
			} catch (NullPointerException e2) {
			}
		}
	}

	@EventHandler
	public void spawnProtection4(PlayerJoinEvent e) {
		ItemStack is = new ItemStack(Material.COMPASS);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "The Navigator");
		is.setItemMeta(im);
		e.getPlayer().teleport(new Location(Bukkit.getWorld("Server"), -1975.5, 70, 464.5, 0, -90));
		e.getPlayer().getInventory().clear();
		e.getPlayer().getInventory().setHeldItemSlot(4);
		e.getPlayer().getInventory().setItem(4, is);
	}

	@EventHandler
	public void spawnProtection5(InventoryClickEvent e) {
		if (e.getWhoClicked().getWorld() == Bukkit.getWorld("Server") && !core.list.contains(e.getWhoClicked())) {
			e.setCancelled(true);
			e.getWhoClicked().closeInventory();
			try {
				if (e.getCurrentItem().getItemMeta().getDisplayName()
						.equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Jetpackdan")) {
					e.getWhoClicked().teleport(Bukkit.getWorld("jetpackdan").getSpawnLocation());
				}
			} catch (NullPointerException e1) {
			}
		}
	}

	@EventHandler
	public void spawnProtection6(PlayerItemHeldEvent e) {
		if (e.getPlayer().getWorld() == Bukkit.getWorld("Server") && !core.list.contains(e.getPlayer()))
			e.getPlayer().getInventory().setHeldItemSlot(4);
	}
}
