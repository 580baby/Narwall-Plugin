package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Fast_fly implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Fast_fly(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fastfly")) {
			if (sender instanceof Player) {
				if(sender.hasPermission("narwall.fastfly")){
				Player player = (Player) sender;
				player.setFlySpeed(1);
				player.sendMessage(ChatColor.BLUE + "Fly speed set to" + ChatColor.RED + " Fast");
				}
			}
		}
		return false;
	}
}
