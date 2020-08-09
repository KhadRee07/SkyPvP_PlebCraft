package de.langweilerlp.skypvp.listener;

import de.langweilerlp.skypvp.SkyPvP;
import de.langweilerlp.skypvp.mysql.MySQL;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerJoinListener implements Listener {

    private SkyPvP main;
    private static Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();

    // ❘ » •

    public PlayerJoinListener(SkyPvP main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        Bukkit.getScheduler().runTaskLater(main, new Runnable() {
            @Override
            public void run() {
                updateScoreboard(p);
            }
        }, 2);

        if (!(MySQL.checkPlayerIsInTable(p.getUniqueId().toString()))) {
            MySQL.createPlayerEntry(p.getUniqueId().toString());
        } else {
            MySQL.updatePlayerName(p.getUniqueId().toString(), p.getName());
        }
    }

    public static void updateScoreboard(Player p) {

        Objective o;

        Inventory inv = Bukkit.createInventory(null, 27);

        if (sb.getObjective("abcd") == null) {
            o = sb.registerNewObjective("abcd", "", "§8» §9Pleb§bCraft §8«");
        } else {
            o = sb.getObjective("abcd");
        }

        o.setDisplayName("§8» §9Pleb§bCraft §8«");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        o.getScore("").setScore(12);
        o.getScore("§7Profil").setScore(11);
        o.getScore("§8» §a" + p.getName()).setScore(10);
        o.getScore(" ").setScore(9);
        o.getScore("§7Rang").setScore(8);

        o.getScore("  ").setScore(6);
        o.getScore("§7Coins").setScore(5);
        o.getScore("§8» §e" + MySQL.getCoins(p.getUniqueId().toString())).setScore(4);
        o.getScore("   ").setScore(3);
        o.getScore("§7Forum").setScore(2);
        o.getScore("§8» §cComing soon").setScore(1);

        if (p.hasPermission("nte.owner")) {
            o.getScore("§8» §4Owner").setScore(7);
        } else if (p.hasPermission("nte.admin")) {
            o.getScore("§8» §4Admin").setScore(7);
        } else if (p.hasPermission("nte.dev")) {
            o.getScore("§8» §bDeveloper").setScore(7);
        } else if (p.hasPermission("nte.srmod")) {
            o.getScore("§8» §3SrModerator").setScore(7);
        } else if (p.hasPermission("nte.mod")) {
            o.getScore("§8» §3Moderator").setScore(7);
        } else if (p.hasPermission("nte.tmod")) {
            o.getScore("§8» §3TModerator").setScore(7);
        } else if (p.hasPermission("nte.content")) {
            o.getScore("§8» §bContent").setScore(7);
        } else if (p.hasPermission("nte.srsup")) {
            o.getScore("§8» §bSrSupporter").setScore(7);
        } else if (p.hasPermission("nte.sup")) {
            o.getScore("§8» §bSupporter").setScore(7);
        } else if (p.hasPermission("nte.tsup")) {
            o.getScore("§8» §bTSupporter").setScore(7);
        } else if (p.hasPermission("nte.srarchi")) {
            o.getScore("§8» §eSrArchitekt").setScore(7);
        } else if (p.hasPermission("nte.archi")) {
            o.getScore("§8» §eArchitekt").setScore(7);
        } else if (p.hasPermission("nte.tarchi")) {
            o.getScore("§8» §eTArchitekt").setScore(7);
        } else if (p.hasPermission("nte.supreme")) {
            o.getScore("§8» §cSupreme").setScore(7);
        } else if (p.hasPermission("nte.ultimate")) {
            o.getScore("§8» §aUltimate").setScore(7);
        } else if (p.hasPermission("nte.legende")) {
            o.getScore("§8» §eLegende").setScore(7);
        } else if (p.hasPermission("nte.prime")) {
            o.getScore("§8» §5Prime").setScore(7);
        } else {
            o.getScore("§8» §7Spieler").setScore(7);
        }

        p.setScoreboard(sb);
    }

}