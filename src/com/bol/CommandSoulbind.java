package com.bol;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandSoulbind implements CommandExecutor {

	BoLTestPlugin plugin;

	CommandSoulbind(BoLTestPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] split) {
		if (!(sender instanceof Player))
			return false;
		Player player = (Player) sender;
		ItemStack iStack = player.getItemInHand();
		if ((iStack == null)
				|| !iStack.hasItemMeta()) {
			player.sendMessage("Item cannot be soulbound");
			return true;
		}
		ItemMeta meta = iStack.getItemMeta();
		List<String> lore = meta.getLore();
		if (lore == null)
			lore = new ArrayList<String>();
		if (lore.contains("soulbound")) {
			lore.remove("soulbound");
			player.sendMessage("Invalid Item");
		} else {
			lore.add("soulbound");
			player.sendMessage("Item is now soulbound");
		}
		meta.setLore(lore);
		iStack.setItemMeta(meta);
		player.setItemInHand(iStack);
		return true;
	}

}
