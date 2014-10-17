package me.yarocks.nopay.Commands;

import me.yarocks.nopay.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by User Name on 10/10/2014.
 */
public class PayECommand implements CommandExecutor {

public Main c;

	public PayECommand(Main c) {
		this.c = c;
	}

	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		if (command.getName().equalsIgnoreCase("payenable")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§4Only players may use this command");
				return false;
			}
			Player p = (Player) sender;
			if (p.hasPermission("pay.enable")) {
				if (c.message.contains(p.getName())) {
					p.sendMessage("hi");
					c.message.remove(p.getName());
					p.sendMessage("hi");
					c.getConfig().set("disabled", c.message);
					c.saveConfig();
					p.sendMessage("hi");
				} else {

					p.sendMessage("§cYou already have pay enabled!");
				}
			} else {
				p.sendMessage("§cYou have no permission!");

			}
		}
		return false;
	}
}
