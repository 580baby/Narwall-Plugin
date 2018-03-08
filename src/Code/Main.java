package Code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import Code.Commands.Armor;
import Code.Commands.Clear_XP;
import Code.Commands.Clear_invintory;
import Code.Commands.Craft;
import Code.Commands.Damage;
import Code.Commands.Delhome;
import Code.Commands.Dev;
import Code.Commands.Double_Jump;
import Code.Commands.Dummy;
import Code.Commands.Enchantment1;
import Code.Commands.Fast_fly;
import Code.Commands.Fast_walking;
import Code.Commands.Feed;
import Code.Commands.Fill;
import Code.Commands.Fix;
import Code.Commands.Flowers;
import Code.Commands.Fly;
import Code.Commands.Gamemode_adventure;
import Code.Commands.Gamemode_creative;
import Code.Commands.Gamemode_spectator;
import Code.Commands.Gamemode_survival;
import Code.Commands.GetPoints;
import Code.Commands.GlitchFix;
import Code.Commands.Heal;
import Code.Commands.Heed;
import Code.Commands.Home;
import Code.Commands.Inventory_GUI;
import Code.Commands.Invsee;
import Code.Commands.Kill_all;
import Code.Commands.Kit;
import Code.Commands.Lol;
import Code.Commands.Milk;
import Code.Commands.Name;
import Code.Commands.No_fly;
import Code.Commands.Nuke;
import Code.Commands.PSA;
import Code.Commands.Reset_fly_speed;
import Code.Commands.Reset_walk_speed;
import Code.Commands.Sethome;
import Code.Commands.Smite;
import Code.Commands.T;
import Code.Commands.Tpa;
import Code.Commands.Tpaccept;
import Code.Commands.Ultimate_pickaxe;
import Code.Commands.V;
import Code.Commands.World_Stuffs;
import Code.Custom_Enchants.Books;
import Code.Custom_Enchants.Enchantment_With_books;
import Code.Inventory.Dev_Bookshelf;
import Code.Inventory.PV1;
import Code.Name_Tags.Chat_Colors;
import Code.Name_Tags.Goodbye_Message;
import Code.Name_Tags.Hello_Message;
import Code.Name_Tags.Tags;
import SetPoints.SetPoints;

public class Main extends JavaPlugin implements CommandExecutor, Listener {
	public HashMap<UUID, Inventory> pv1 = new HashMap<UUID, Inventory>();
	public HashMap<UUID, Inventory> pv2 = new HashMap<UUID, Inventory>();
	public HashMap<UUID, Inventory> pv3 = new HashMap<UUID, Inventory>();
	public HashMap<UUID, Inventory> pv4 = new HashMap<UUID, Inventory>();
	public HashMap<UUID, Inventory> pv5 = new HashMap<UUID, Inventory>();
	public HashMap<UUID, Inventory> pv6 = new HashMap<UUID, Inventory>();
	public HashMap<UUID, Inventory> pv7 = new HashMap<UUID, Inventory>();
	public HashMap<UUID, Inventory> pv8 = new HashMap<UUID, Inventory>();
	List<Player> list = new ArrayList<Player>();
	
	public List<Player> listE() {
		return list;
	}
	
	@Override
	public void onEnable() {
		getCommand("home").setExecutor(new Home(this));
		getCommand("psa").setExecutor(new PSA(this));
		getCommand("sethome").setExecutor(new Sethome(this));
		getCommand("tpa").setExecutor(new Tpa(this));
		getCommand("tpaccept").setExecutor(new Tpaccept(this));
		getCommand("resetwalkspeed").setExecutor(new Reset_walk_speed(this));
		getCommand("lol").setExecutor(new Lol(this));
		getCommand("armor").setExecutor(new Armor(this));
		getCommand("craft").setExecutor(new Craft(this));
		getCommand("pv").setExecutor(new PV1(this));
		getCommand("ci").setExecutor(new Clear_invintory(this));
		getCommand("fastwalking").setExecutor(new Fast_walking(this));
		getCommand("cxp").setExecutor(new Clear_XP(this));
		getCommand("damage").setExecutor(new Damage(this));
		getCommand("getpoints").setExecutor(new GetPoints(this));
		getCommand("fastfly").setExecutor(new Fast_fly(this));
		getCommand("feed").setExecutor(new Feed(this));
		getCommand("kit").setExecutor(new Kit(this));
		getCommand("smite").setExecutor(new Smite(this));
		getCommand("flowers").setExecutor(new Flowers(this));
		getCommand("gc").setExecutor(new Gamemode_creative(this));
		getCommand("ga").setExecutor(new Gamemode_adventure(this));
		getCommand("gs").setExecutor(new Gamemode_survival(this));
		getCommand("gsp").setExecutor(new Gamemode_spectator(this));
		getCommand("heal").setExecutor(new Heal(this));
		getCommand("heed").setExecutor(new Heed(this));
		getCommand("ka").setExecutor(new Kill_all(this));
		getCommand("milk").setExecutor(new Milk(this));
		getCommand("fly").setExecutor(new Fly(this));
		getCommand("tpahere").setExecutor(new Tpa(this));
		getCommand("nofly").setExecutor(new No_fly(this));
		getCommand("invsee").setExecutor(new Invsee(this));
		getCommand("nuke").setExecutor(new Nuke(this));
		getCommand("resetflyspeed").setExecutor(new Reset_fly_speed(this));
		getCommand("ultpick").setExecutor(new Ultimate_pickaxe(this));
		getCommand("menu").setExecutor(new Inventory_GUI(this));
		getCommand("fix").setExecutor(new Fix(this));
		getCommand("glitchfix").setExecutor(new GlitchFix(this));
		getCommand("delhome").setExecutor(new Delhome(this));
		getCommand("enchantment").setExecutor(new Enchantment1(this));
		getCommand("rb").setExecutor(new Books(this));
		getCommand("v").setExecutor(new V(this));
		getCommand("world").setExecutor(new World_Stuffs(this));
		getCommand("dev").setExecutor(new Dev(this));
		getCommand("dummy").setExecutor(new Dummy(this));
		getCommand("jump").setExecutor(new Double_Jump(this));
		getCommand("name").setExecutor(new Name(this));
		getCommand("fill2").setExecutor(new Fill(this));
		getCommand("t").setExecutor(new T(this));
		Bukkit.getServer().getPluginManager().registerEvents(new Inventory_GUI(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Hello_Message(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SetPoints(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Enchantment_With_books(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Books(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Goodbye_Message(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PV1(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Dev_Bookshelf(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Chat_Colors(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Creative_Monitor(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Tags(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Kit(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Dev(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Spawn_Protection(this), this);
		registerConfig();
		this.saveConfig();

		File f = new File(getDataFolder() + File.separator + "worlds");
		File[] flist = f.listFiles();
		for (File u : flist) {
			WorldCreator wc = new WorldCreator(u.getName());
			WorldCreator.name(u.getName());
			Bukkit.getServer().createWorld(wc);
		}
	}

	public void getInventory(Player p, String s) throws IOException, IllegalArgumentException, ClassNotFoundException {
		UUID uuid = p.getUniqueId();
		File file = new File(
				getDataFolder() + File.separator + "inventorys" + File.separator + s + File.separator + uuid + ".nar");
		FileInputStream fis = new FileInputStream(file);
		BukkitObjectInputStream bois = new BukkitObjectInputStream(fis);
		p.getInventory().setContents((ItemStack[]) bois.readObject());
		bois.close();
	}

	public void saveInventory(Player p, String s) throws IOException {
		UUID uuid = p.getUniqueId();
		File folder = new File(getDataFolder() + File.separator + "inventorys");
		File folder2 = new File(getDataFolder() + File.separator + "inventorys" + File.separator + s);
		File file = new File(
				getDataFolder() + File.separator + "inventorys" + File.separator + s + File.separator + uuid + ".nar");
		if (!folder2.exists()) {
			folder2.mkdir();
		}
		if (!folder.exists()) {
			folder.mkdir();
		}
		file.delete();
		FileOutputStream fos = new FileOutputStream(file);
		BukkitObjectOutputStream boos = new BukkitObjectOutputStream(fos);
		boos.writeObject(p.getInventory().getContents());
		boos.close();
	}

	@Override
	public void onDisable() {
		V.vIsOn.clear();
		V.vOn.clear();
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
		}

	}

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	@EventHandler
	public void onInvetoryClick(InventoryClickEvent event) {
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