package me.zenisbestwolf.NicksnRanks.utilities;

import org.bukkit.entity.Player;

public class PlayerListUtility {
	public static void update(Player player) {
		String uuid = player.getUniqueId().toString();
		String rank = RankUtility.getRank(uuid);
		String nickname = NickUtility.getNickname(uuid);
		String rankProcessed = "";
		if (!(rank == null)) rankProcessed += rank + " &r";
		if (!(nickname == null)) rankProcessed+=nickname;
		else rankProcessed += player.getName();
		player.setPlayerListName(ChatUtility.chat(rankProcessed + "&r"));
	}
}