package Code.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Code.Main;

public class Kit implements CommandExecutor, Listener {
	public Kit(Main main) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender instanceof Player) {
			if (sender.hasPermission("narwall.kit")) {
				if (cmd.getName().equalsIgnoreCase("kit")) {
					Player p = (Player) sender;
					Inventory inv = Bukkit.getServer().createInventory(null, 27, ChatColor.GOLD + "Kits!");
					// soldier
					ItemStack soldier = new ItemStack(Material.WOOD_SWORD);
					ItemMeta soldierim = soldier.getItemMeta();
					soldierim.setDisplayName(ChatColor.BLUE + "Soldier");
					ArrayList<String> soldierl = new ArrayList<String>();
					soldierl.add(ChatColor.LIGHT_PURPLE + "Sharpness III Diamond Sword");
					soldierl.add(ChatColor.LIGHT_PURPLE + "Power I Bow");
					soldierl.add(ChatColor.LIGHT_PURPLE + "Fishing Rod");
					soldierl.add(ChatColor.LIGHT_PURPLE + "4 Normal Golden Apples");
					soldierl.add(ChatColor.LIGHT_PURPLE + "32 Arrows");
					soldierl.add(ChatColor.LIGHT_PURPLE + "Protection II Diamond Helmet");
					soldierl.add(ChatColor.LIGHT_PURPLE + "Protection II Diamond Chestplate");
					soldierl.add(ChatColor.LIGHT_PURPLE + "Protection II Diamond Pants");
					soldierl.add(ChatColor.LIGHT_PURPLE + "Protection II Diamond Boots");
					soldierim.setLore(soldierl);
					soldier.setItemMeta(soldierim);
					inv.setItem(0, soldier);
					p.openInventory(inv);
					// archer
					ItemStack archer = new ItemStack(Material.BOW);
					ItemMeta archerim = archer.getItemMeta();
					archerim.setDisplayName(ChatColor.BLUE + "Archer");
					ArrayList<String> archerl = new ArrayList<String>();
					archerl.add(ChatColor.LIGHT_PURPLE + "Sharpness I, Knockback I Diamond Sword");
					archerl.add(ChatColor.LIGHT_PURPLE + "Power III Bow");
					archerl.add(ChatColor.LIGHT_PURPLE + "4 Normal Golden Apples");
					archerl.add(ChatColor.LIGHT_PURPLE + "64 Arrows");
					archerl.add(ChatColor.LIGHT_PURPLE + "Protection I Diamond Helmet");
					archerl.add(ChatColor.LIGHT_PURPLE + "Protection I Diamond Chestplate");
					archerl.add(ChatColor.LIGHT_PURPLE + "Protection I Diamond Pants");
					archerl.add(ChatColor.LIGHT_PURPLE + "Protection I Diamond Boots");
					archerim.setLore(archerl);
					archer.setItemMeta(archerim);
					inv.setItem(1, archer);
					p.openInventory(inv);
					// fisherman
					ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
					ItemMeta fishermanim = fisherman.getItemMeta();
					fishermanim.setDisplayName(ChatColor.BLUE + "Fisherman");
					ArrayList<String> fishermanl = new ArrayList<String>();
					fishermanl.add(ChatColor.LIGHT_PURPLE + "Knockback V fishing rod");
					fishermanl.add(ChatColor.LIGHT_PURPLE + "Sharpness X Pufferfish");
					fishermanl.add(ChatColor.LIGHT_PURPLE + "Fire Aspect I Clownfish");
					fishermanl.add(ChatColor.LIGHT_PURPLE + "0:45 second splash potion of Posion 30");
					fishermanl.add(ChatColor.LIGHT_PURPLE + "8 Normal Golden Apples");
					fishermanl.add(ChatColor.LIGHT_PURPLE + "Protection III Diamond Helmet");
					fishermanl.add(ChatColor.LIGHT_PURPLE + "Protection III Diamond Chestplate");
					fishermanl.add(ChatColor.LIGHT_PURPLE + "Protection III Diamond Pants");
					fishermanl.add(ChatColor.LIGHT_PURPLE + "Protection III Diamond Boots");
					fishermanim.setLore(fishermanl);
					fisherman.setItemMeta(fishermanim);
					inv.setItem(2, fisherman);
					p.closeInventory();
					p.openInventory(inv);
					p.sendMessage(ChatColor.GOLD + "Kit menu opened!");
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("elytra")) {
							ItemStack bow = new ItemStack(Material.BOW);
							bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
							bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
							ItemStack arrows = new ItemStack(Material.ARROW, 64);
							ItemStack apple = new ItemStack(Material.GOLDEN_APPLE, 64);
							ItemMeta im = apple.getItemMeta();
							ItemStack elytra = new ItemStack(Material.ELYTRA);
							im.setDisplayName(ChatColor.GOLD + "NOT FOR PVP! ONLY FOR ELYRA!");
							apple.setItemMeta(im);
							p.getInventory().addItem(arrows);
							p.getInventory().addItem(bow);
							p.getInventory().addItem(apple);
							p.getInventory().addItem(elytra);
						} else if (args[0].equalsIgnoreCase("soldier")) {
							/*
							 * // clearing inventory p.getInventory().clear();
							 * // setting chestplate ItemStack chestplate = new
							 * ItemStack(Material.IRON_CHESTPLATE);
							 * p.getInventory().setChestplate(chestplate); //
							 * setting helmet ItemStack helmet = new
							 * ItemStack(Material.IRON_HELMET);
							 * p.getInventory().setHelmet(helmet); // setting
							 * boots ItemStack boots = new
							 * ItemStack(Material.IRON_BOOTS);
							 * p.getInventory().setBoots(boots); // setting legs
							 * ItemStack legs = new
							 * ItemStack(Material.IRON_LEGGINGS);
							 * p.getInventory().setLeggings(legs); // sword
							 * ItemStack sword = new
							 * ItemStack(Material.DIAMOND_SWORD);
							 * sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
							 * ItemMeta im = sword.getItemMeta();
							 * im.setDisplayName(ChatColor.BOLD + "" +
							 * ChatColor.DARK_RED + "Ares bloody knife");
							 * sword.setItemMeta(im);
							 * p.getInventory().addItem(sword); // bow and
							 * arrows ItemStack bow = new
							 * ItemStack(Material.BOW); ItemStack arrows = new
							 * ItemStack(Material.ARROW, 32);
							 * bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
							 * ItemMeta im1 = bow.getItemMeta();
							 * im1.setDisplayName(ChatColor.BOLD + "" +
							 * ChatColor.MAGIC + "" + ChatColor.DARK_GREEN +
							 * ChatColor.MAGIC + "a" + ChatColor.DARK_GREEN +
							 * "#AimBot" + ChatColor.MAGIC + "a");
							 * bow.setItemMeta(im1);
							 * p.getInventory().addItem(bow);
							 * p.getInventory().setItem(9, arrows); // golden
							 * apple ItemStack apple = new
							 * ItemStack(Material.GOLDEN_APPLE); ItemMeta im2 =
							 * apple.getItemMeta();
							 * im2.setDisplayName(ChatColor.BOLD + "" +
							 * ChatColor.GOLD + "Your last hope");
							 * apple.setItemMeta(im2);
							 * p.getInventory().setItem(8, apple); // fishing
							 * rod ItemStack rod = new
							 * ItemStack(Material.FISHING_ROD); ItemMeta im3 =
							 * rod.getItemMeta();
							 * im3.setDisplayName(ChatColor.BOLD + "" +
							 * ChatColor.RED + "Goway"); rod.setItemMeta(im3);
							 * p.getInventory().setItem(2, rod);
							 */
						}
					}
				}
			} else {
				sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not have permissions!");
			}
		}
		return false;

	}

	@EventHandler
	public void inventoryClickEvent(InventoryClickEvent e) {
		if (e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			try {
				if (e.getClickedInventory().getName().equalsIgnoreCase(ChatColor.GOLD + "Kits!")) {
					ItemStack is = e.getCurrentItem();
					if (is.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Soldier")) {

						// sword
						ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
						ItemMeta im = sword.getItemMeta();
						im.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
						im.setDisplayName(ChatColor.DARK_RED + "Vengeance");
						sword.setItemMeta(im);

						// bow

						ItemStack bow = new ItemStack(Material.BOW);
						ItemMeta bowim = bow.getItemMeta();
						bowim.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
						bowim.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.MAGIC + "s" + ChatColor.DARK_GREEN
								+ "#AimBot" + ChatColor.MAGIC + "g");
						bow.setItemMeta(bowim);

						// fishing rod
						ItemStack rod = new ItemStack(Material.FISHING_ROD);
						ItemMeta rodim = rod.getItemMeta();
						rodim.setUnbreakable(true);
						rodim.setDisplayName(ChatColor.RED + "Goway");
						rod.setItemMeta(rodim);

						// gapples
						ItemStack gapples = new ItemStack(Material.GOLDEN_APPLE, 4);
						ItemMeta gim = gapples.getItemMeta();
						gim.setDisplayName(ChatColor.GOLD + "Your last hope");
						gapples.setItemMeta(gim);

						// arrows
						ItemStack arrows = new ItemStack(Material.ARROW, 32);

						// player stuff
						e.setCancelled(true);
						p.closeInventory();
						p.sendMessage(ChatColor.BLUE + "You now have the Soldier Kit!");

						// leggings
						ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
						ItemMeta legsim = legs.getItemMeta();
						legsim.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
						legs.setItemMeta(legsim);

						// chestplate
						ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
						ItemMeta chestsim = chest.getItemMeta();
						chestsim.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
						chest.setItemMeta(chestsim);

						// boots
						ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
						ItemMeta bootsim = boots.getItemMeta();
						bootsim.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
						boots.setItemMeta(bootsim);

						// helmet
						ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
						ItemMeta hemletim = helmet.getItemMeta();
						hemletim.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
						helmet.setItemMeta(hemletim);

						// add items
						ItemStack[] inv = p.getInventory().getContents();

						ItemStack leggings = p.getInventory().getLeggings();
						ItemStack chestplate = p.getInventory().getChestplate();
						ItemStack boot = p.getInventory().getBoots();
						ItemStack helm = p.getInventory().getHelmet();

						if (!(leggings == null)) {
							p.getInventory().setLeggings(legs);
						} else {
							p.getInventory().setLeggings(legs);
						}

						if (!(chestplate == null)) {
							p.getInventory().setChestplate(chest);

						} else {
							p.getInventory().setChestplate(chest);
						}

						if (!(boot == null)) {
							p.getInventory().setBoots(boots);

						} else {
							p.getInventory().setBoots(boots);
						}

						if (!(helm == null)) {
							p.getInventory().setHelmet(helmet);
						} else {
							p.getInventory().setHelmet(helmet);
						}

						if (!(inv[0] == null)) {
							p.getInventory().removeItem(inv[0]);
							p.getInventory().setItem(0, sword);

						} else {
							p.getInventory().setItem(0, sword);
						}

						if (!(inv[1] == null)) {
							p.getInventory().removeItem(inv[1]);
							p.getInventory().setItem(1, bow);

						} else {
							p.getInventory().setItem(1, bow);
						}

						if (!(inv[9] == null)) {
							p.getInventory().removeItem(inv[9]);
							p.getInventory().setItem(9, arrows);

						} else {
							p.getInventory().setItem(9, arrows);
						}

						if (!(inv[8] == null)) {
							p.getInventory().removeItem(inv[8]);
							p.getInventory().setItem(8, gapples);

						} else {
							p.getInventory().setItem(8, gapples);
						}

						if (!(inv[2] == null)) {
							p.getInventory().removeItem(inv[2]);
							p.getInventory().setItem(2, rod);

						} else {
							p.getInventory().setItem(2, rod);
						}

						// add items back
						try {
							if (leggings != null) {
								p.getInventory().addItem(leggings);
							}

							if (chestplate != null) {
								p.getInventory().addItem(chestplate);
							}

							if (helm != null) {
								p.getInventory().addItem(helm);
							}

							if (helm != null) {
								p.getInventory().addItem(helm);
							}

							if (inv[2] != null) {
								p.getInventory().addItem(inv[2]);
							}

							if (leggings != null) {
								p.getInventory().addItem(leggings);
							}

							if (inv[0] != null) {
								p.getInventory().addItem(inv[0]);
							}

							if (inv[1] != null) {
								p.getInventory().addItem(inv[1]);
							}

							if (inv[8] != null) {
								p.getInventory().addItem(inv[8]);
							}

							if (inv[9] != null) {
								p.getInventory().addItem(inv[9]);
							}

						} catch (IllegalArgumentException iae) {
						}
					} else if (is.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Archer")) {

						// sword
						ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
						ItemMeta im = sword.getItemMeta();
						im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
						im.addEnchant(Enchantment.KNOCKBACK, 1, true);
						im.setDisplayName(ChatColor.DARK_RED + "Vengeance");
						sword.setItemMeta(im);

						// bow

						ItemStack bow = new ItemStack(Material.BOW);
						ItemMeta bowim = bow.getItemMeta();
						bowim.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
						bowim.setDisplayName(ChatColor.GOLD + "Bob");
						bow.setItemMeta(bowim);

						// gapples
						ItemStack gapples = new ItemStack(Material.GOLDEN_APPLE, 4);
						ItemMeta gim = gapples.getItemMeta();
						gim.setDisplayName(ChatColor.GOLD + "Your last hope");
						gapples.setItemMeta(gim);

						// arrows
						ItemStack arrows = new ItemStack(Material.ARROW, 64);

						// player stuff
						e.setCancelled(true);
						p.closeInventory();
						p.sendMessage(ChatColor.BLUE + "You now have the Archer Kit!");

						// leggings
						ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
						ItemMeta legsim = legs.getItemMeta();
						legsim.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
						legs.setItemMeta(legsim);

						// chestplate
						ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
						ItemMeta chestsim = chest.getItemMeta();
						chestsim.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
						chest.setItemMeta(chestsim);

						// boots
						ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
						ItemMeta bootsim = boots.getItemMeta();
						bootsim.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
						boots.setItemMeta(bootsim);

						// helmet
						ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
						ItemMeta hemletim = helmet.getItemMeta();
						hemletim.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
						helmet.setItemMeta(hemletim);

						// add items
						ItemStack[] inv = p.getInventory().getContents();

						ItemStack leggings = p.getInventory().getLeggings();
						ItemStack chestplate = p.getInventory().getChestplate();
						ItemStack boot = p.getInventory().getBoots();
						ItemStack helm = p.getInventory().getHelmet();

						if (!(leggings == null)) {
							p.getInventory().setLeggings(legs);
						} else {
							p.getInventory().setLeggings(legs);
						}

						if (!(chestplate == null)) {
							p.getInventory().setChestplate(chest);

						} else {
							p.getInventory().setChestplate(chest);
						}

						if (!(boot == null)) {
							p.getInventory().setBoots(boots);

						} else {
							p.getInventory().setBoots(boots);
						}

						if (!(helm == null)) {
							p.getInventory().setHelmet(helmet);
						} else {
							p.getInventory().setHelmet(helmet);
						}

						if (!(inv[0] == null)) {
							p.getInventory().removeItem(inv[0]);
							p.getInventory().setItem(0, sword);

						} else {
							p.getInventory().setItem(0, sword);
						}

						if (!(inv[1] == null)) {
							p.getInventory().removeItem(inv[1]);
							p.getInventory().setItem(1, bow);

						} else {
							p.getInventory().setItem(1, bow);
						}

						if (!(inv[9] == null)) {
							p.getInventory().removeItem(inv[9]);
							p.getInventory().setItem(9, arrows);

						} else {
							p.getInventory().setItem(9, arrows);
						}

						if (!(inv[8] == null)) {
							p.getInventory().removeItem(inv[8]);
							p.getInventory().setItem(8, gapples);

						} else {
							p.getInventory().setItem(8, gapples);
						}

						// add items back
						try {
							if (leggings != null) {
								p.getInventory().addItem(leggings);
							}

							if (chestplate != null) {
								p.getInventory().addItem(chestplate);
							}

							if (helm != null) {
								p.getInventory().addItem(helm);
							}

							if (helm != null) {
								p.getInventory().addItem(helm);
							}

							if (leggings != null) {
								p.getInventory().addItem(leggings);
							}

							if (inv[0] != null) {
								p.getInventory().addItem(inv[0]);
							}

							if (inv[1] != null) {
								p.getInventory().addItem(inv[1]);
							}

							if (inv[8] != null) {
								p.getInventory().addItem(inv[8]);
							}

							if (inv[9] != null) {
								p.getInventory().addItem(inv[9]);
							}

						} catch (IllegalArgumentException iae) {
						}
					}
				}
			} catch (NullPointerException npe) {
			}
		}
	}
}
