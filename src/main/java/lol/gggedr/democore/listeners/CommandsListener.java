package lol.gggedr.democore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class CommandsListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event){
        String command = event.getMessage().toLowerCase();

        if (command.startsWith("/plugins") || command.startsWith("/pl") || command.startsWith("/bukkit:plugins") || command.startsWith("/bukkit:pl")) {
            event.setCancelled(true);
            sendPluginsMessage(event.getPlayer());
            return;
        }

        if (command.startsWith("/version") || command.startsWith("/ver") || command.startsWith("/bukkit:version") || command.startsWith("/bukkit:ver")) {
            event.setCancelled(true);
            sendVersionMessage(event.getPlayer());
            return;
        }
    }

    public void sendPluginsMessage(Player player) {
        Iterator<Plugin> plugins = Arrays.stream(Bukkit.getPluginManager().getPlugins()).collect(Collectors.toList()).iterator();

        StringBuilder builder = new StringBuilder();
        while (plugins.hasNext()) {
            Plugin plugin = plugins.next();
            builder.append("§7")
                    .append(plugin.getName());

            if (plugins.hasNext()) {
                builder.append("§c, ");
            }
        }

        player.sendMessage("§8[§cPlugins§8] §fPlugins §8(§c" + Bukkit.getPluginManager().getPlugins().length + "§8)§7: " + builder + "§7.");
    }

    public void sendVersionMessage(Player player) {
        player.sendMessage("§8[§cVersion§8] §fThis server is running §c" + Bukkit.getVersion() + "§f and is used on §c§lStaffProPlus Demo Server§f.");
    }

}
