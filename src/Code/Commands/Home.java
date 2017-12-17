package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Home implements CommandExecutor {
	private Main core;

	public Home(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender.hasPermission("narwall.home")) {
			Player player = (Player) sender;
			if (args.length == 0) {
				try{
				int locxx = core.getConfig().getInt("." + player.getName() + "home" + ".x");
				int locyy = core.getConfig().getInt("." + player.getName() + "home" + ".y");
				int loczz = core.getConfig().getInt("." + player.getName() + "home" + ".z");
				String w = (String) core.getConfig().get("." + player.getName() + "home" + ".w");
				World www = core.getServer().getWorld(w);
				Location location = player.getLocation();
				location.setX(locxx);
				location.setY(locyy);
				location.setZ(loczz);
				location.setWorld(www);
				if (locxx == 0) {
					player.sendMessage(ChatColor.DARK_RED + "You do not have a home called 'home'!");
					return false;
				} else {
					player.teleport(location);
					player.sendMessage(ChatColor.DARK_GREEN + "You were teleported home!");

				}
				} catch(IllegalArgumentException iae){
					player.sendMessage(ChatColor.DARK_RED + "That is not a valid home!");
				}
			}

			if (args.length == 1) {
				try{
				int locx = core.getConfig().getInt("." + player.getName() + args[0] + ".x");
				int locy = core.getConfig().getInt("." + player.getName() + args[0] + ".y");
				int locz = core.getConfig().getInt("." + player.getName() + args[0] + ".z");
				String w = (String) core.getConfig().get("." + player.getName() + args[0] + ".w");
				World www = core.getServer().getWorld(w);
				Location location1 = player.getLocation();
				location1.setX(locx);
				location1.setY(locy);
				location1.setZ(locz);
				location1.setWorld(www);
				if (locx == 0) {
					player.sendMessage(ChatColor.DARK_RED + "That is not a valid home!");
					return false;
				} else {
					player.teleport(location1);
					player.sendMessage(ChatColor.DARK_GREEN + "You were teleported home!");

				}
				}catch(IllegalArgumentException iae){
					player.sendMessage(ChatColor.DARK_RED + "That is not a valid home!");
				}

			}
		}
		return false;
	}
}
