package me.yarocks.nopay.Events;

import me.yarocks.nopay.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;

/**
 * Created by User Name on 10/10/2014.
 */
public class OnCommandPreProcess implements Listener {

public Main c;

	public OnCommandPreProcess(Main c) {
		this.c = c;
	}

	@EventHandler
	public void commandPreProcess(PlayerCommandPreprocessEvent evt) {
		Player p = evt.getPlayer();
		if (evt.getMessage().startsWith("/pay ")) {
			if (c.getConfig().contains("disabled")) {

				if (c.getConfig().contains("disabled")) {
					try {
						String[] args = evt.getMessage().split(" ");
						for (String message : c.message) {
							if (message.contains(Arrays.asList(args).get(1))) {


								evt.setCancelled(true);


								p.sendMessage(Main.prefix + "§cThat person has pay disabled.");

							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}




