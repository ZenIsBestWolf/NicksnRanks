package me.zenisbestwolf.NicksnRanks.utilities;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissionUtility {
	public static boolean checkPermission(String command, CommandSender sender, boolean isTargetSelf) {
		if (sender.hasPermission("nicksnranks.*")) return true;
		if (sender.hasPermission("nicksnranks." + command + ".*")) return true;
		if (sender.hasPermission("nicksnranks." + command + ".self") && isTargetSelf) return true;
		if (sender.hasPermission("nicksnranks." + command + ".others") && !isTargetSelf) return true;
		return false;
	}

	public static boolean isSelf(String[] args, CommandSender s) {
		return ((args.length == 0 && s instanceof Player) || (args.length > 0 && Bukkit.getPlayer(args[0]) == null && s instanceof Player) || (s instanceof Player && (s.getName().equalsIgnoreCase(Bukkit.getPlayer(args[0]).getName()))));
	}
}
