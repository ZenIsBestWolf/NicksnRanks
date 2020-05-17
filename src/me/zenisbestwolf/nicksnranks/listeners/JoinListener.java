package me.zenisbestwolf.nicksnranks.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.zenisbestwolf.nicksnranks.Main;
import me.zenisbestwolf.nicksnranks.utilities.ChatUtility;
import me.zenisbestwolf.nicksnranks.utilities.NickUtility;
import me.zenisbestwolf.nicksnranks.utilities.PlayerListUtility;

public class JoinListener implements Listener {
	private static Main plugin;
	public JoinListener(Main plugin) {
		this.plugin = plugin;
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
