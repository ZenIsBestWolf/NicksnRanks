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
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String uuid = player.getUniqueId().toString();
		String nickname = NickUtility.getNickname(uuid);
		if (!(nickname == null)) NickUtility.setNickname(event.getPlayer(), nickname);
		PlayerListUtility.update(player);
		event.setJoinMessage(ChatUtility.chat(player.getPlayerListName() + "&e joined the game"));
	}
}
