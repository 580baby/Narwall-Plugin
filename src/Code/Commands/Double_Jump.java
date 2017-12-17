package Code.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Code.Main;
import net.md_5.bungee.api.ChatColor;

public class Double_Jump implements CommandExecutor, Listener {
	public Double_Jump(Main main) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("narwall.jump")) {
				if (cmd.getName().equalsIgnoreCase("jump")) {
					ItemStack stuff = new ItemStack(Material.FEATHER);
					ItemMeta im = stuff.getItemMeta();
					im.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Double jumper!");
					List<String> lore = new ArrayList<String>();
					lore.add(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Hold this item to double jump");
					im.setLore(lore);
					stuff.setItemMeta(im);
					p.getInventory().addItem(stuff);
				}
			}
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if (p.getGameMode().equals(GameMode.CREATIVE)
				&& p.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
			p.setAllowFlight(true);
		}
		try {
			if (p.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR && (!p.isFlying())
					&& p.getItemInHand().getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Double jumper!")
					&& p.getGameMode().equals(GameMode.CREATIVE)) {
				p.setAllowFlight(true);
			}
		} catch (NullPointerException ex) {

		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerToggleFligt(PlayerToggleFlightEvent event) {
		if (event.isFlying()) {
			try {
				Player p = event.getPlayer();
				if (p.getItemInHand().getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Double jumper!")) {
					event.setCancelled(true);
					p.setAllowFlight(false);
					p.setFlying(false);
					p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
				}
			} catch (NullPointerException ex) {

			}
		}

	}
}
