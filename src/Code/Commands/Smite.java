package Code.Commands;

import java.util.Collection;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import Code.Main;

public class Smite implements CommandExecutor {
	public Smite(Main main) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("smite")) {
			if (sender.hasPermission("narwall.smite")) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					Block b = p.getTargetBlock((Set<Material>) null, 100);
					Location l = b.getLocation();
					p.getWorld().strikeLightningEffect(l);
					Collection<Entity> ne = l.getWorld().getNearbyEntities(l, 2, 2, 2);
					for (Entity e : ne) {
						if (e.getType() == EntityType.DROPPED_ITEM) {
							e.remove();
						} else if (e instanceof LivingEntity) {
							if (!(e instanceof Player)) {
								e.setFireTicks(140);
								((LivingEntity) e).damage(7);
							}
						}
					}
				}
			}
		}
		return false;

	}
}
