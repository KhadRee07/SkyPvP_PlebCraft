package de.langweilerlp.skypvp;

import de.langweilerlp.skypvp.commands.Kit_CMD;
import de.langweilerlp.skypvp.listener.DeathListener;
import de.langweilerlp.skypvp.listener.KitInventoryClickListener;
import de.langweilerlp.skypvp.listener.PlayerJoinListener;
import de.langweilerlp.skypvp.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyPvP extends JavaPlugin {

    public static final String PREFIX = "§8» §6SkyPvP §8❘ §r";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§8[§6SkyPvP§8] §aPlugin aktiviert");

        new MySQL().connect();

        createTables();

        new DeathListener(this);
        new Kit_CMD(this);
        new PlayerJoinListener(this);
        new KitInventoryClickListener(this);
    }

    @Override
    public void onDisable() {
        new MySQL().disconnect();
    }

    public String getPrefix() {
        return PREFIX;
    }

    private static void createTables() {

        MySQL.update("CREATE TABLE IF NOT EXISTS SkyPvP (playername varchar(100), uuid varchar (100), kills bigint, deaths bigint, coins bigint)");

    }
}
