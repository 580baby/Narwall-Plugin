package com.babyyt.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.babyyt.Main;

public class GlitchFix implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main core;

	public GlitchFix(Main main) {
		this.core = main;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("glitchfix")) {
			if (sender.hasPermission("narwall.glitchfix")) {
				Player player = (Player) sender;
				ItemStack itemInHand = player.getItemInHand();

				itemInHand.setDurability((short) 2000);

				sender.sendMessage(ChatColor.BLUE + "The item in your hand has been " + ChatColor.RED + "Glitch-Fixed");
			}
		}
		return false;

	}

}
