package de.langweilerlp.skypvp.commands;

import de.langweilerlp.skypvp.SkyPvP;
import de.langweilerlp.skypvp.api.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Kit_CMD implements CommandExecutor {

    private SkyPvP main;
    // ❘ » •

    public Kit_CMD(SkyPvP main) {
        this.main = main;
        Bukkit.getPluginCommand("kit").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;
        if (args.length == 0) {

            Inventory inv = Bukkit.createInventory(null, 27, "§8» §6Kits");

            inv.setItem(9, ItemAPI.createItemWithMaterial(Material.CHEST, (byte) 0, 1, "§8» §7Spieler"));
            inv.setItem(11, ItemAPI.createItemWithMaterial(Material.CHEST, (byte) 0, 1, "§8» §5Prime"));
            inv.setItem(13, ItemAPI.createItemWithMaterial(Material.CHEST, (byte) 0, 1, "§8» §eLegende"));
            inv.setItem(15, ItemAPI.createItemWithMaterial(Material.CHEST, (byte) 0, 1, "§8» §aUltimate"));
            inv.setItem(17, ItemAPI.createItemWithMaterial(Material.CHEST, (byte) 0, 1, "§8» §cSupreme"));

            p.openInventory(inv);

        }

        return true;
    }
}
    