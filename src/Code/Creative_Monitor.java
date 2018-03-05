package Code;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class Creative_Monitor implements Listener {
	public Creative_Monitor(Main main) {
	}

	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (p.getGameMode() == GameMode.CREATIVE) {
			if (!e.getCursor().getType().toString().contains("AIR")) {
				Bukkit.getConsoleSender()
						.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "" + "[Creative Monitor] " + ChatColor.RED
								+ p.getName() + ChatColor.LIGHT_PURPLE + " just put down " + ChatColor.BLUE + ""
								+ ChatColor.BOLD + e.getCursor() + ChatColor.RED + " in slot " + ChatColor.BLUE + ""
								+ ChatColor.BOLD + e.getSlot());
			} else {
				Bukkit.getConsoleSender()
						.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "" + "[Creative Monitor] " + ChatColor.RED
								+ p.getName() + ChatColor.GREEN + " just picked up " + ChatColor.BLUE + ""
								+ ChatColor.BOLD + e.getCurrentItem() + ChatColor.RED + " in slot " + ChatColor.BLUE
								+ "" + ChatColor.BOLD + e.getSlot());
			}
		}
	}

	@EventHandler
	public void InventoryClick1(EntityPickupItemEvent e) {
		Player p = (Player) e.getEntity();
		if (p.getGameMode() == GameMode.CREATIVE) {
			Bukkit.getConsoleSender()
					.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "" + "[Creative Monitor] " + ChatColor.RED
							+ p.getName() + ChatColor.AQUA + " just picked up from the ground " + ChatColor.BLUE + ""
							+ ChatColor.BOLD + e.getItem().getItemStack());
		}
	}

	@EventHandler
	public void blockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (p.getGameMode() == GameMode.CREATIVE) {
			ItemStack is = new ItemStack(e.getBlock().getType());
			Bukkit.getConsoleSender()
					.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "" + "[Creative Monitor] " + ChatColor.RED
							+ p.getName() + ChatColor.DARK_GREEN + " just placed " + ChatColor.BLUE + ""
							+ ChatColor.BOLD + is + ChatColor.DARK_GREEN + " at " + ChatColor.BLUE + "" + ChatColor.BOLD
							+ e.getBlock().getX() + " " + e.getBlock().getY() + " " + e.getBlock().getZ()
							+ ChatColor.DARK_GREEN + "  in world " + e.getBlock().getWorld().getName());
		}
	}
}
