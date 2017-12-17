package Code.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import Code.Main;

public class Enchantment1 implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Enchantment1(Main main) {
		this.core = main;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		Player player = (Player) sender;
		if (player.hasPermission("narwall.enchantment")) {
			if (cmd.getName().equalsIgnoreCase("enchantment"))
				if (sender instanceof Player)
					if (sender.hasPermission("narwall.enchantment") || sender.hasPermission("narwall.*")) {
						if (args.length == 2) {
							if (args[0].equalsIgnoreCase("frostwalker") || args[0].equalsIgnoreCase("frost_walker")) {
								int h = Integer.parseInt(args[1]);
								player.getItemInHand().addUnsafeEnchantment(Enchantment.FROST_WALKER, h);
								player.sendMessage(ChatColor.GOLD + "Enchanment Frost Walker added!");
							} else if (args[0].equalsIgnoreCase("looting")) {
								String g = args[1];
								int h = Integer.parseInt(g);
								player.getItemInHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, h);
							}

						} else if (args.length == 3) {
							Player t = Bukkit.getServer().getPlayer(args[0]);
							if (args[1] == "frostwalker" || args[1] == "frost_walker") {
								int h = Integer.parseInt(args[2]);
								t.getItemInHand().addUnsafeEnchantment(Enchantment.FROST_WALKER, h);
							} else if (args[0].equalsIgnoreCase("looting")) {
								String g = args[2];
								int h = Integer.parseInt(g);
								t.getItemInHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, h);
							}
						}
					}
		}
		return false;
	}
}