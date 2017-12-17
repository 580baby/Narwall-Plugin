package Code.Generic_Classes;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Get_Tag {
	public static String getTag(Player p) {
		String tag = null;
			if (p.getUniqueId().toString().equals("f5c44026-85cb-4330-9bdd-242c8fe392ff")) {
				tag = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_RED + "" + ChatColor.BOLD
						+ "Head Admin" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
			} else if (p.getUniqueId().toString().equals("74e7267c-15de-462f-9ce9-52127fe6a847")) {
				tag = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_RED + "" + ChatColor.BOLD
						+ "Head Moderator" + ChatColor.GOLD + "" + ChatColor.BOLD + "]";
			}
			if(tag != null)
				return tag;
				return "";
	}
}
