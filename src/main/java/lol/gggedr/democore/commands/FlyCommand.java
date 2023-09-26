package lol.gggedr.democore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage("§8[§cFly§8] §7Flight disabled.");
        } else {
            player.setAllowFlight(true);
            player.sendMessage("§8[§cFly§8] §7Flight enabled.");
        }

        return true;
    }

}
