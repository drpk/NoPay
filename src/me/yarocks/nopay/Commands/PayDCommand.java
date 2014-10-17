package me.yarocks.nopay.Commands;

import me.yarocks.nopay.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by User Name on 10/10/2014.
 */
public class PayDCommand implements CommandExecutor {
	public PayDCommand(Main c) {
		this.c = c;
	}

	public Main c;

	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
		if (command.getName().equalsIgnoreCase("paydisable")) {
			if (!(commandSender instanceof Player)) {
				commandSender.sendMessage("§4Only players may use this command");
			} else {
				Player p = (Player) commandSender;
				if (p.hasPermission("pay.disable")) {
					if (!c.message.contains(p.getName())) {
						c.message.add(p.getName());
						c.getConfig().set("disabled", c.message);
						c.saveConfig();
						p.sendMessage("§aPay has been disabled!");
					} else {
						p.sendMessage("§cYou already have pay disabled!");
					}
				} else {
					p.sendMessage("§cYou have no permission!");
				}
			}
		}
		return false;
	}
}
