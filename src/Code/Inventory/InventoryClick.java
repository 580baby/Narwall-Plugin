package Code.Inventory;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Code.Main;

public class InventoryClick implements Listener {
	@SuppressWarnings("unused")
	private Main core;

	public InventoryClick(Main main) {

	}

	@EventHandler
	public void onInvetoryClick(InventoryClickEvent event) {
		if (event.getWhoClicked().hasPermission("narwall.menu")) {
			Inventory inv = event.getInventory();
			if (inv.getTitle().equals(ChatColor.DARK_PURPLE + "Teleport Selector")) {
				Player player = (Player) event.getWhoClicked();
				ItemStack item = event.getCurrentItem();

				if (item.getType() == Material.COMPASS) {
					player.teleport(player.getWorld().getSpawnLocation());
					player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been teleported to spawn!");
					player.getWorld().playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 1);
				} else {
					if (item.getType() == Material.LAPIS_BLOCK) {
						player.sendMessage(
								ChatColor.BLUE + "You have been teleported to the Blue side of the Arena! Good Luck!");
						player.teleport(new Location(player.getWorld(), 1189.5, 212, 1045.5));
						player.getWorld().playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 1);
					} else {

					}
					if (item.getType() == Material.REDSTONE_BLOCK) {
						player.sendMessage(
								ChatColor.RED + "You have been teleported to the Red side of the Arena! Good Luck!");
						player.teleport(new Location(player.getWorld(), 1199.5, 212, 1045.5));
						player.getWorld().playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 1);
					} else {

					}
					if (item.getType() == Material.HARD_CLAY) {
						player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been teleported outside of spawn!");
						player.teleport(new Location(player.getWorld(), 1127.5, 92, 796.5));
						player.getWorld().playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 1);
					} else {

					}
					if (item.getType() == Material.EMERALD_BLOCK) {
						player.sendMessage(ChatColor.DARK_GREEN + "You are now a spectator of the Arena!");
						player.teleport(new Location(player.getWorld(), 1194.5, 212, 1045.5));
						player.setGameMode(GameMode.SPECTATOR);
						player.getWorld().playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 1);
					} else {

					}
				}

				event.setCancelled(true);
				player.closeInventory();
			}
		}
	}
}
