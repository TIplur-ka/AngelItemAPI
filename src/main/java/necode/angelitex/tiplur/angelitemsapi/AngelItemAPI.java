package necode.angelitex.tiplur.angelitemsapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class AngelItemAPI extends JavaPlugin {
    private static AngelItemAPI instance;

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static AngelItemAPI getInstance() {return instance;}
}
