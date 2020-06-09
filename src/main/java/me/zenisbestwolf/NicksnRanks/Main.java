package me.zenisbestwolf.NicksnRanks;

import org.bukkit.plugin.java.JavaPlugin;

import me.zenisbestwolf.NicksnRanks.Commands.*;
import me.zenisbestwolf.NicksnRanks.Listeners.*;

public class Main extends JavaPlugin{
	public void onEnable() {
		new NickCommand(this);
		new RankCommand(this);
		new ChatListener(this);
		new JoinListener(this);
		new LeaveListener(this);
	}
}
