package me.zenisbestwolf.nicksnranks.utilities;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankUtility {
	/*
	 * This function is for updating a player's rank. This will alert you with confirmation and update the database.
	 */
	public static void updateRank(CommandSender s, Player p, String n) {
		if (n.equalsIgnoreCase("")) {
			// TODO: Erase from the rank database.
			FileUtility.removeData("ranks", p.getUniqueId().toString());
			PlayerListUtility.update(p);
			s.sendMessage("Rank erased for " + p.getName() + ".");
		} else {
			// TODO: Check if user is in the rank database, if so, update, otherwise create an entry.
			FileUtility.writeData("ranks", p.getUniqueId().toString(), n);
			PlayerListUtility.update(p);
			s.sendMessage(ChatUtility.chat("Rank set to \"" + n + "&r\" for " + p.getName() + "."));
		}
	}
	/*
	 * This function is only meant for when a player joins the game! This will not update the database or alert you of confirmation!
	 */
	public static void setRank(Player p, String n) {
		p.setDisplayName(ChatUtility.chat(n + "&r"));
	}
	/*
	 * This function simply looks up and returns the rank of a given player.
	 */
	public static String getRank(String s) {
		String r = null;
		try {
			r = FileUtility.readData("ranks", s);
		} catch (Exception e) {}
		return r;
	}
}
