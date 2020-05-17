package me.zenisbestwolf.nicksnranks.utilities;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickUtility {
	/*
	 * This function is for updating a player's nickname. This will alert you with confirmation and update the database.
	 */
	public static void updateNickname(CommandSender s, Player p, String n) {
		if (n.equalsIgnoreCase("")) {
			p.setDisplayName(p.getName());
			// TODO: Erase from the nickname database.
			FileUtility.removeData("nicknames", p.getUniqueId().toString());
			PlayerListUtility.update(p);
			s.sendMessage("Nickname disabled for " + p.getName() + ".");
		} else {
			p.setDisplayName(ChatUtility.chat(n + "&r"));
			// TODO: Check if user is in the nickname database, if so, update, otherwise create an entry.
			FileUtility.writeData("nicknames", p.getUniqueId().toString(), n);
			PlayerListUtility.update(p);
			s.sendMessage(ChatUtility.chat("Nickname set to \"" + n + "&r\" for " + p.getName() + "."));
		}
	}
	/*
	 * This function is only meant for when a player joins the game! This will not update the database or alert you of confirmation!
	 */
	public static void setNickname(Player p, String n) {
		p.setDisplayName(ChatUtility.chat(n + "&r"));
	}
	/*
	 * This function simply looks up and returns the nickname of a given player.
	 */
	public static String getNickname(String s) {
		String r = null;
		try {
			r = FileUtility.readData("nicknames", s);
		} catch (Exception e) {}
		return r;
	}
}
