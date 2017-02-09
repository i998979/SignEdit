package to.epac.factorycraft.SignEdit.Commands;

import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SignEdit implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		Sign sign = null;
		if (args.length == 0) {
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "----------" + ChatColor.AQUA + "SignEdit"
					+ ChatColor.LIGHT_PURPLE + "----------");
			sender.sendMessage(ChatColor.GOLD + "Author: " + ChatColor.AQUA + "i998979");
			sender.sendMessage(ChatColor.DARK_GREEN + "Commands:");
			sender.sendMessage(ChatColor.AQUA + "/signedit|se|edit|sign <Line> [Message]: " + ChatColor.LIGHT_PURPLE
					+ "Edit signs. Leave [Message] empty to clear line");
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "----------" + ChatColor.AQUA + "SignEdit"
					+ ChatColor.LIGHT_PURPLE + "----------");
			return true;
		}

		else if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must be a player to use this comamnd!");
			return false;
			
		} else {
			String msg = "";
			Player player = (Player) sender;
			BlockState block = player.getTargetBlock((HashSet<Byte>) null, 1000).getState();
			if ((block instanceof Sign)) {
				Integer i = Integer.parseInt(args[0]);
				if (i > 0 && i < 5) {
					sign = (Sign) block;

					for (int j = 1; j < args.length; j++) {
						msg += args[j];
						if (j + 1 < args.length)
							msg += " ";
					}

					sign.setLine(i - 1, ChatColor.translateAlternateColorCodes('&', msg));
					sign.update(true);

					return true;
				}
				player.sendMessage(ChatColor.RED + "Invalid line. (1-4)");

			} else
				player.sendMessage(ChatColor.RED + "Please look at a sign.");

			return false;
		}
	}
}
