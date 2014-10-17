package me.yarocks.nopay;

import me.yarocks.nopay.Commands.PayDCommand;
import me.yarocks.nopay.Commands.PayECommand;
import me.yarocks.nopay.Events.OnCommandPreProcess;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

/**
 * Created by User Name on 9/16/2014.
 */
public class Main extends JavaPlugin {

	private List<String> disabled = Arrays.asList("yarocks", "drpk", "kewlked14043");

	public static final String  prefix = "§c[§bNoPay§c] ";

	public void onEnable() {
		OnCommandPreProcess onCommandPreProcess = new OnCommandPreProcess(this);
		PayDCommand payDCommand = new PayDCommand(this);
		PayECommand payECommand = new PayECommand(this);
		PluginManager pm = Bukkit.getServer().getPluginManager();
		//TODO: REGISTER EVENTS

		pm.registerEvents(onCommandPreProcess, this);

		getCommand("payenable").setExecutor(payECommand);
		getCommand("paydisable").setExecutor(payDCommand);
		getConfig().addDefault("disabled", disabled);
		getConfig().options().copyDefaults(true);
		saveConfig();
		printEnable();
		//TODO: EXECUTE COMMANDS
	}

	public List<String> message = getConfig().getStringList("disabled");


	public void onDisable() {
		printDisable();
	}

	 void printEnable() {
		ConsoleCommandSender css = Bukkit.getConsoleSender();
		css.sendMessage("§a" + getDescription().getFullName() + " Has Been Enabled!");
	}

	 void printDisable() {
		ConsoleCommandSender css = Bukkit.getConsoleSender();
		css.sendMessage("§c" + getDescription().getFullName() + " Has Been Disabled!");
	}
}
