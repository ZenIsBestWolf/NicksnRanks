package me.zenisbestwolf.NicksnRanks.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.zenisbestwolf.NicksnRanks.Main;
import me.zenisbestwolf.NicksnRanks.utilities.ChatUtility;
import me.zenisbestwolf.NicksnRanks.utilities.NickUtility;
import me.zenisbestwolf.NicksnRanks.utilities.PlayerListUtility;

public class JoinListener implements Listener {
	public JoinListener(Main plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String u = p.getUniqueId().toString();
		String n = NickUtility.getNickname(u);
		if (!(n == null)) NickUtility.setNickname(e.getPlayer(), n);
		PlayerListUtility.update(p);
		e.setJoinMessage(ChatUtility.chat(p.getPlayerListName() + "&e joined the game"));
	}
}
