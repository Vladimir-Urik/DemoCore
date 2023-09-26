package lol.gggedr.democore.commands;

import lol.gggedr.democore.DemoCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;

        player.sendMessage("§8[§cSpawn§8] §fYou have been teleported to spawn.");
        player.teleport(DemoCore.SPAWN_LOCATION);

        return true;
    }

}
