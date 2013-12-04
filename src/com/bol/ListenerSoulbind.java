package com.bol;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ListenerSoulbind implements Listener {

	BoLTestPlugin plugin;

	public ListenerSoulbind(BoLTestPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onInventoryMoveItem(InventoryMoveItemEvent e) {
		if (e.getItem().hasItemMeta())
			if (e.getItem().getItemMeta().hasLore())
				if (e.getItem().getItemMeta().getLore().contains("soulbound")) {
					if (e.getSource().getHolder() instanceof Player) {
						((Player) e.getInitiator().getHolder())
								.sendMessage("That item is soulbound");
					}
					e.setCancelled(true);
				}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getInventory().getHolder().toString().equals(e.getWhoClicked().toString()))
			return;
		if (e.getCurrentItem() == null)
			return;
		if (!e.getCurrentItem().hasItemMeta())
			return;
		if (!e.getCurrentItem().getItemMeta().hasLore())
			return;
		if (!e.getCurrentItem().getItemMeta().getLore().contains("soulbound"))
			return;
		e.setResult(Result.DENY);
		((Player) e.getWhoClicked()).sendMessage("That item is soulbound");
		e.setCancelled(true);
	}

	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().hasItemMeta())
			if (e.getItemDrop().getItemStack().getItemMeta().hasLore())
				if (e.getItemDrop().getItemStack().getItemMeta().getLore()
						.contains("soulbound")) {
					e.getPlayer().sendMessage("That item is soulbound");
					e.setCancelled(true);
				}
	}
}
