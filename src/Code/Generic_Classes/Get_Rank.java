package Code.Generic_Classes;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Get_Rank {
	public static String getRank(Player p) {
		String rank;
		if (p.hasPermission("narwall.owner")) {
			rank = ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Owner"
					+ ChatColor.DARK_GREEN + ChatColor.BOLD + "]" + ChatColor.GOLD + "" + ChatColor.BOLD;
		} else if (p.hasPermission("narwall.coowner")) {
			rank = ChatColor.YELLOW + "" + ChatColor.BOLD + "[" + ChatColor.BLUE + "" + ChatColor.BOLD + "Co-Owner"
					+ ChatColor.YELLOW + "" + ChatColor.BOLD + "]" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD;
		} else if (p.hasPermission("narwall.dev")) {
			rank = ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "Developer"
					+ ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "]" + ChatColor.DARK_RED + "" + ChatColor.BOLD;
		} else if (p.hasPermission("narwall.admin")) {
			rank = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[" + ChatColor.BLUE + ChatColor.BOLD + "Admin"
					+ ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "]" + ChatColor.DARK_BLUE + "" + ChatColor.BOLD;
		} else if (p.hasPermission("narwall.moderator")) {
			rank = ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[" + ChatColor.DARK_GREEN + "Moderator"
					+ ChatColor.DARK_BLUE + ChatColor.BOLD + "]" + ChatColor.GREEN;
		} else if (p.hasPermission("narwall.helper")) {
			rank = ChatColor.LIGHT_PURPLE + "[" + ChatColor.GREEN + "Helper" + ChatColor.LIGHT_PURPLE + "]" + ChatColor.LIGHT_PURPLE;
		} else {
			rank = ChatColor.GRAY + "[" + ChatColor.WHITE + "Newb" + ChatColor.GRAY + "]";
		}
		return rank;
	}
}
