package Code.Commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import Code.Main;

public class Dev implements CommandExecutor, Listener {
	private Main core;

	public Dev(Main main) {
		this.core = main;
	}
	
	@EventHandler
	public void loginEvent(PlayerLoginEvent e) throws IllegalArgumentException, ClassNotFoundException, IOException {
		Player p = e.getPlayer();
		core.getInventory(p, p.getWorld().getName());
	}

	@EventHandler
	public void logoffEvent(PlayerQuitEvent e) throws IOException {
		Player p = e.getPlayer();
		core.saveInventory(p, p.getWorld().getName());
	}

	@EventHandler
	public void changeWorld(PlayerChangedWorldEvent e)
			throws IllegalArgumentException, ClassNotFoundException, IOException {
		Player p = e.getPlayer();
		core.saveInventory(p, e.getFrom().getName());
		p.getInventory().clear();
		core.getInventory(p, p.getWorld().getName());
	}

	public void onEnd() throws IOException {
		for (Player p : Bukkit.getOnlinePlayers())
			core.saveInventory(p, p.getWorld().getName());
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("dev")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("narwall.dev")) {
					if(core.listE().contains(sender)) {
						core.listE().remove(sender);
					} else if(!core.listE().contains(sender)) {
						core.listE().add((Player) sender);
					}
				}
			}
		}
		return false;
	}
}
