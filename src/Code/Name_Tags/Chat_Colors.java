package Code.Name_Tags;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Code.Main;
import Code.Generic_Classes.Get_Bold;
import Code.Generic_Classes.Get_ChatColor;
import Code.Generic_Classes.Get_Rank;
import Code.Generic_Classes.Get_Tag;

public class Chat_Colors implements Listener {

	public Chat_Colors(Main main) {
	}

	@EventHandler
	public void chatEvent(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String words = e.getMessage();
		String name = p.getName();
		String rank = Get_Rank.getRank(p);
		String tag = Get_Tag.getTag(p);
		boolean b = Get_Bold.getBold(p);
		ChatColor color = Get_ChatColor.getChatColor(p);
		if(b == true)
		Bukkit.getServer().broadcastMessage(rank + tag + " " + name + " " + color + ChatColor.BOLD + words);
		if(b == false)
		Bukkit.getServer().broadcastMessage(rank + tag + " " + name + " " + color + words);
		e.setCancelled(true);
		
	}
}
