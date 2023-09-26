package lol.gggedr.democore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§f");
        sender.sendMessage("  §c§lStaffProPlus Demo Help");
        sender.sendMessage("§f");
        sender.sendMessage("    §f/spp §chelp");
        sender.sendMessage("    §f/help");
        sender.sendMessage("    §f/fly");
        sender.sendMessage("    §f/plugins");
        sender.sendMessage("    §f");
        sender.sendMessage("    §fIf you have any questions please take advantage of");
        sender.sendMessage("    §four §csupport §fon §9Discord§f.");
        sender.sendMessage("§f");

        return true;
    }

}
