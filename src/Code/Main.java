package Code;

import java.io.File;
import java.util.HashMap;
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
import Code.Commands.Tpa;
import Code.Commands.Tpaccept;
import Code.Commands.Ultimate_pickaxe;
import Code.Commands.V;
import Code.Commands.World_Stuffs;
import Code.Custom_Enchants.Books;
import Code.Custom_Enchants.Enchantment_With_books;
import Code.Inventory.Dev_Bookshelf;
import Code.Inventory.InventoryClick;
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

	@SuppressWarnings({ "static-access" })
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
		Bukkit.getServer().getPluginManager().registerEvents(new Inventory_GUI(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryClick(this), this);
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
		registerConfig();
		this.saveConfig();

		File f = new File(this.getDataFolder() + File.separator + "worlds");
		File[] flist = f.listFiles();
		for (File u : flist) {
			WorldCreator wc = new WorldCreator(u.getName());
			wc.name(u.getName());
			Bukkit.getServer().createWorld(wc);

			/*
			 * try { File hello = new File(this.getDataFolder() + "hello.txt");
			 * OutputStream os; os = new FileOutputStream(hello);
			 * os.write("stuff".getBytes()); os.close(); } catch (IOException e)
			 * { e.printStackTrace(); }
			 */

		}
	}

	@Override
	public void onDisable() {
		V.vIsOn.clear();
		V.vOn.clear();
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
		}

	}

	// pv writing

	// Config files
	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	// compassClick1

	// public void onPlayerJoin1(PlayerJoinEvent event) {
	// Player player = (Player) event.getPlayer();
	// player.sendMessage("dys work?");
	// player.getEquipment().setBoots(new ItemStack(0));
	// player.getEquipment().setLeggings(new ItemStack(0));
	// player.getEquipment().setHelmet(new ItemStack(0));
	// player.getEquipment().setChestplate(new ItemStack(0));
	// player.getInventory().remove(1);
	// player.getInventory().remove(2);
	// player.getInventory().remove(3);
	// player.getInventory().remove(4);
	// player.getInventory().remove(5);
	// player.getInventory().remove(6);
	// player.getInventory().remove(7);
	// player.getInventory().remove(8);
	// player.getInventory().remove(9);
	// player.getInventory().remove(10);
	// player.getInventory().remove(11);
	// player.getInventory().remove(12);
	// player.getInventory().remove(13);
	// player.getInventory().remove(14);
	// player.getInventory().remove(15);
	// player.getInventory().remove(16);
	// player.getInventory().remove(17);
	// player.getInventory().remove(18);
	// player.getInventory().remove(19);
	// player.getInventory().remove(20);
	// player.getInventory().remove(21);
	// player.getInventory().remove(22);
	// player.getInventory().remove(23);
	// player.getInventory().remove(24);
	// player.getInventory().remove(25);
	// player.getInventory().remove(26);
	// player.getInventory().remove(27);
	// player.getInventory().remove(28);
	// player.getInventory().remove(29);
	// player.getInventory().remove(30);
	// player.getInventory().remove(31);
	// player.getInventory().remove(32);
	// player.getInventory().remove(33);
	// player.getInventory().remove(34);
	// player.getInventory().remove(35);
	// player.getInventory().remove(36);
	// player.getInventory().remove(37);
	// player.getInventory().remove(38);
	// player.getInventory().remove(39);
	// player.getInventory().remove(40);
	// player.getInventory().remove(41);
	// player.getInventory().remove(42);
	// player.getInventory().remove(43);
	// player.getInventory().remove(44);
	// player.getInventory().remove(45);
	// player.getInventory().remove(46);
	// player.getInventory().remove(47);
	// player.getInventory().remove(48);
	// player.getInventory().remove(49);
	// player.getInventory().remove(50);
	// player.getInventory().remove(51);
	// player.getInventory().remove(52);
	// player.getInventory().remove(53);
	// player.getInventory().remove(54);
	// player.getInventory().remove(55);
	// player.getInventory().remove(56);
	// player.getInventory().remove(57);
	// player.getInventory().remove(58);
	// player.getInventory().remove(59);
	// player.getInventory().remove(60);
	// player.getInventory().remove(61);
	// player.getInventory().remove(62);
	// player.getInventory().remove(63);
	// player.getInventory().remove(64);
	// player.getInventory().remove(65);
	// player.getInventory().remove(66);
	// player.getInventory().remove(67);
	// player.getInventory().remove(68);
	// player.getInventory().remove(69);
	// player.getInventory().remove(70);
	// player.getInventory().remove(71);
	// player.getInventory().remove(72);
	// player.getInventory().remove(73);
	// player.getInventory().remove(74);
	// player.getInventory().remove(75);
	// player.getInventory().remove(76);
	// player.getInventory().remove(77);
	// player.getInventory().remove(78);
	// player.getInventory().remove(79);
	// player.getInventory().remove(80);
	// player.getInventory().remove(81);
	// player.getInventory().remove(82);
	// player.getInventory().remove(83);
	// player.getInventory().remove(84);
	// player.getInventory().remove(85);
	// player.getInventory().remove(86);
	// player.getInventory().remove(87);
	// player.getInventory().remove(88);
	// player.getInventory().remove(89);
	// player.getInventory().remove(90);
	// player.getInventory().remove(91);
	// player.getInventory().remove(92);
	// player.getInventory().remove(93);
	// player.getInventory().remove(94);
	// player.getInventory().remove(95);
	// player.getInventory().remove(96);
	// player.getInventory().remove(97);
	// player.getInventory().remove(98);
	// player.getInventory().remove(99);
	// player.getInventory().remove(100);
	// player.getInventory().remove(101);
	// player.getInventory().remove(102);
	// player.getInventory().remove(103);
	// player.getInventory().remove(104);
	// player.getInventory().remove(105);
	// player.getInventory().remove(106);
	// player.getInventory().remove(107);
	// player.getInventory().remove(108);
	// player.getInventory().remove(109);
	// player.getInventory().remove(110);
	// player.getInventory().remove(111);
	// player.getInventory().remove(112);
	// player.getInventory().remove(113);
	// player.getInventory().remove(114);
	// player.getInventory().remove(115);
	// player.getInventory().remove(116);
	// player.getInventory().remove(117);
	// player.getInventory().remove(118);
	// player.getInventory().remove(119);
	// player.getInventory().remove(120);
	// player.getInventory().remove(121);
	// player.getInventory().remove(122);
	// player.getInventory().remove(123);
	// player.getInventory().remove(124);
	// player.getInventory().remove(125);
	// player.getInventory().remove(126);
	// player.getInventory().remove(127);
	// player.getInventory().remove(128);
	// player.getInventory().remove(129);
	// player.getInventory().remove(130);
	// player.getInventory().remove(131);
	// player.getInventory().remove(132);
	// player.getInventory().remove(133);
	// player.getInventory().remove(134);
	// player.getInventory().remove(135);
	// player.getInventory().remove(136);
	// player.getInventory().remove(137);
	// player.getInventory().remove(138);
	// player.getInventory().remove(139);
	// player.getInventory().remove(140);
	// player.getInventory().remove(141);
	// player.getInventory().remove(142);
	// player.getInventory().remove(143);
	// player.getInventory().remove(144);
	// player.getInventory().remove(145);
	// player.getInventory().remove(146);
	// player.getInventory().remove(147);
	// player.getInventory().remove(148);
	// player.getInventory().remove(149);
	// player.getInventory().remove(150);
	// player.getInventory().remove(151);
	// player.getInventory().remove(152);
	// player.getInventory().remove(153);
	// player.getInventory().remove(154);
	// player.getInventory().remove(155);
	// player.getInventory().remove(156);
	// player.getInventory().remove(157);
	// player.getInventory().remove(158);
	// player.getInventory().remove(159);
	// player.getInventory().remove(160);
	// player.getInventory().remove(161);
	// player.getInventory().remove(162);
	// player.getInventory().remove(163);
	// player.getInventory().remove(164);
	// player.getInventory().remove(165);
	// player.getInventory().remove(166);
	// player.getInventory().remove(167);
	// player.getInventory().remove(168);
	// player.getInventory().remove(169);
	// player.getInventory().remove(170);
	// player.getInventory().remove(171);
	// player.getInventory().remove(172);
	// player.getInventory().remove(173);
	// player.getInventory().remove(174);
	// player.getInventory().remove(175);
	// player.getInventory().remove(176);
	// player.getInventory().remove(177);
	// player.getInventory().remove(178);
	// player.getInventory().remove(179);
	// player.getInventory().remove(180);
	// player.getInventory().remove(181);
	// player.getInventory().remove(182);
	// player.getInventory().remove(183);
	// player.getInventory().remove(184);
	// player.getInventory().remove(185);
	// player.getInventory().remove(186);
	// player.getInventory().remove(187);
	// player.getInventory().remove(188);
	// player.getInventory().remove(189);
	// player.getInventory().remove(190);
	// player.getInventory().remove(191);
	// player.getInventory().remove(192);
	// player.getInventory().remove(193);
	// player.getInventory().remove(194);
	// player.getInventory().remove(195);
	// player.getInventory().remove(196);
	// player.getInventory().remove(197);
	// player.getInventory().remove(198);
	// player.getInventory().remove(199);
	// player.getInventory().remove(200);
	// player.getInventory().remove(201);
	// player.getInventory().remove(202);
	// player.getInventory().remove(203);
	// player.getInventory().remove(204);
	// player.getInventory().remove(205);
	// player.getInventory().remove(206);
	// player.getInventory().remove(207);
	// player.getInventory().remove(208);
	// player.getInventory().remove(209);
	// player.getInventory().remove(210);
	// player.getInventory().remove(211);
	// player.getInventory().remove(212);
	// player.getInventory().remove(213);
	// player.getInventory().remove(214);
	// player.getInventory().remove(215);
	// player.getInventory().remove(216);
	// player.getInventory().remove(217);
	// player.getInventory().remove(218);
	// player.getInventory().remove(219);
	// player.getInventory().remove(220);
	// player.getInventory().remove(221);
	// player.getInventory().remove(222);
	// player.getInventory().remove(223);
	// player.getInventory().remove(224);
	// player.getInventory().remove(225);
	// player.getInventory().remove(226);
	// player.getInventory().remove(227);
	// player.getInventory().remove(228);
	// player.getInventory().remove(229);
	// player.getInventory().remove(230);
	// player.getInventory().remove(231);
	// player.getInventory().remove(232);
	// player.getInventory().remove(234);
	// player.getInventory().remove(235);
	// player.getInventory().remove(236);
	// player.getInventory().remove(237);
	// player.getInventory().remove(238);
	// player.getInventory().remove(239);
	// player.getInventory().remove(240);
	// player.getInventory().remove(241);
	// player.getInventory().remove(242);
	// player.getInventory().remove(243);
	// player.getInventory().remove(244);
	// player.getInventory().remove(245);
	// player.getInventory().remove(246);
	// player.getInventory().remove(247);
	// player.getInventory().remove(248);
	// player.getInventory().remove(249);
	// player.getInventory().remove(250);
	// player.getInventory().remove(251);
	// player.getInventory().remove(252);
	// player.getInventory().remove(253);
	// player.getInventory().remove(254);
	// player.getInventory().remove(255);
	// player.getInventory().remove(256);
	// player.getInventory().remove(257);
	// player.getInventory().remove(258);
	// player.getInventory().remove(259);
	// player.getInventory().remove(260);
	// player.getInventory().remove(261);
	// player.getInventory().remove(262);
	// player.getInventory().remove(263);
	// player.getInventory().remove(264);
	// player.getInventory().remove(265);
	// player.getInventory().remove(266);
	// player.getInventory().remove(267);
	// player.getInventory().remove(268);
	// player.getInventory().remove(269);
	// player.getInventory().remove(270);
	// player.getInventory().remove(271);
	// player.getInventory().remove(272);
	// player.getInventory().remove(273);
	// player.getInventory().remove(274);
	// player.getInventory().remove(275);
	// player.getInventory().remove(276);
	// player.getInventory().remove(277);
	// player.getInventory().remove(278);
	// player.getInventory().remove(279);
	// player.getInventory().remove(280);
	// player.getInventory().remove(281);
	// player.getInventory().remove(282);
	// player.getInventory().remove(283);
	// player.getInventory().remove(284);
	// player.getInventory().remove(285);
	// player.getInventory().remove(286);
	// player.getInventory().remove(287);
	// player.getInventory().remove(288);
	// player.getInventory().remove(289);
	// player.getInventory().remove(290);
	// player.getInventory().remove(291);
	// player.getInventory().remove(292);
	// player.getInventory().remove(293);
	// player.getInventory().remove(294);
	// player.getInventory().remove(295);
	// player.getInventory().remove(296);
	// player.getInventory().remove(297);
	// player.getInventory().remove(298);
	// player.getInventory().remove(299);
	// player.getInventory().remove(300);
	// player.getInventory().remove(301);
	// player.getInventory().remove(302);
	// player.getInventory().remove(303);
	// player.getInventory().remove(304);
	// player.getInventory().remove(305);
	// player.getInventory().remove(306);
	// player.getInventory().remove(307);
	// player.getInventory().remove(308);
	// player.getInventory().remove(309);
	// player.getInventory().remove(310);
	// player.getInventory().remove(311);
	// player.getInventory().remove(312);
	// player.getInventory().remove(313);
	// player.getInventory().remove(314);
	// player.getInventory().remove(315);
	// player.getInventory().remove(316);
	// player.getInventory().remove(317);
	// player.getInventory().remove(318);
	// player.getInventory().remove(319);
	// player.getInventory().remove(320);
	// player.getInventory().remove(321);
	// player.getInventory().remove(322);
	// player.getInventory().remove(323);
	// player.getInventory().remove(324);
	// player.getInventory().remove(325);
	// player.getInventory().remove(326);
	// player.getInventory().remove(327);
	// player.getInventory().remove(328);
	// player.getInventory().remove(329);
	// player.getInventory().remove(330);
	// player.getInventory().remove(331);
	// player.getInventory().remove(332);
	// player.getInventory().remove(333);
	// player.getInventory().remove(334);
	// player.getInventory().remove(335);
	// player.getInventory().remove(336);
	// player.getInventory().remove(337);
	// player.getInventory().remove(338);
	// player.getInventory().remove(339);
	// player.getInventory().remove(340);
	// player.getInventory().remove(341);
	// player.getInventory().remove(342);
	// player.getInventory().remove(343);
	// player.getInventory().remove(344);
	// player.getInventory().remove(345);
	// player.getInventory().remove(346);
	// player.getInventory().remove(347);
	// player.getInventory().remove(348);
	// player.getInventory().remove(349);
	// player.getInventory().remove(350);
	// player.getInventory().remove(351);
	// player.getInventory().remove(352);
	// player.getInventory().remove(353);
	// player.getInventory().remove(354);
	// player.getInventory().remove(355);
	// player.getInventory().remove(356);
	// player.getInventory().remove(357);
	// player.getInventory().remove(358);
	// player.getInventory().remove(359);
	// player.getInventory().remove(360);
	// player.getInventory().remove(361);
	// player.getInventory().remove(362);
	// player.getInventory().remove(363);
	// player.getInventory().remove(364);
	// player.getInventory().remove(365);
	// player.getInventory().remove(366);
	// player.getInventory().remove(367);
	// player.getInventory().remove(368);
	// player.getInventory().remove(369);
	// player.getInventory().remove(370);
	// player.getInventory().remove(371);
	// player.getInventory().remove(372);
	// player.getInventory().remove(373);
	// player.getInventory().remove(374);
	// player.getInventory().remove(375);
	// player.getInventory().remove(376);
	// player.getInventory().remove(377);
	// player.getInventory().remove(378);
	// player.getInventory().remove(379);
	// player.getInventory().remove(380);
	// player.getInventory().remove(381);
	// player.getInventory().remove(382);
	// player.getInventory().remove(383);
	// player.getInventory().remove(384);
	// player.getInventory().remove(385);
	// player.getInventory().remove(386);
	// player.getInventory().remove(387);
	// player.getInventory().remove(388);
	// player.getInventory().remove(389);
	// player.getInventory().remove(390);
	// player.getInventory().remove(391);
	// player.getInventory().remove(392);
	// player.getInventory().remove(393);
	// player.getInventory().remove(394);
	// player.getInventory().remove(395);
	// player.getInventory().remove(396);
	// player.getInventory().remove(397);
	// player.getInventory().remove(398);
	// player.getInventory().remove(399);
	// player.getInventory().remove(400);
	// player.getInventory().remove(401);
	// player.getInventory().remove(402);
	// player.getInventory().remove(403);
	// player.getInventory().remove(404);
	// player.getInventory().remove(405);
	// player.getInventory().remove(406);
	// player.getInventory().remove(407);
	// player.getInventory().remove(408);
	// player.getInventory().remove(409);
	// player.getInventory().remove(410);
	// player.getInventory().remove(411);
	// player.getInventory().remove(412);
	// player.getInventory().remove(413);
	// player.getInventory().remove(414);
	// player.getInventory().remove(415);
	// player.getInventory().remove(416);
	// player.getInventory().remove(417);
	// player.getInventory().remove(418);
	// player.getInventory().remove(419);
	// player.getInventory().remove(420);
	// player.getInventory().remove(421);
	// player.getInventory().remove(422);
	// player.getInventory().remove(423);
	// player.getInventory().remove(424);
	// player.getInventory().remove(425);
	// player.getInventory().remove(426);
	// player.getInventory().remove(427);
	// player.getInventory().remove(428);
	// player.getInventory().remove(429);
	// player.getInventory().remove(430);
	// player.getInventory().remove(431);
	// player.getInventory().remove(2256);
	// player.getInventory().remove(2257);
	// player.getInventory().remove(2258);
	// player.getInventory().remove(2259);
	// player.getInventory().remove(2260);
	// player.getInventory().remove(2261);
	// player.getInventory().remove(2262);
	// player.getInventory().remove(2263);
	// player.getInventory().remove(2264);
	// player.getInventory().remove(2265);
	// player.getInventory().remove(2266);
	// player.getInventory().remove(2267);
	// ItemStack compass = new ItemStack(Material.COMPASS);
	// compass.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Right Click
	// To Open Menu");
	// player.getInventory().setItem(4, compass);
	// }
	//
	// @EventHandler
	// public void compassRightClick(PlayerInteractEvent event) {
	// Action a = event.getAction();
	// ItemStack is = event.getItem();
	//
	// if (a == Action.RIGHT_CLICK_AIR || is == null || is.getType() ==
	// Material.AIR)
	// return;
	// if (is.getType() == Material.COMPASS) {
	// if (is.hasItemMeta()) {
	// Player player = (Player) event.getPlayer();
	// Inventory inv = Bukkit.createInventory(null, 45, ChatColor.DARK_PURPLE +
	// "Teleport Selector");
	// ItemStack spawnItem = nameItem(Material.COMPASS, ChatColor.LIGHT_PURPLE +
	// "Teleport to Spawn!");
	// inv.setItem(22, spawnItem);
	// ItemStack Arena_Blue_Side = nameItem(Material.LAPIS_BLOCK,
	// ChatColor.BLUE + "Teleport to Blue side of Arena!");
	// inv.setItem(19, Arena_Blue_Side);
	// ItemStack Arena_Red_Side = nameItem(Material.REDSTONE_BLOCK,
	// ChatColor.RED + "Teleport to Red side of Arena!");
	// inv.setItem(25, Arena_Red_Side);
	// ItemStack Arena_Spectator = nameItem(Material.EMERALD_BLOCK,
	// ChatColor.DARK_GREEN + "Spectate the Arena!");
	// inv.setItem(4, Arena_Spectator);
	// ItemStack Out_of_spawn = nameItem(Material.HARD_CLAY,
	// ChatColor.LIGHT_PURPLE + "Teleport out of spawn!");
	// inv.setItem(40, Out_of_spawn);
	// player.openInventory(inv);
	//
	// }
	// }
	// }

	// tp1 0,0,0

	// inventoryClick1

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