package Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Save_Inventory {
	private static Main core;

	public Save_Inventory(Main main) {
		Save_Inventory.core = main;
	}

	public static void saveInventory(Player p, World w) {
		HashMap<UUID, Inventory> as = new HashMap<UUID, Inventory>();
		Inventory inv = Bukkit.getServer().createInventory(p, 36, "inv");
		
		try{
			if (core.getConfig().contains("inventory" + p.getUniqueId() + w.getName()) == false) {
				core.getConfig().createSection("inventory" + p.getUniqueId() + w.getName());
			}
			} catch(NullPointerException npe){
				core.getConfig().createSection(".inventory" + "." + p.getUniqueId().toString() + "." + w.getName().toString());
			}
		List<ItemStack> l = new ArrayList<ItemStack>();
		for (ItemStack i : p.getInventory()) {
			l.add(i);
		}
		ItemStack[] a = (ItemStack[]) ((List<ItemStack>) l).toArray(new ItemStack[0]);
		inv.setContents(a);
		as.put(p.getUniqueId(), inv);
		core.getConfig().set("inventory" + p.getUniqueId() + w.getName(), inv.getContents());

		HashMap<UUID, Inventory> af = new HashMap<UUID, Inventory>();
		Inventory special = Bukkit.getServer().createInventory(p, 9, "special");
		try{
		if (core.getConfig().contains("special" + p.getUniqueId() + w.getName()) == false) {
			core.getConfig().createSection("special" + p.getUniqueId() + w.getName());
		}
		} catch(NullPointerException npe){
			core.getConfig().createSection("special" + p.getUniqueId() + w.getName());
		}
		List<ItemStack> lspecial = new ArrayList<ItemStack>();
		lspecial.add(p.getInventory().getBoots());
		lspecial.add(p.getInventory().getLeggings());
		lspecial.add(p.getInventory().getChestplate());
		lspecial.add(p.getInventory().getHelmet());
		lspecial.add(p.getInventory().getItemInOffHand());

		ItemStack[] aspecial = (ItemStack[]) ((List<ItemStack>) lspecial).toArray(new ItemStack[0]);
		special.setContents(aspecial);
		af.put(p.getUniqueId(), special);
		core.getConfig().set("special" + p.getUniqueId() + w.getName(), special.getContents());

	}
}
