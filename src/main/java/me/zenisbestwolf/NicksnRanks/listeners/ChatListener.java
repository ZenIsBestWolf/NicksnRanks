package me.zenisbestwolf.NicksnRanks.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.zenisbestwolf.NicksnRanks.Main;
import me.zenisbestwolf.NicksnRanks.Utilities.ChatUtility;
import me.zenisbestwolf.NicksnRanks.Utilities.RankUtility;

public class ChatListener implements Listener {
	private static Main plugin;
	
	public ChatListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		String rank = RankUtility.getRank(e.getPlayer().getUniqueId().toString());
		if (rank == null) e.setFormat(ChatUtility.chat("<%s> " + e.getMessage()));
		else e.setFormat(ChatUtility.chat(rank + "&r <%s> " + e.getMessage()));
	}
}
