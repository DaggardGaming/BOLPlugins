package com.bol;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BoLTestPlugin  extends JavaPlugin{
	
	public PluginManager pm = null;

	public void onEnable() {
		this.pm = this.getServer().getPluginManager();
		this.getCommand("soulbind").setExecutor(new CommandSoulbind(this));
		this.pm.registerEvents(new ListenerSoulbind(this), this);
	}
	

	public void onDisable() {
	}
}
