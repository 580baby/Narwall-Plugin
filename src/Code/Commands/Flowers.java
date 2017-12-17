package Code.Commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Player;

import Code.Main;
import net.md_5.bungee.api.ChatColor;



public class Flowers implements CommandExecutor{
	@SuppressWarnings("unused")
	private Main core;

	public Flowers(Main main) {
		this.core = main;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("flowers")) {
			if (sender instanceof Player) {
				if(sender.hasPermission("narwall.flowers")){
				Player player = (Player) sender;
				World world = player.getWorld();
				for (int i = 0; i < 100; i++) {
					Blaze b = (Blaze) world.spawn(player.getLocation(), Blaze.class);
					b.setCustomName(ChatColor.DARK_PURPLE + "Blaze " + ChatColor.DARK_RED + "#" + i);
				}
				player.sendMessage(org.bukkit.ChatColor.BLUE + "The Flower King (Woofless) has been summoned");
				}
			}
		}

		return false;
	}
}
