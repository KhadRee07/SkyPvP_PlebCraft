package de.langweilerlp.skypvp.listener;

import de.langweilerlp.skypvp.SkyPvP;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KitInventoryClickListener implements Listener {

    private SkyPvP main;

    // ❘ » •

    public KitInventoryClickListener(SkyPvP main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        try {

            if (e.getView().getTitle().equalsIgnoreCase("§8» §6Kits")) {

                e.setCancelled(true);

                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Spieler")) {

                    

                }

            }

        } catch (NullPointerException ex) {}

    }

}