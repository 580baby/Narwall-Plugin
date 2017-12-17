package Code.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import Code.Main;

public class npc implements CommandExecutor, Listener {
	@SuppressWarnings("unused")
	private Main core;

	public npc(Main main) {
		this.core = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		return false;/*
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("narwall.npc")) {
				if (args.length == 1) {
					MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
					WorldServer nmsWorld = ((CraftWorld) Bukkit.getWorlds().get(0)).getHandle();
					EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, new GameProfile(UUID.fromString(args[0]), p.getName()),
							new PlayerInteractManager(nmsWorld));
					npc.setLocation(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 0.0F, 0.0F);
					PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
					connection.sendPacket(new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, npc));
					connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
				} else if (args.length > 2) {
					p.sendMessage(ChatColor.DARK_BLUE + "Too many Arguments!");
				} else if (args.length < 2) {
					p.sendMessage(ChatColor.DARK_BLUE + "Too Little Arguments!");
				}
			} else {
				p.sendMessage(ChatColor.DARK_RED + "You don't habe Permission!");
			}
		*/}

	}


