package lol.gggedr.democore.listeners;

import com.google.common.collect.Lists;
import lol.gggedr.democore.DemoCore;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.List;

public class ProtectListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockBreakEvent event) {
        event.setCancelled(true);
        event.getPlayer().spawnParticle(Particle.SMOKE_NORMAL, event.getBlock().getLocation().add(0, 1, 0), 10);
    }

    @EventHandler
    public void onExplosionPrime(ExplosionPrimeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(PlayerItemDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamageByBlock(EntityDamageByBlockEvent event) {
        event.setDamage(0.0);
        if(event.getEntity() instanceof Player) {
            event.setCancelled(true);

            if(event.getCause() == EntityDamageEvent.DamageCause.VOID) {
                event.getEntity().teleport(DemoCore.SPAWN_LOCATION);
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        event.setRespawnLocation(DemoCore.SPAWN_LOCATION);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setGameMode(GameMode.SURVIVAL);
        event.getPlayer().teleport(DemoCore.SPAWN_LOCATION);
        event.getPlayer().setHealth(20.0);
        event.getPlayer().setFoodLevel(20);
        event.getPlayer().setLevel(1);
        event.getPlayer().getInventory().clear();
        event.setJoinMessage("§8[§a+§8] §f"+ event.getPlayer().getName() +" §7joined the server.");

        pickupRandomGroup(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage("§8[§c-§8] §f"+ event.getPlayer().getName() +" §7left the server.");
    }

    private void pickupRandomGroup(Player player) {
        List<String> groups = Lists.newArrayList("owner", "admin", "developer", "helper", "builder");

        ConsoleCommandSender console = player.getServer().getConsoleSender();
        String clearCommand = "lp user "+ player.getName() +" clear";
        String groupCommand = "lp user "+ player.getName() +" parent set "+ groups.get((int) (Math.random() * groups.size()));

        player.getServer().dispatchCommand(console, clearCommand);
        player.getServer().dispatchCommand(console, groupCommand);
        player.setFlying(false);

        Bukkit.getScheduler().runTaskLater(DemoCore.getInstance(), () -> {
            sendWelcomeMessage(player);
        }, 20L);
    }

    private void sendWelcomeMessage(Player player) {
        for(int i = 0; i < 100; i++) {
            player.sendMessage(" ");
        }

        player.sendMessage(" ");
        player.sendMessage("  §c§lWELCOME TO SPP DEMO SERVER");
        player.sendMessage(" ");
        player.sendMessage("    §c§l◆ §fYou always get a random rank to test when you connect.");
        player.sendMessage("    §c§l◆ §fYour permissions are limited to the necessary.");
        player.sendMessage("    §c§l◆ §fIt is not possible to apply changes from the editor");
        player.sendMessage("       §fon this server.");
        player.sendMessage(" ");
        player.sendMessage("    §fIf you have any questions please take advantage of");
        player.sendMessage("    §four §csupport §fon §9Discord§f.");
        player.sendMessage(" ");
        player.sendMessage("    §fIf you want to test the discord bot here is the");
        player.sendMessage("    §finvite to the server:");
        player.sendMessage("    §9https://discord.gg/XxBQTrXjS6");
        player.sendMessage(" ");
    }


}
