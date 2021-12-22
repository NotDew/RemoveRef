package me.notdew.com.removeref;

import org.bukkit.plugin.java.JavaPlugin;

public final class RemoveRef extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("removeref").setExecutor(new Command());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
