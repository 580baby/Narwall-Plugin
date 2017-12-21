package SetPoints;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Code.Main;

public class SetPoints implements Listener {
	private Main core;

	public SetPoints(Main main) {
	this.core = main;
	}



	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		boolean b =  (boolean) core.getConfig().contains("." + event.getPlayer().getName() + ".points");
		if(b == true) {
			int i = 0;
			core.getConfig().set("." + event.getPlayer().getName() + ".points", i);
			core.saveConfig();
		}
	}
}
