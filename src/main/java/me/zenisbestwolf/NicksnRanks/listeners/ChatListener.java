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
	public void onChat(AsyncPlayerChatEvent event) {
		String rank = RankUtility.getRank(event.getPlayer().getUniqueId().toString());
		if (rank == null) event.setFormat(ChatUtility.chat("<%s> " + event.getMessage()));
		else event.setFormat(ChatUtility.chat(rank + "&r <%s> " + event.getMessage()));
	}
}
