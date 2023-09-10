package me.zenisbestwolf.NicksnRanks.utilities;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankUtility {
	/*
	 * This function is for updating a player's rank. This will alert you with confirmation and update the database.
	 */
	public static void updateRank(CommandSender sender, Player player, String rank) {
		if (rank.equalsIgnoreCase("")) {
			FileUtility.removeData("ranks", player.getUniqueId().toString());
			PlayerListUtility.update(player);
			sender.sendMessage("Rank erased for " + player.getName() + ".");
		} else {
			FileUtility.writeData("ranks", player.getUniqueId().toString(), rank);
			PlayerListUtility.update(player);
			sender.sendMessage(ChatUtility.chat("Rank set to \"" + rank + "&r\" for " + player.getName() + "."));
		}
	}
	/*
	 * This function is only meant for when a player joins the game! This will not update the database or alert you of confirmation!
	 */
	public static void setRank(Player player, String n) {
		player.setDisplayName(ChatUtility.chat(n + "&r"));
	}
	/*
	 * This function simply looks up and returns the rank of a given player.
	 */
	public static String getRank(String playerName) {
		String r = null;
		try {
			r = FileUtility.readData("ranks", playerName);
		} catch (Exception e) {}
		return r;
	}
}
