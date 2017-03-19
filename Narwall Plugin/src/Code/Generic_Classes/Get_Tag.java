package Generic_Classes;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Get_Tag {
	public static String getName(Player p) {
		String name;
		String pName;
		String rank;
		pName = p.getName();
		if (p.hasPermission("narwall.owner")) {
			pName = ChatColor.GOLD + "" + ChatColor.BOLD + pName;
			rank = ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Owner"
					+ ChatColor.DARK_GREEN + ChatColor.BOLD + "]";
		} else if (p.hasPermission("narwall.coowner")) {
			pName = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + pName;
			rank = ChatColor.YELLOW + "" + ChatColor.BOLD + "[" + ChatColor.BLUE + "" + ChatColor.BOLD + "Co-Owner"
					+ ChatColor.YELLOW + "" + ChatColor.BOLD + "]";
		} else if (p.hasPermission("narwall.dev")) {
			pName = ChatColor.DARK_RED + "" + ChatColor.BOLD + pName;
			rank = ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "Developer"
					+ ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "]";
			if (p.getUniqueId().toString().equals("f5c44026-85cb-4330-9bdd-242c8fe392ff")) {
				rank += ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_RED + "" + ChatColor.BOLD
						+ "Head Admin" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
			} else if (p.getUniqueId().toString().equals("74e7267c-15de-462f-9ce9-52127fe6a847")) {
				rank += ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_RED + "" + ChatColor.BOLD
						+ "Head Moderator" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
			}
		} else if (p.hasPermission("narwall.admin")) {
			pName = ChatColor.DARK_BLUE + "" + ChatColor.BOLD + pName;
			rank = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[" + ChatColor.BLUE + ChatColor.BOLD + "Admin"
					+ ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "]";
		} else if (p.hasPermission("narwall.moderator")) {
			pName = ChatColor.GREEN + pName;
			rank = ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[" + ChatColor.DARK_GREEN + "Moderator"
					+ ChatColor.DARK_BLUE + ChatColor.BOLD + "]";
		} else if(p.hasPermission("narwall.helper")){
			pName = ChatColor.LIGHT_PURPLE + pName;
			rank = ChatColor.LIGHT_PURPLE + "[" + ChatColor.GRAY + "Helper" + ChatColor.LIGHT_PURPLE + "]";
		} else {
			rank = ChatColor.GRAY + "[" + ChatColor.GREEN + "Newb" + ChatColor.GRAY + "]";
		}
		name = rank + " " + pName;
		return name;
	}
}
