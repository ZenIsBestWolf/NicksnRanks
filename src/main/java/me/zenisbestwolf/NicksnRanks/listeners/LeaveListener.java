package me.zenisbestwolf.NicksnRanks.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.zenisbestwolf.NicksnRanks.Main;
import me.zenisbestwolf.NicksnRanks.utilities.ChatUtility;

public class LeaveListener implements Listener {
	public LeaveListener(Main plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		e.setQuitMessage(ChatUtility.chat(e.getPlayer().getPlayerListName() + "&e left the game"));
	}
}
