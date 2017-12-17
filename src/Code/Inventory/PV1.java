package Code.Inventory;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Code.Main;

public class PV1 implements CommandExecutor, Listener {
	private Main core;

	public PV1(Main main) {
		this.core = main;
	}

	@SuppressWarnings("unchecked")
	@EventHandler
	public void createPvs(PlayerJoinEvent e) {
		// 1
		if (!core.pv2.containsKey(e.getPlayer().getUniqueId())) {
			if (core.getConfig().getList("pvs" + e.getPlayer().getUniqueId() + "pv1") != null) {
				ItemStack[] contents8 = null;
				Object l8 = core.getConfig().getList("pvs" + e.getPlayer().getUniqueId() + "pv1");
				Inventory inv8 = Bukkit.getServer().createInventory(e.getPlayer(), 54, "Player Vault 1");
				if (l8 instanceof ItemStack[]) {
					contents8 = (ItemStack[]) l8;
				} else if (l8 instanceof List) {
					contents8 = (ItemStack[]) ((List<ItemStack>) l8).toArray(new ItemStack[0]);
				}
				if (inv8 != null) {
					inv8.setContents(contents8);
				}
				core.pv1.put(e.getPlayer().getUniqueId(), inv8);
			} else {
				core.pv1.put(e.getPlayer().getUniqueId(), Bukkit.createInventory(e.getPlayer(), 54, "Player Vault 1"));
			}
		}

		// 2
		ItemStack[] contents1 = null;
		Object l1 = core.getConfig().getList("pvs" + e.getPlayer().getUniqueId() + "pv2");
		Inventory inv1 = Bukkit.getServer().createInventory(e.getPlayer(), 54, "Player Vault 2");
		if (!core.pv2.containsKey(e.getPlayer().getUniqueId())) {
			if (l1 != null) {
				if (l1 instanceof ItemStack[]) {
					contents1 = (ItemStack[]) l1;
				} else if (l1 instanceof List) {
					contents1 = (ItemStack[]) ((List<ItemStack>) l1).toArray(new ItemStack[0]);
				}
				if (inv1 != null) {
					inv1.setContents(contents1);
				}
				core.pv2.put(e.getPlayer().getUniqueId(), inv1);
			} else {
				core.pv2.put(e.getPlayer().getUniqueId(), Bukkit.createInventory(e.getPlayer(), 54, "Player Vault 2"));
			}
		}

		// 3
		ItemStack[] contents2 = null;
		Object l2 = core.getConfig().getList("pvs" + e.getPlayer().getUniqueId() + "pv3");
		Inventory inv2 = Bukkit.getServer().createInventory(e.getPlayer(), 54, "Player Vault 3");
		if (!core.pv3.containsKey(e.getPlayer().getUniqueId())) {
			if (l2 != null) {
				if (l2 instanceof ItemStack[]) {
					contents2 = (ItemStack[]) l2;
				} else if (l2 instanceof List) {
					contents2 = (ItemStack[]) ((List<ItemStack>) l2).toArray(new ItemStack[0]);
				}
				if (inv2 != null) {
					inv2.setContents(contents2);
				}
				core.pv3.put(e.getPlayer().getUniqueId(), inv2);
			} else {
				core.pv3.put(e.getPlayer().getUniqueId(), Bukkit.createInventory(e.getPlayer(), 54, "Player Vault 3"));
			}
		}
		// 4
		ItemStack[] contents3 = null;
		Object l3 = core.getConfig().getList("pvs" + e.getPlayer().getUniqueId() + "pv4");

		Inventory inv3 = Bukkit.getServer().createInventory(e.getPlayer(), 54, "Player Vault 4");
		if (!core.pv5.containsKey(e.getPlayer().getUniqueId())) {
			if (l3 != null) {
				if (l3 instanceof ItemStack[]) {
					contents3 = (ItemStack[]) l3;
				} else if (l3 instanceof List) {
					contents3 = (ItemStack[]) ((List<ItemStack>) l3).toArray(new ItemStack[0]);
				}
				if (inv3 != null) {
					inv3.setContents(contents3);
				}
				core.pv4.put(e.getPlayer().getUniqueId(), inv3);
			} else {
				core.pv4.put(e.getPlayer().getUniqueId(), Bukkit.createInventory(e.getPlayer(), 54, "Player Vault 1"));
			}
		}
		// 5
		ItemStack[] contents4 = null;
		Object l4 = core.getConfig().getList("pvs" + e.getPlayer().getUniqueId() + "pv5");
		Inventory inv4 = Bukkit.getServer().createInventory(e.getPlayer(), 54, "Player Vault 5");
		if (!core.pv5.containsKey(e.getPlayer().getUniqueId())) {
			if (l4 != null) {
				if (l4 instanceof ItemStack[]) {
					contents4 = (ItemStack[]) l4;
				} else if (l4 instanceof List) {
					contents4 = (ItemStack[]) ((List<ItemStack>) l4).toArray(new ItemStack[0]);
				}
				if (inv4 != null) {
					inv4.setContents(contents4);
				}
				core.pv5.put(e.getPlayer().getUniqueId(), inv4);
			} else {
				core.pv5.put(e.getPlayer().getUniqueId(), Bukkit.createInventory(e.getPlayer(), 54, "Player Vault 5"));
			}
		}
		// 6
		ItemStack[] contents5 = null;
		Object l5 = core.getConfig().getList("pvs" + e.getPlayer().getUniqueId() + "pv6");
		Inventory inv5 = Bukkit.getServer().createInventory(e.getPlayer(), 54, "Player Vault 6");
		if (!core.pv6.containsKey(e.getPlayer().getUniqueId())) {
			if (l5 != null) {
				if (l5 instanceof ItemStack[]) {
					contents5 = (ItemStack[]) l5;
				} else if (l5 instanceof List) {
					contents5 = (ItemStack[]) ((List<ItemStack>) l5).toArray(new ItemStack[0]);
				}
				if (inv5 != null) {
					inv5.setContents(contents5);
				}
				core.pv6.put(e.getPlayer().getUniqueId(), inv5);
			} else {
				core.pv6.put(e.getPlayer().getUniqueId(), Bukkit.createInventory(e.getPlayer(), 54, "Player Vault 1"));
			}
		}
		// 7
		ItemStack[] contents6 = null;
		Object l6 = core.getConfig().getList("pvs" + e.getPlayer().getUniqueId() + "pv7");
		Inventory inv6 = Bukkit.getServer().createInventory(e.getPlayer(), 54, "Player Vault 7");
		if (!core.pv7.containsKey(e.getPlayer().getUniqueId())) {
			if (l6 != null) {
				if (l6 instanceof ItemStack[]) {
					contents6 = (ItemStack[]) l6;
				} else if (l6 instanceof List) {
					contents6 = (ItemStack[]) ((List<ItemStack>) l6).toArray(new ItemStack[0]);
				}
				if (inv6 != null) {
					inv6.setContents(contents6);
				}
				core.pv7.put(e.getPlayer().getUniqueId(), inv6);
			} else {
				core.pv7.put(e.getPlayer().getUniqueId(), Bukkit.createInventory(e.getPlayer(), 54, "Player Vault 7"));
			}
		}
		// 8
		ItemStack[] contents7 = null;
		Object l7 = core.getConfig().getList("pvs" + e.getPlayer().getUniqueId() + "pv8");
		Inventory inv7 = Bukkit.getServer().createInventory(e.getPlayer(), 54, "Player Vault 8");
		if (!core.pv8.containsKey(e.getPlayer().getUniqueId())) {
			if (l7 != null) {
				if (l7 instanceof ItemStack[]) {
					contents7 = (ItemStack[]) l7;
				} else if (l7 instanceof List) {
					contents7 = (ItemStack[]) ((List<ItemStack>) l7).toArray(new ItemStack[0]);
				}
				if (inv7 != null) {
					inv7.setContents(contents7);
				}
				core.pv8.put(e.getPlayer().getUniqueId(), inv7);
			} else {
				core.pv8.put(e.getPlayer().getUniqueId(), Bukkit.createInventory(e.getPlayer(), 54, "Player Vault 8"));
			}
		}
	}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		try{
		// 1
		if (!core.getConfig().contains("pvs" + e.getPlayer().getUniqueId() + "pv1")) {
			core.getConfig().createSection("pvs" + e.getPlayer().getUniqueId() + "pv1");
		}
		if(!core.pv1.isEmpty()){
		ItemStack[] is = core.pv1.get(e.getPlayer().getUniqueId()).getContents();
		core.getConfig().set("pvs" + e.getPlayer().getUniqueId() + "pv1", is);
		}
		// 2
		if(!core.pv2.isEmpty()){
		if (!core.getConfig().contains("pvs" + e.getPlayer().getUniqueId() + "pv2")) {
			core.getConfig().createSection("pvs" + e.getPlayer().getUniqueId() + "pv2");
		}
		}
		ItemStack[] is2 = core.pv2.get(e.getPlayer().getUniqueId()).getContents();
		core.getConfig().set("pvs" + e.getPlayer().getUniqueId() + "pv2", is2);
		// 3
		if (!core.getConfig().contains("pvs" + e.getPlayer().getUniqueId() + "pv3")) {
			core.getConfig().createSection("pvs" + e.getPlayer().getUniqueId() + "pv3");
		}
		ItemStack[] is3 = core.pv3.get(e.getPlayer().getUniqueId()).getContents();
		core.getConfig().set("pvs" + e.getPlayer().getUniqueId() + "pv3", is3);
		// 4
		if (!core.getConfig().contains("pvs" + e.getPlayer().getUniqueId() + "pv4")) {
			core.getConfig().createSection("pvs" + e.getPlayer().getUniqueId() + "pv4");
		}
		ItemStack[] is4 = core.pv4.get(e.getPlayer().getUniqueId()).getContents();
		core.getConfig().set("pvs" + e.getPlayer().getUniqueId() + "pv4", is4);
		// 5
		if (!core.getConfig().contains("pvs" + e.getPlayer().getUniqueId() + "pv5")) {
			core.getConfig().createSection("pvs" + e.getPlayer().getUniqueId() + "pv5");
		}
		ItemStack[] is5 = core.pv5.get(e.getPlayer().getUniqueId()).getContents();
		core.getConfig().set("pvs" + e.getPlayer().getUniqueId() + "pv5", is5);
		// 6
		if (!core.getConfig().contains("pvs" + e.getPlayer().getUniqueId() + "pv6")) {
			core.getConfig().createSection("pvs" + e.getPlayer().getUniqueId() + "pv6");
		}
		ItemStack[] is6 = core.pv6.get(e.getPlayer().getUniqueId()).getContents();
		core.getConfig().set("pvs" + e.getPlayer().getUniqueId() + "pv6", is6);
		// 7
		if (!core.getConfig().contains("pvs" + e.getPlayer().getUniqueId() + "pv7")) {
			core.getConfig().createSection("pvs" + e.getPlayer().getUniqueId() + "pv7");
		}
		ItemStack[] is7 = core.pv7.get(e.getPlayer().getUniqueId()).getContents();
		core.getConfig().set("pvs" + e.getPlayer().getUniqueId() + "pv7", is7);
		// 8
		if (!core.getConfig().contains("pvs" + e.getPlayer().getUniqueId() + "pv8")) {
			core.getConfig().createSection("pvs" + e.getPlayer().getUniqueId() + "pv8");
		}
		ItemStack[] is8 = core.pv8.get(e.getPlayer().getUniqueId()).getContents();
		core.getConfig().set("pvs" + e.getPlayer().getUniqueId() + "pv8", is8);
		core.saveConfig();
		} catch(NullPointerException e1){
		}
	}

	@SuppressWarnings("unchecked")
	public void onDisable() {
		for (Player online : Bukkit.getOnlinePlayers()) {
			Inventory inv = Bukkit.getServer().createInventory(online.getPlayer(), 54, "Player Vault 1");
			List<ItemStack> l = (List<ItemStack>) core.getConfig()
					.getList("pvs" + online.getPlayer().getUniqueId() + "pv1");
			ItemStack[] a = (ItemStack[]) ((List<ItemStack>) l).toArray(new ItemStack[0]);
			inv.setContents(a);
			core.pv1.put(online.getUniqueId(), inv);
			core.getConfig().set("pvs" + online.getPlayer().getUniqueId() + "pv1", inv.getContents());
		}
		for (Player online : Bukkit.getOnlinePlayers()) {
			Inventory inv = Bukkit.getServer().createInventory(online.getPlayer(), 54, "Player Vault 2");
			List<ItemStack> l = (List<ItemStack>) core.getConfig()
					.getList("pvs" + online.getPlayer().getUniqueId() + "pv2");
			ItemStack[] a = (ItemStack[]) ((List<ItemStack>) l).toArray(new ItemStack[0]);
			inv.setContents(a);
			core.pv2.put(online.getUniqueId(), inv);
			core.getConfig().set("pvs" + online.getPlayer().getUniqueId() + "pv2", inv.getContents());
		}
		for (Player online : Bukkit.getOnlinePlayers()) {
			Inventory inv = Bukkit.getServer().createInventory(online.getPlayer(), 54, "Player Vault 3");
			List<ItemStack> l = (List<ItemStack>) core.getConfig()
					.getList("pvs" + online.getPlayer().getUniqueId() + "pv3");
			ItemStack[] a = (ItemStack[]) ((List<ItemStack>) l).toArray(new ItemStack[0]);
			inv.setContents(a);
			core.pv3.put(online.getUniqueId(), inv);
			core.getConfig().set("pvs" + online.getPlayer().getUniqueId() + "pv3", inv.getContents());
		}
		for (Player online : Bukkit.getOnlinePlayers()) {
			Inventory inv = Bukkit.getServer().createInventory(online.getPlayer(), 54, "Player Vault 4");
			List<ItemStack> l = (List<ItemStack>) core.getConfig()
					.getList("pvs" + online.getPlayer().getUniqueId() + "pv4");
			ItemStack[] a = (ItemStack[]) ((List<ItemStack>) l).toArray(new ItemStack[0]);
			inv.setContents(a);
			core.pv4.put(online.getUniqueId(), inv);
			core.getConfig().set("pvs" + online.getPlayer().getUniqueId() + "pv4", inv.getContents());
		}
		for (Player online : Bukkit.getOnlinePlayers()) {
			Inventory inv = Bukkit.getServer().createInventory(online.getPlayer(), 54, "Player Vault 5");
			List<ItemStack> l = (List<ItemStack>) core.getConfig()
					.getList("pvs" + online.getPlayer().getUniqueId() + "pv5");
			ItemStack[] a = (ItemStack[]) ((List<ItemStack>) l).toArray(new ItemStack[0]);
			inv.setContents(a);
			core.pv5.put(online.getUniqueId(), inv);
			core.getConfig().set("pvs" + online.getPlayer().getUniqueId() + "pv5", inv.getContents());
		}
		for (Player online : Bukkit.getOnlinePlayers()) {
			Inventory inv = Bukkit.getServer().createInventory(online.getPlayer(), 54, "Player Vault 6");
			List<ItemStack> l = (List<ItemStack>) core.getConfig()
					.getList("pvs" + online.getPlayer().getUniqueId() + "pv6");
			ItemStack[] a = (ItemStack[]) ((List<ItemStack>) l).toArray(new ItemStack[0]);
			inv.setContents(a);
			core.pv6.put(online.getUniqueId(), inv);
			core.getConfig().set("pvs" + online.getPlayer().getUniqueId() + "pv6", inv.getContents());
		}
		for (Player online : Bukkit.getOnlinePlayers()) {
			Inventory inv = Bukkit.getServer().createInventory(online.getPlayer(), 54, "Player Vault 7");
			List<ItemStack> l = (List<ItemStack>) core.getConfig()
					.getList("pvs" + online.getPlayer().getUniqueId() + "pv7");
			ItemStack[] a = (ItemStack[]) ((List<ItemStack>) l).toArray(new ItemStack[0]);
			inv.setContents(a);
			core.pv7.put(online.getUniqueId(), inv);
			core.getConfig().set("pvs" + online.getPlayer().getUniqueId() + "pv7", inv.getContents());
		}
		for (Player online : Bukkit.getOnlinePlayers()) {
			Inventory inv = Bukkit.getServer().createInventory(online.getPlayer(), 54, "Player Vault 8");
			List<ItemStack> l = (List<ItemStack>) core.getConfig()
					.getList("pvs" + online.getPlayer().getUniqueId() + "pv8");
			ItemStack[] a = (ItemStack[]) ((List<ItemStack>) l).toArray(new ItemStack[0]);
			inv.setContents(a);
			core.pv8.put(online.getUniqueId(), inv);
			core.getConfig().set("pvs" + online.getPlayer().getUniqueId() + "pv8", inv.getContents());
		}
		core.saveConfig();
		core.pv1.clear();
		core.pv2.clear();
		core.pv3.clear();
		core.pv4.clear();
		core.pv5.clear();
		core.pv6.clear();
		core.pv7.clear();
		core.pv8.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.DARK_RED + "Go Fuck Yourself.");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pv")) {
			if (sender.hasPermission("narwall.pv")) {
				for (Player pl : Bukkit.getOnlinePlayers()) {
					ItemStack[] contents8 = null;
					Object l8 = core.getConfig().getList("pvs" + pl.getUniqueId() + "pv1");
					Inventory inv8 = Bukkit.getServer().createInventory(pl, 54, "Player Vault 1");
					if (!core.pv1.containsKey(pl.getUniqueId())) {
						if (l8 != null) {
							if (l8 instanceof ItemStack[]) {
								contents8 = (ItemStack[]) l8;
							} else if (l8 instanceof List) {
								contents8 = (ItemStack[]) ((List<ItemStack>) l8).toArray(new ItemStack[0]);
							}
							if (inv8 != null) {
								inv8.setContents(contents8);
							}
							core.pv1.put(pl.getUniqueId(), inv8);
						} else {
							core.pv1.put(pl.getUniqueId(), Bukkit.createInventory(p, 54, "Player Vault 1"));
						}
					}

					// 2
					ItemStack[] contents1 = null;
					Object l1 = core.getConfig().getList("pvs" + pl.getUniqueId() + "pv2");
					Inventory inv1 = Bukkit.getServer().createInventory(p, 54, "Player Vault 2");
					if (!core.pv2.containsKey(pl.getUniqueId())) {
						if (l1 != null) {
							if (l1 instanceof ItemStack[]) {
								contents1 = (ItemStack[]) l1;
							} else if (l1 instanceof List) {
								contents1 = (ItemStack[]) ((List<ItemStack>) l1).toArray(new ItemStack[0]);
							}
							if (inv1 != null) {
								inv1.setContents(contents1);
							}
							core.pv2.put(pl.getUniqueId(), inv1);
						} else {
							core.pv2.put(pl.getUniqueId(), Bukkit.createInventory(p, 54, "Player Vault 2"));
						}
					}

					// 3
					ItemStack[] contents2 = null;
					Object l2 = core.getConfig().getList("pvs" + pl.getUniqueId() + "pv3");
					Inventory inv2 = Bukkit.getServer().createInventory(p, 54, "Player Vault 3");
					if (!core.pv3.containsKey(pl.getUniqueId())) {
						if (l2 != null) {
							if (l2 instanceof ItemStack[]) {
								contents2 = (ItemStack[]) l2;
							} else if (l2 instanceof List) {
								contents2 = (ItemStack[]) ((List<ItemStack>) l2).toArray(new ItemStack[0]);
							}
							if (inv2 != null) {
								inv2.setContents(contents2);
							}
							core.pv3.put(pl.getUniqueId(), inv2);
						} else {
							core.pv3.put(pl.getUniqueId(), Bukkit.createInventory(p, 54, "Player Vault 3"));
						}
					}
					// 4
					ItemStack[] contents3 = null;
					Object l3 = core.getConfig().getList("pvs" + pl.getUniqueId() + "pv4");

					Inventory inv3 = Bukkit.getServer().createInventory(p, 54, "Player Vault 4");
					if (!core.pv5.containsKey(pl.getUniqueId())) {
						if (l3 != null) {
							if (l3 instanceof ItemStack[]) {
								contents3 = (ItemStack[]) l3;
							} else if (l3 instanceof List) {
								contents3 = (ItemStack[]) ((List<ItemStack>) l3).toArray(new ItemStack[0]);
							}
							if (inv3 != null) {
								inv3.setContents(contents3);
							}
							core.pv4.put(pl.getUniqueId(), inv3);
						} else {
							core.pv4.put(pl.getUniqueId(), Bukkit.createInventory(p, 54, "Player Vault 1"));
						}
					}
					// 5
					ItemStack[] contents4 = null;
					Object l4 = core.getConfig().getList("pvs" + pl.getUniqueId() + "pv5");
					Inventory inv4 = Bukkit.getServer().createInventory(p, 54, "Player Vault 5");
					if (!core.pv5.containsKey(pl.getUniqueId())) {
						if (l4 != null) {
							if (l4 instanceof ItemStack[]) {
								contents4 = (ItemStack[]) l4;
							} else if (l4 instanceof List) {
								contents4 = (ItemStack[]) ((List<ItemStack>) l4).toArray(new ItemStack[0]);
							}
							if (inv4 != null) {
								inv4.setContents(contents4);
							}
							core.pv5.put(pl.getUniqueId(), inv4);
						} else {
							core.pv5.put(pl.getUniqueId(), Bukkit.createInventory(p, 54, "Player Vault 5"));
						}
					}
					// 6
					ItemStack[] contents5 = null;
					Object l5 = core.getConfig().getList("pvs" + pl.getUniqueId() + "pv6");
					Inventory inv5 = Bukkit.getServer().createInventory(p, 54, "Player Vault 6");
					if (!core.pv6.containsKey(pl.getUniqueId())) {
						if (l5 != null) {
							if (l5 instanceof ItemStack[]) {
								contents5 = (ItemStack[]) l5;
							} else if (l5 instanceof List) {
								contents5 = (ItemStack[]) ((List<ItemStack>) l5).toArray(new ItemStack[0]);
							}
							if (inv5 != null) {
								inv5.setContents(contents5);
							}
							core.pv6.put(pl.getUniqueId(), inv5);
						} else {
							core.pv6.put(pl.getUniqueId(), Bukkit.createInventory(p, 54, "Player Vault 1"));
						}
					}
					// 7
					ItemStack[] contents6 = null;
					Object l6 = core.getConfig().getList("pvs" + pl.getUniqueId() + "pv7");
					Inventory inv6 = Bukkit.getServer().createInventory(p, 54, "Player Vault 7");
					if (!core.pv7.containsKey(pl.getUniqueId())) {
						if (l6 != null) {
							if (l6 instanceof ItemStack[]) {
								contents6 = (ItemStack[]) l6;
							} else if (l6 instanceof List) {
								contents6 = (ItemStack[]) ((List<ItemStack>) l6).toArray(new ItemStack[0]);
							}
							if (inv6 != null) {
								inv6.setContents(contents6);
							}
							core.pv7.put(pl.getUniqueId(), inv6);
						} else {
							core.pv7.put(pl.getUniqueId(), Bukkit.createInventory(p, 54, "Player Vault 7"));
						}
					}
					// 8
					ItemStack[] contents7 = null;
					Object l7 = core.getConfig().getList("pvs" + pl.getUniqueId() + "pv8");
					Inventory inv7 = Bukkit.getServer().createInventory(p, 54, "Player Vault 8");
					if (!core.pv8.containsKey(pl.getUniqueId())) {
						if (l7 != null) {
							if (l7 instanceof ItemStack[]) {
								contents7 = (ItemStack[]) l7;
							} else if (l7 instanceof List) {
								contents7 = (ItemStack[]) ((List<ItemStack>) l7).toArray(new ItemStack[0]);
							}
							if (inv7 != null) {
								inv7.setContents(contents7);
							}
							core.pv8.put(pl.getUniqueId(), inv7);
						} else {
							core.pv8.put(pl.getUniqueId(), Bukkit.createInventory(p, 54, "Player Vault 8"));
						}
					}
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("1")) {
						p.openInventory(core.pv1.get(p.getUniqueId()));
					} else if (args[0].equalsIgnoreCase("2")) {
						p.openInventory(core.pv2.get(p.getUniqueId()));
					} else if (args[0].equalsIgnoreCase("3")) {
						p.openInventory(core.pv3.get(p.getUniqueId()));
					} else if (args[0].equalsIgnoreCase("4")) {
						p.openInventory(core.pv4.get(p.getUniqueId()));
					} else if (args[0].equalsIgnoreCase("5")) {
						p.openInventory(core.pv5.get(p.getUniqueId()));
					} else if (args[0].equalsIgnoreCase("6")) {
						p.openInventory(core.pv6.get(p.getUniqueId()));
					} else if (args[0].equalsIgnoreCase("7")) {
						p.openInventory(core.pv7.get(p.getUniqueId()));
					} else if (args[0].equalsIgnoreCase("8")) {
						p.openInventory(core.pv8.get(p.getUniqueId()));
					}

				}
			}
		}
		return true;
	}
}
