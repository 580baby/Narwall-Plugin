package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import Code.Main;

public class Kill_all implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public Kill_all(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ka")) {
				if (sender.hasPermission("narwall.ka")) {
					Player player = (Player) sender;
					World world = player.getWorld();
					player.sendMessage(ChatColor.DARK_RED + "All Entities Died");
					for (Entity e : world.getEntities()) {
						if (e.getType() != EntityType.PLAYER) {
							if (e.getType() != EntityType.MINECART) {
								if (e.getType() != EntityType.ARMOR_STAND) {
									if (e.getType() != EntityType.ITEM_FRAME) {
										if (e.getType() != EntityType.BOAT) {
											if (e.getType() != EntityType.CHICKEN) {
												if (e.getType() != EntityType.COW) {
													if (e.getType() != EntityType.SHEEP) {
														if (e.getType() != EntityType.VILLAGER) {
															if (e.getType() != EntityType.HORSE) {
																if (e.getType() != EntityType.ENDERMITE) {
																	if (e.getType() != EntityType.MINECART_HOPPER) {
																		e.remove();
																	}
																}
															}
														}
													}

												}
											}
										}
									}

								}
							}
						}
					}
				}
			
		}
		return false;
	}

}
