package Code.Generic_Classes;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Get_ChatColor {
	public static ChatColor getChatColor(Player p) {
		ChatColor c;
		if (p.hasPermission("narwall.owner")) {
			c = ChatColor.DARK_PURPLE;
		} else if (p.hasPermission("narwall.coowner")) {
			c = ChatColor.AQUA;
		} else if (p.hasPermission("narwall.dev")) {
			c = ChatColor.GOLD;
		} else if (p.hasPermission("narwall.admin")) {
			c = ChatColor.DARK_BLUE;
		} else if (p.hasPermission("narwall.moderator")) {
			c = ChatColor.GREEN;
		} else if (p.hasPermission("narwall.helper")) {
			c = ChatColor.GRAY;
		} else {
			c = null;
		}
		return c;
	}
}
