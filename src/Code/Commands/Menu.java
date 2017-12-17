package Code.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Code.Main;

public class Menu {
	@SuppressWarnings("unused")
	private Main core;

	public Menu(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender instanceof Player) {
			//Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("menu")) {
				if (args.length == 0) {

				} else {
					//p.
				}
			}
		}
		return false;
	}
}
