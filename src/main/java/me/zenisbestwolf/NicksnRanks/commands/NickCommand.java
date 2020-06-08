package me.zenisbestwolf.nicksnranks.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.zenisbestwolf.nicksnranks.Main;
import me.zenisbestwolf.nicksnranks.utilities.NickUtility;
import me.zenisbestwolf.nicksnranks.utilities.PermissionUtility;

public class NickCommand implements CommandExecutor {
	private static Main plugin;
	
	public NickCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("nickname").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		boolean isSelf = PermissionUtility.isSelf(args, sender);
		boolean isLong = false;
		if (isSelf && (!(args.length == 0) && sender instanceof Player && ((Player) sender == Bukkit.getPlayer(args[0])))) isLong = true;
		if (PermissionUtility.checkPermission("nickname", sender, isSelf)) {
			Player target;
			String nickname = "";
			if (isSelf) target = (Player) sender;
			else if (args.length == 0 && !(sender instanceof Player)) {
				sender.sendMessage("Error: please specify a player.");
				return true;
			}
			else target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage("Error: Could not find a player named \"" + args[0] + "\".");
				return true;
			}
			int i;
			if (isSelf && !isLong) i = 0;
			else i=1;
			while (i < args.length) {
				nickname+=args[i];
				if (i != args.length-1) nickname+=" ";
				i++;
			}
			NickUtility.updateNickname(sender, target, nickname);
			return true;
		}
		else sender.sendMessage("You do not have permission to execute this command.");
		return false;
	}
}
