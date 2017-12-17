package Code;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class Health_Indecator implements Listener, CommandExecutor {

	@SuppressWarnings("unused")
	private Main core;

	public Health_Indecator(Main main) {
		this.core = main;
	}

	public static final Logger LOG = Logger.getLogger("Minecraft");
	private boolean display = true;
	// private boolean display = core.getConfig().getBoolean("health_display");
	private static int SCALE = 20;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("healthcheck")) {
				if (args.length == 0) {
					if (args[0].equalsIgnoreCase("on")) {
						display = true;
					}
					if (args[0].equalsIgnoreCase("off")) {
						display = false;
					}
				}
				return true;
			}
		}
		return false;
	}

	// display a mob's current health
	public void showHealth(LivingEntity entity) {
		if (!display) {
			return;
		}
		@SuppressWarnings("deprecation")
		int maxHealth = (int) entity.getMaxHealth();
		int currentHealth = (int) entity.getHealth();
		String entityName = entity.getType().toString();
		String text = makeBarGraph(currentHealth, maxHealth, entityName);
		entity.setCustomName(text);
	}

	// make the health bar graph (x=current, y=maximum
	public String makeBarGraph(int x, int y, String prefix) {
		SCALE = y;
		int percent = (int) ((x / (float) y) * SCALE);
		StringBuilder output = new StringBuilder(12 + SCALE + prefix.length());
		output.append(ChatColor.WHITE);
		output.append(prefix);
		output.append(": [");
		output.append(ChatColor.GREEN);
		if (percent > 0) {
			// show bars in graph
			for (int i = 0; i < (percent); i++) {
				output.append("â�¤");
			}
		}
		output.append(ChatColor.RED);
		if (percent < SCALE) {
			// show bars in graph
			for (int i = 0; i < (SCALE - percent); i++) {
				output.append("â�¤");
			}
		}
		output.append(ChatColor.WHITE);
		output.append("]");
		return output.toString();
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof LivingEntity) {
			if(event.getEntity().getCustomName().contains("â�¤")){
				LivingEntity entity = (LivingEntity) event.getEntity();
				showHealth(entity);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void stuff(EntitySpawnEvent event) {
		if (event.getEntity() instanceof LivingEntity) {
			if (event.getEntity().getCustomName() == null) {
				LivingEntity le = (LivingEntity) event.getEntity();
				SCALE = (int) le.getMaxHealth();
				LivingEntity entity = (LivingEntity) event.getEntity();
				showHealth(entity);
			}
		}
	}
}