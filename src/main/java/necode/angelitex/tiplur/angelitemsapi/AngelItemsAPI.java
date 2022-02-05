package necode.angelitex.tiplur.angelitemsapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class AngelItemsAPI extends JavaPlugin {
    private static AngelItemsAPI instance;

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static AngelItemsAPI getInstance() {return instance;}
}
