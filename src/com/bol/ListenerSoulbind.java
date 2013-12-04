package com.bol;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ListenerSoulbind implements Listener {

	BoLTestPlugin plugin;

	public ListenerSoulbind(BoLTestPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onInventoryMoveItem(InventoryMoveItemEvent e) {
		if (e.getItem().getItemMeta().hasLore())
			if (e.getItem().getItemMeta().getLore().contains("soulbound")){
				if (e.getInitiator().getHolder() instanceof Player) {
					((Player)e.getInitiator().getHolder()).sendMessage("That item is soulbound");
				}
				e.setCancelled(true);
			}
	}

	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getItemMeta().hasLore())
			if (e.getItemDrop().getItemStack().getItemMeta().getLore().contains("soulbound")){
				e.getPlayer().sendMessage("That item is soulbound");
				e.setCancelled(true);
			}
	}
}
