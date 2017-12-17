package Code.Commands;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;
import net.md_5.bungee.api.ChatColor;

public class World_Stuffs implements CommandExecutor {
	ArrayList<String> flist8 = new ArrayList<String>();
	private Main core;

	public World_Stuffs(Main main) {
		this.core = main;
	}

	@SuppressWarnings("static-access")
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (sender.hasPermission("narwall.world")) {
				if (cmd.getName().equalsIgnoreCase("world")) {
					File f = new File(core.getDataFolder() + File.separator + "worlds");
					File[] flist = f.listFiles();
					for (File u : flist) {
						WorldCreator wc = new WorldCreator(u.getName());
						wc.name(u.getName());
						Bukkit.getServer().createWorld(wc);
					}
					if (args.length >= 1) {
						if (!args[0].equalsIgnoreCase("list")) {
							if (!args[0].equalsIgnoreCase("create")) {
								String s = new String();
								for (int i = 0; i < args.length; i++) {
									if (i != 0) {
										s += " " + args[i];
									} else {
										s += args[i];
									}
								}
								if (core.getServer().getWorld(s) != null) {
									World w = core.getServer().getWorld(s);
									Location l = w.getSpawnLocation();
									p.teleport(l);
									p.sendMessage(ChatColor.DARK_PURPLE + "You been teleported to the spawn of "
											+ p.getWorld().getName());
								} else {
									sender.sendMessage(
											ChatColor.DARK_RED + "You cannot tp to a world that does not exist!");
								}
							}
						}
						if (args[0].equalsIgnoreCase("list")) {
							File f1 = new File(core.getDataFolder() + File.separator + "worlds");
							for (int i = 0; i < f1.listFiles().length; i++) {
								flist8.add(f1.listFiles()[i].getName());
							}
							p.sendMessage(ChatColor.GOLD + "The worlds on this server are: ");
							for (int q = 0; q < flist.length; q++) {
								p.sendMessage(ChatColor.RED + f1.listFiles()[q].getName());
							}
						}
					}
					if (args.length == 2) {
						if (args[0].equalsIgnoreCase("create")) {
							WorldCreator wc1 = WorldCreator
									.name(core.getDataFolder() + File.separator + "worlds" + File.separator + args[1])
									.environment(World.Environment.NORMAL);
							Bukkit.getServer().createWorld(wc1);
							p.sendMessage(ChatColor.GOLD + "World " + args[1] + " created!");
						} else if (args[0].equalsIgnoreCase("delete")) {
							File z = new File(core.getDataFolder() + File.separator + "worlds" + args[1]);
							World w = Bukkit.getServer().getWorld(args[1]);
							Chunk[] cs = w.getLoadedChunks();
							for (Chunk hj : cs) {
								Bukkit.getServer().getWorld(args[1]).unloadChunk(hj);
							}
							z.delete();
							p.sendMessage(ChatColor.GOLD + "World " + args[1] + " deleted!");
						}

					}

				}
			}
		}
		return false;
	}
}