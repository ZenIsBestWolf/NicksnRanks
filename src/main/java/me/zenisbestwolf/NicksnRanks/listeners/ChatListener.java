package me.zenisbestwolf.NicksnRanks.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.zenisbestwolf.NicksnRanks.Main;
import me.zenisbestwolf.NicksnRanks.utilities.ChatUtility;
import me.zenisbestwolf.NicksnRanks.utilities.RankUtility;

public class ChatListener implements Listener {
	public ChatListener(Main plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		String rank = RankUtility.getRank(e.getPlayer().getUniqueId().toString());
		if (rank == null) e.setFormat(ChatUtility.chat("<%s> " + e.getMessage()));
		else e.setFormat(ChatUtility.chat(rank + "&r <%s> " + e.getMessage()));
	}
}
