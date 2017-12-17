package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Code.Main;

public class Fix implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Fix(Main main) {
		this.core = main;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fix")) {
			if (sender.hasPermission("narwall.fix")) {
				Player player = (Player) sender;
				ItemStack itemInHand = player.getItemInHand();
				itemInHand.setDurability((short) 0);
				sender.sendMessage(ChatColor.BLUE + "The item in your hand has been " + ChatColor.RED + "Fixed");
			}
		}
		return false;
	}

}
