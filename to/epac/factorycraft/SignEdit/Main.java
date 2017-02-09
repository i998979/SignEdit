package to.epac.factorycraft.SignEdit;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import to.epac.factorycraft.SignEdit.Commands.SignEdit;

public class Main extends JavaPlugin implements Listener {
  
  public void onEnable()
  {
	getServer().getPluginManager().registerEvents(this, this);
    getCommand("sign").setExecutor(new SignEdit());
  }
  
  public void onDisable()
  {
	  
  }
}
