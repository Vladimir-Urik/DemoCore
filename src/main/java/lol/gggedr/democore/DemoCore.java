package lol.gggedr.democore;

import lol.gggedr.democore.commands.FlyCommand;
import lol.gggedr.democore.commands.HelpCommand;
import lol.gggedr.democore.listeners.CommandsListener;
import lol.gggedr.democore.listeners.ProtectListener;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class DemoCore extends JavaPlugin {

    public static Location SPAWN_LOCATION;
    private static DemoCore instance;

    @Override
    public void onEnable() {
        SPAWN_LOCATION = new Location(getServer().getWorld("world"), 0.39, 72, 0.19);
        SPAWN_LOCATION.setPitch(3.9F);
        SPAWN_LOCATION.setYaw((float) -179.9);

        instance = this;

        getServer().getPluginManager().registerEvents(new ProtectListener(), this);
        getServer().getPluginManager().registerEvents(new CommandsListener(), this);

        getCommand("help").setExecutor(new HelpCommand());
        getCommand("fly").setExecutor(new FlyCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static DemoCore getInstance() {
        return instance;
    }
}
