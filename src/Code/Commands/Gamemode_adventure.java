package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;



public class Gamemode_adventure implements CommandExecutor{
	@SuppressWarnings("unused")
	private Main core;

	public Gamemode_adventure(Main main) {
		this.core = main;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		  if(cmd.getName().equalsIgnoreCase("ga")){
				if (sender instanceof Player) {
					if(sender.hasPermission("narwall.ga")){
					Player player = (Player) sender;
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(org.bukkit.ChatColor.BLUE + "Gamemode set to " + ChatColor.RED + "Adventure");
					}
				}
			}
		
		return false;
	}

}
