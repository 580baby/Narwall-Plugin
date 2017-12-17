package Code.Name_Tags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Code.Main;
import Code.Generic_Classes.Get_Rank;
import Code.Generic_Classes.Get_Tag;

public class Hello_Message implements Listener {
	private Main core;

	public Hello_Message(Main main) {
		this.core = main;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		String name;
		String rank;
		String tag;
		Player p = e.getPlayer();
		name = p.getName();
		rank = Get_Rank.getRank(p);
		tag = Get_Tag.getTag(p);
		String welcomeMessage = ChatColor.translateAlternateColorCodes('&',
				core.getConfig().getString("Welcome Message"));
		String welcomeMessage2 = ChatColor.translateAlternateColorCodes('&',
				core.getConfig().getString("Welcome Message2"));
		e.setJoinMessage(null);
		core.getServer().broadcastMessage("");
		core.getServer().broadcastMessage(welcomeMessage + " " + rank + tag + " " + name + " " + welcomeMessage2);
		core.getServer().broadcastMessage("");

	}
}
