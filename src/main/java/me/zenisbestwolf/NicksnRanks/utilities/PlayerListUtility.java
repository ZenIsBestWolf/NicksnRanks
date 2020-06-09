package me.zenisbestwolf.NicksnRanks.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerListUtility {
	public static void update(Player p) {
		String u = p.getUniqueId().toString();
		String rank = RankUtility.getRank(u);
		String nickname = NickUtility.getNickname(u);
		String r = "";
		if (!(rank == null)) r+=rank + " &r";
		if (!(nickname == null)) r+=nickname;
		else r+=p.getName();
		p.setPlayerListName(ChatUtility.chat(r + "&r"));
	}
}