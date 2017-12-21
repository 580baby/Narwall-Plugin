package Code.Commands;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.scheduler.BukkitScheduler;

import Code.Main;

public class Tpa implements CommandExecutor, Plugin {
	private Main core;

	public Tpa(Main main) {
		this.core = main;
	}

	@SuppressWarnings({})
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tpa")) {
			if (sender.hasPermission("narwall.tpa")) {
				Player player = (Player) sender;
				if (args.length == 0) {
					player.sendMessage(ChatColor.DARK_RED + "Please specify a player!");
					return false;
				}
				if (args.length == 1) {
					Player hp = Bukkit.getServer().getPlayer(args[0]);
					if (hp instanceof Player) {

						hp.sendMessage(ChatColor.BLUE + player.getDisplayName()
								+ " has sent you a tp reqest to you. Do /tpaccept to allow them to tp to you. This will expire in 60 seconds!");
						core.getConfig().set(hp.getName() + ".tparequest", player.getName());
						core.saveConfig();
						player.sendMessage(ChatColor.BLUE + "Your request has been sent to " + hp.getDisplayName()
								+ ". They have 60 seconds to accept it.");
						BukkitScheduler scheduler = core.getServer().getScheduler();
						scheduler.scheduleSyncDelayedTask(this.core, new Runnable() {
							@Override
							public void run() {
								core.getConfig().set(player.getName() + ".tparequest", null);
								core.saveConfig();
							}
						}, 1200L);
					} else {
						player.sendMessage(ChatColor.DARK_RED + "That's not a player!");
						return true;
					}

				} else if (cmd.getName().equalsIgnoreCase("tpahere")) {
					Player player1 = (Player) sender;
					if (args.length == 0) {
						player1.sendMessage(ChatColor.DARK_RED + "Please specify a player!");
						return false;
					}
					if (args.length == 1) {
						Player hp = Bukkit.getServer().getPlayer(args[0]);
						if (hp instanceof Player) {

							hp.sendMessage(ChatColor.BLUE + player1.getDisplayName() + " has sent you a"
									+ ChatColor.GREEN + " tpahere " + ChatColor.BLUE + "reqest to you. Do /tpaccept to"
									+ ChatColor.GREEN + " tp to THEM. " + ChatColor.BLUE
									+ "This will expire in 60 seconds!");
							core.getConfig().set(".tparequesthere" + hp.getName(), player1.getName());
							core.saveConfig();
							player1.sendMessage(ChatColor.BLUE + "Your request has been sent to " + hp.getDisplayName()
									+ ". They have 60 seconds to accept it.");
							BukkitScheduler scheduler = core.getServer().getScheduler();
							scheduler.scheduleSyncDelayedTask(this.core, new Runnable() {
								@Override
								public void run() {
									core.getConfig().set(".tparequesthere" + hp.getName(), null);
									core.saveConfig();
								}
							}, 1200L);
						} else {
							player1.sendMessage(ChatColor.DARK_RED + "That's not a player!");
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileConfiguration getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getDataFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginDescriptionFile getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginLoader getPluginLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getResource(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNaggable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reloadConfig() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveConfig() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveDefaultConfig() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveResource(String arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNaggable(boolean arg0) {
		// TODO Auto-generated method stub

	}

}