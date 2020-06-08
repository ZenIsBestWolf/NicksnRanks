package me.zenisbestwolf.nicksnranks.listeners;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.zenisbestwolf.nicksnranks.Main;
import me.zenisbestwolf.nicksnranks.utilities.ChatUtility;
import me.zenisbestwolf.nicksnranks.utilities.RankUtility;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

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
		else e.setFormat(ChatUtility.chat(rank + "&r %s " + e.getMessage()));
	}
}
