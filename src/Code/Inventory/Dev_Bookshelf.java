package Code.Inventory;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Code.Main;

public class Dev_Bookshelf implements Listener {

	private Main core;
	public HashMap<String, Inventory> dev_books = new HashMap<String, Inventory>();
	public static Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Dev Library's" + ChatColor.BOLD);

	public Dev_Bookshelf(Main main) {
		this.core = main;
	}

	@SuppressWarnings("unchecked")
	@EventHandler
	public void rightClickEvent(PlayerInteractEvent event) {
		try {
			if (core.getConfig().getList("dev_books") != null) {
				ItemStack[] contents8 = null;
				Object l8 = core.getConfig().getList("dev_books");
				if (l8 instanceof ItemStack[]) {
					contents8 = (ItemStack[]) l8;
				} else if (l8 instanceof List) {
					contents8 = (ItemStack[]) ((List<ItemStack>) l8).toArray(new ItemStack[0]);
				}

				if (contents8 != null) {
					inv.setContents(contents8);
				} else {
					Bukkit.getServer().getLogger()
							.info(ChatColor.RED + "The dev librarys are empty! Creating them now.");
				}
				dev_books.put("dev_books", inv);
			}
		} catch (NullPointerException e) {
			dev_books.put("dev_books",
					Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Dev Library's" + ChatColor.BOLD));
			Bukkit.getServer().getLogger()
					.info("You have not used this feature yet so we are creating the Inventory empty!");
		}
		Player p = event.getPlayer();
		World w = Bukkit.getWorld("Dev");
		if (event.getPlayer().hasPermission("narwall.dev")) {
			if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (p.getWorld().equals(w)) {
					if (event.getClickedBlock().getType() == Material.BOOKSHELF) {
						p.openInventory(inv);
					}
				}
			}
		}
	}

	@EventHandler
	public void inventoryCloseEvent(InventoryCloseEvent e) {
		if (e.getInventory().getName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Dev Library's" + ChatColor.BOLD)) {
			try {
				if (!core.getConfig().contains("dev_books")) {
					core.getConfig().createSection("dev_books");
				}
			} catch (NullPointerException e1) {
				core.getConfig().set("dev_books", null);
			}
			ItemStack[] is = dev_books.get("dev_books").getContents();
			core.getConfig().set("dev_books", is);
		}
	}

}