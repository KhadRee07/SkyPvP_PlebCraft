package de.langweilerlp.skypvp.listener;

import de.langweilerlp.skypvp.SkyPvP;
import de.langweilerlp.skypvp.mysql.MySQL;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    private SkyPvP main;

    // ❘ » •

    public DeathListener(SkyPvP main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();

        MySQL.addDeaths(p.getUniqueId().toString(), 1);

        Bukkit.getScheduler().runTaskLater(main, new Runnable() {
            @Override
            public void run() {
                p.spigot().respawn();
            }
        }, 2);

            if (e.getEntity().getKiller() instanceof Player) {
                Player killer = e.getEntity().getKiller();

                p.sendTitle("§4✖ §6Du wurdest getötet §4✖", "§8» §6Von §8• §a" + killer.getName(), 20, 80, 20);

                MySQL.addKills(killer.getUniqueId().toString(), 1);

                killer.sendMessage(main.getPrefix() + "§7Du hast §6" + p.getName() + " §7getötet");
            }
    }
}