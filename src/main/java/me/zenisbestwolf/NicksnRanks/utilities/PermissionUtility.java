package me.zenisbestwolf.NicksnRanks.utilities;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissionUtility {
	public static boolean checkPermission(String p, CommandSender s, boolean iS) {
		if (s.hasPermission("nicksnranks.*")) return true;
		if (s.hasPermission("nicksnranks." + p + ".*")) return true;
		if (s.hasPermission("nicksnranks." + p + ".self") && iS) return true;
		if (s.hasPermission("nicksnranks." + p + ".others") && !iS) return true;
		return false;
	}
	public static boolean isSelf(String[] args, CommandSender s) {
		boolean isSelf = false;
		if ((args.length == 0 && s instanceof Player) || (args.length > 0 && Bukkit.getPlayer(args[0]) == null && s instanceof Player) || (s instanceof Player && (s.getName().equalsIgnoreCase(Bukkit.getPlayer(args[0]).getName())))) isSelf = true;
		return isSelf;
	}
}
