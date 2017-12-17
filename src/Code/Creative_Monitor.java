package Code;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Creative_Monitor implements Listener {
	public Creative_Monitor(Main main) {
	}
	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(p.getGameMode() == GameMode.CREATIVE){
			@SuppressWarnings("unused")
			InventoryAction a = e.getAction();
		}
	}
}
