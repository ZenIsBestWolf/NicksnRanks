package me.zenisbestwolf.nicksnranks;

import org.bukkit.plugin.java.JavaPlugin;

import me.zenisbestwolf.nicksnranks.commands.*;
import me.zenisbestwolf.nicksnranks.listeners.*;

public class Main extends JavaPlugin{
	public void onEnable() {
		new NickCommand(this);
		new RankCommand(this);
		new ChatListener(this);
		new JoinListener(this);
		new LeaveListener(this);
	}
}
