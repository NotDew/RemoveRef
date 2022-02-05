//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.notdew.com.removeref;

import org.bukkit.plugin.java.JavaPlugin;

public final class RemoveRef extends JavaPlugin {
    public RemoveRef() {
    }

    public void onEnable() {
        this.getCommand("removeref").setExecutor(new RemoveCommand());
        this.getCommand("addref").setExecutor(new AddCommand());
    }

    public void onDisable() {
    }
}
