package me.zenisbestwolf.NicksnRanks.utilities;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickUtility {
	/*
	 * This function is for updating a player's nickname. This will alert you with confirmation and update the database.
	 */
	public static void updateNickname(CommandSender sender, Player player, String nickname) {
		if (nickname.equalsIgnoreCase("")) {
			player.setDisplayName(player.getName());
			FileUtility.removeData("nicknames", player.getUniqueId().toString());
			PlayerListUtility.update(player);
			sender.sendMessage("Nickname disabled for " + player.getName() + ".");
		} else {
			player.setDisplayName(ChatUtility.chat(nickname + "&r"));
			FileUtility.writeData("nicknames", player.getUniqueId().toString(), nickname);
			PlayerListUtility.update(player);
			sender.sendMessage(ChatUtility.chat("Nickname set to \"" + nickname + "&r\" for " + player.getName() + "."));
		}
	}
	/*
	 * This function is only meant for when a player joins the game! This will not update the database or alert you of confirmation!
	 */
	public static void setNickname(Player player, String nickname) {
		player.setDisplayName(ChatUtility.chat(nickname + "&r"));
	}
	/*
	 * This function simply looks up and returns the nickname of a given player.
	 */
	public static String getNickname(String playerName) {
		String r = null;
		try {
			r = FileUtility.readData("nicknames", playerName);
		} catch (Exception e) {}
		return r;
	}
}
