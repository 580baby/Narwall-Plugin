package Code.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Tpaccept implements CommandExecutor {
	private Main core;

	public Tpaccept(Main main) {
		this.core = main;

	}

	@SuppressWarnings({ "unused" })
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		Player player = (Player) sender;
		if (sender.hasPermission("narwall.tpa")) {
			if (core.getConfig().contains(player.getName() + ".tparequest")) {
				if (!((player.getName() + ".tparequest") == null)) {
					String player1 = core.getConfig().getString(player.getName() + ".tparequest");
					Player hp = core.getServer().getPlayer(player1);
					if (cmd.getName().equalsIgnoreCase("tpaccept")) {

						if (args.length == 0) {

							if (player == null) {

								player.sendMessage(ChatColor.DARK_RED + "That player is not online!");

								return true;
							} else {
								hp.teleport(player);
								player.sendMessage(ChatColor.GOLD + hp.getName() + " has been teleported to you!");
								hp.sendMessage(ChatColor.GOLD + "You have been teleported to " + player.getDisplayName()
										+ "!");

								core.getConfig().set(player.getName() + ".tparequest", null);

								core.saveConfig();

							}

						}
					}
				} else {
					player.sendMessage(ChatColor.DARK_RED + "You don't have an active request");

					return false;
				}
				System.out.println("work2");
				if (core.getConfig().contains(".tparequesthere" + player.getName())) {
					System.out.println("work1");
					if (args.length == 0) {

						if (player == null) {

							player.sendMessage(ChatColor.DARK_RED + "That player is not online!");

							return true;
						} else {
							String player1 = core.getConfig().getString(".tparequesthere" + player.getName());
							Player hp = core.getServer().getPlayer(player1);
							player.teleport(hp);
							player.sendMessage(ChatColor.GOLD + player.getName() + " has been teleported to you!");
							hp.sendMessage(ChatColor.GOLD + "You have been teleported to " + hp.getDisplayName() + "!");

							core.getConfig().set(".tparequesthere" + player.getName(), null);

							core.saveConfig();

						}

					}
				}
			}
		}
		return false;
	}
}
