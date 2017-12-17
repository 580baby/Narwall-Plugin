package Code.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;



public class Gamemode_creative implements CommandExecutor{
	@SuppressWarnings("unused")
	private Main core;

	public Gamemode_creative(Main main) {
		this.core = main;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		 if(cmd.getName().equalsIgnoreCase("gc")){
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if(sender.hasPermission("narwall.gc")){
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(org.bukkit.ChatColor.BLUE + "Gamemode set to " + org.bukkit.ChatColor.RED + "Creative");
					}
				}
			}
		
		return false;
	}
}
