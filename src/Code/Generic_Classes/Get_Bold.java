package Code.Generic_Classes;

import org.bukkit.entity.Player;

public class Get_Bold {
	public static boolean getBold(Player p) {
		boolean b;
		if (p.hasPermission("narwall.owner")) {
			b = true;
		} else if (p.hasPermission("narwall.coowner")) {
			b = true;
		} else if (p.hasPermission("narwall.dev")) {
			b = true;
		} else if (p.hasPermission("narwall.admin")) {
			b = true;
		} else if (p.hasPermission("narwall.moderator")) {
			b = true;
		} else if (p.hasPermission("narwall.helper")) {
			b = true;
		} else {
			b = false;
		}
		
		return b;
	}
}
