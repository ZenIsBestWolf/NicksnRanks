package me.zenisbestwolf.NicksnRanks.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.zenisbestwolf.NicksnRanks.Main;
import me.zenisbestwolf.NicksnRanks.utilities.NickUtility;
import me.zenisbestwolf.NicksnRanks.utilities.PermissionUtility;

public class NickCommand implements CommandExecutor {
	public NickCommand(Main plugin) {
		plugin.getCommand("nickname").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		boolean isSelf = PermissionUtility.isSelf(args, sender);
		if (!PermissionUtility.checkPermission("nickname", sender, isSelf)) {
			sender.sendMessage("You do not have permission to execute this command.");
			return false;
		}
		boolean isLong = (isSelf && (!(args.length == 0) && sender instanceof Player && ((Player) sender == Bukkit.getPlayer(args[0]))));
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

		for (int i = (isSelf && !isLong) ? 0 : 1; i < args.length; i++) {
			nickname+=args[i];
			if (i != args.length-1) nickname+=" ";
		}
		NickUtility.updateNickname(sender, target, nickname);
		return true;
	}
}
