package Code.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import Code.Main;

public class Milk implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Milk(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("milk")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.milk")) {
					Player player = (Player) sender;
					player.removePotionEffect(PotionEffectType.WITHER);
					player.removePotionEffect(PotionEffectType.ABSORPTION);
					player.removePotionEffect(PotionEffectType.BLINDNESS);
					player.removePotionEffect(PotionEffectType.CONFUSION);
					player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					player.removePotionEffect(PotionEffectType.FAST_DIGGING);
					player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					player.removePotionEffect(PotionEffectType.HARM);
					player.removePotionEffect(PotionEffectType.HEAL);
					player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
					player.removePotionEffect(PotionEffectType.HUNGER);
					player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					player.removePotionEffect(PotionEffectType.INVISIBILITY);
					player.removePotionEffect(PotionEffectType.JUMP);
					player.removePotionEffect(PotionEffectType.LEVITATION);
					player.removePotionEffect(PotionEffectType.GLOWING);
					player.removePotionEffect(PotionEffectType.UNLUCK);
					player.removePotionEffect(PotionEffectType.LUCK);
					player.removePotionEffect(PotionEffectType.NIGHT_VISION);
					player.removePotionEffect(PotionEffectType.POISON);
					player.removePotionEffect(PotionEffectType.REGENERATION);
					player.removePotionEffect(PotionEffectType.SATURATION);
					player.removePotionEffect(PotionEffectType.SLOW);
					player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
					player.removePotionEffect(PotionEffectType.SPEED);
					player.removePotionEffect(PotionEffectType.WATER_BREATHING);
					player.removePotionEffect(PotionEffectType.WEAKNESS);
					player.sendMessage(org.bukkit.ChatColor.BLUE + "All" + org.bukkit.ChatColor.RED + " Potion effects "
							+ org.bukkit.ChatColor.BLUE + "Cleared.");
				}
			}
		}
		return false;
	}
}
