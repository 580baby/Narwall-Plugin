package Code.Name_Tags;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import Code.Main;
import Code.Generic_Classes.Get_ChatColor;
import Code.Generic_Classes.Get_Rank;
import Code.Generic_Classes.Get_Tag;

public class Tags implements Listener {

	public Tags(Main main) {
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		ScoreboardManager sbm = Bukkit.getScoreboardManager();
		Scoreboard s = sbm.getMainScoreboard();
		Team owner = null;
		Team coowner = null;
		Team dev = null;
		Team mod = null;
		Team helper = null;
		Team admin = null;
		Team newb = null;
		Player p = e.getPlayer();
		String rank = Get_Rank.getRank(p);
		String name = p.getName();
		String tag = Get_Tag.getTag(p);
		try {
			Method getHandle = p.getClass().getMethod("getHandle", (Class<?>[]) null);
			try {
				Class.forName("com.mojang.authlib.GameProfile");
				} catch (ClassNotFoundException e1) {
				}
				Object profile = getHandle.invoke(p).getClass().getMethod("getProfile")
					.invoke(getHandle.invoke(p));
				Field ff = profile.getClass().getDeclaredField("name");
				ff.setAccessible(true);
				ff.set(profile, Get_ChatColor.getChatColor(p) + name);
				name = p.getName();
				try {
					Class.forName("com.mojang.authlib.GameProfile");
				} catch (ClassNotFoundException e1) {
				}
				ff.setAccessible(true);
				ff.set(profile, name);
				for (Player players : Bukkit.getOnlinePlayers()) {
					players.hidePlayer(p);
					players.showPlayer(p);
				}
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException | NoSuchFieldException e1) {
						e1.printStackTrace();
				}
		p.setPlayerListName(rank + tag + " " + name);
		p.setDisplayName(rank + tag + " " + name);
		p.setCustomName(rank + tag + " " + name);
		if (ChatColor.stripColor(rank).equalsIgnoreCase("[owner]")) {
			try {
				if (s.getTeam("owner") == null)
					owner = s.registerNewTeam("owner");
				if (s.getTeam("owner") != null)
					owner = s.getTeam("owner");
			} catch (IllegalArgumentException e1) {
			}
			p.setScoreboard(s);
			owner.setPrefix(
					ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Owner" + " " + ChatColor.GOLD + ChatColor.BOLD);
			owner.addEntry(p.getName());
			Objective o = null;
			try {
				if (s.getObjective("teams") == null)
					o = s.registerNewObjective("teams", "dummy");
				if (s.getObjective("teams") != null)
					o = s.getObjective("teams");
				owner = s.getTeam("owner");
			} catch (IllegalArgumentException e1) {
			}
			o.getScore(p.getName()).setScore(0);
		} else if (ChatColor.stripColor(rank).equalsIgnoreCase("[co-owner]")) {
			try {
				if (s.getTeam("co-owner") == null)
					coowner = s.registerNewTeam("co-owner");
				if (s.getTeam("co-owner") != null)
					coowner = s.getTeam("co-owner");
			} catch (IllegalArgumentException e1) {
			}
			p.setScoreboard(s);
			coowner.setPrefix(
					ChatColor.BLUE + "" + ChatColor.BOLD + "Co-Owner" + " " + ChatColor.DARK_PURPLE + ChatColor.BOLD);
			coowner.addEntry(p.getName());
			Objective o = null;
			try {
				if (s.getObjective("teams") == null)
					o = s.registerNewObjective("teams", "dummy");
				if (s.getObjective("teams") != null)
					o = s.getObjective("teams");
				coowner = s.getTeam("co-owner");
			} catch (IllegalArgumentException e1) {
			}
			o.getScore(p.getName()).setScore(0);
		} else if (ChatColor.stripColor(rank).equalsIgnoreCase("[developer]")) {
			try {
				if (s.getTeam("dev") == null)
					dev = s.registerNewTeam("dev");
				if (s.getTeam("dev") != null)
					dev = s.getTeam("dev");
			} catch (IllegalArgumentException e1) {
			}
			p.setScoreboard(s);
			dev.setPrefix(
					ChatColor.DARK_RED + "" + ChatColor.BOLD + "Developer" + " ");
			dev.addEntry(p.getName());
			Objective o = null;
			try {
				if (s.getObjective("teams") == null)
					o = s.registerNewObjective("teams", "dummy");
				if (s.getObjective("teams") != null)
					o = s.getObjective("teams");
				dev = s.getTeam("dev");
			} catch (IllegalArgumentException e1) {
			}
			o.getScore(p.getName()).setScore(0);
		} else if (ChatColor.stripColor(rank).equalsIgnoreCase("[moderator]")) {
			try {
				if (s.getTeam("mod") == null)
					mod = s.registerNewTeam("mod");
				if (s.getTeam("mod") != null)
					mod = s.getTeam("mod");
			} catch (IllegalArgumentException e1) {
			}
			p.setScoreboard(s);
			mod.setPrefix(ChatColor.DARK_GREEN + "Moderator" + " " + ChatColor.GREEN);
			mod.addEntry(p.getName());
			Objective o = null;
			try {
				if (s.getObjective("teams") == null)
					o = s.registerNewObjective("teams", "dummy");
				if (s.getObjective("teams") != null)
					o = s.getObjective("teams");
				mod = s.getTeam("mod");
			} catch (IllegalArgumentException e1) {
			}
			o.getScore(p.getName()).setScore(0);
		} else if (ChatColor.stripColor(rank).equalsIgnoreCase("[admin]")) {
			try {
				if (s.getTeam("admin") == null)
					admin = s.registerNewTeam("admin");
				if (s.getTeam("admin") != null)
					admin = s.getTeam("admin");
			} catch (IllegalArgumentException e1) {
			}
			p.setScoreboard(s);
			admin.setPrefix(
					ChatColor.BLUE + "" + ChatColor.BOLD + "Admin" + ChatColor.DARK_BLUE + " " + ChatColor.BOLD);
			admin.addEntry(p.getName());
			Objective o = null;
			try {
				if (s.getObjective("teams") == null)
					o = s.registerNewObjective("teams", "dummy");
				if (s.getObjective("teams") != null)
					o = s.getObjective("teams");
				admin = s.getTeam("admin");
			} catch (IllegalArgumentException e1) {
			}
			o.getScore(p.getName()).setScore(0);
		} else if (ChatColor.stripColor(rank).equalsIgnoreCase("[helper]")) {
			try {
				if (s.getTeam("helper") == null)
					helper = s.registerNewTeam("helper");
				if (s.getTeam("helper") != null)
					helper = s.getTeam("helper");
			} catch (IllegalArgumentException e1) {
			}
			p.setScoreboard(s);
			helper.setPrefix(ChatColor.GREEN + "Helper" + " " + ChatColor.LIGHT_PURPLE);
			helper.addEntry(p.getName());
			Objective o = null;
			try {
				if (s.getObjective("teams") == null)
					o = s.registerNewObjective("teams", "dummy");
				if (s.getObjective("teams") != null)
					o = s.getObjective("teams");
				helper = s.getTeam("helper");
			} catch (IllegalArgumentException e1) {
			}
			o.getScore(p.getName()).setScore(0);
		} else if (ChatColor.stripColor(rank).equalsIgnoreCase("[newb]")) {
			try {
				if (s.getTeam("newb") == null)
					newb = s.registerNewTeam("newb");
				if (s.getTeam("newb") != null)
					newb = s.getTeam("newb");
			} catch (IllegalArgumentException e1) {
			}
			p.setScoreboard(s);
			newb.setPrefix(ChatColor.GRAY + "Newb" + " " + ChatColor.RESET);
			newb.addEntry(p.getName());
			Objective o = null;
			try {
				if (s.getObjective("teams") == null)
					o = s.registerNewObjective("teams", "dummy");
				if (s.getObjective("teams") != null)
					o = s.getObjective("teams");
				newb = s.getTeam("newb");
			} catch (IllegalArgumentException e1) {
			}
			o.getScore(p.getName()).setScore(0);
		}
	}
}
