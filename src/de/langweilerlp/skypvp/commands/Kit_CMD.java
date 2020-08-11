package de.langweilerlp.skypvp.commands;

import de.langweilerlp.skypvp.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Kit_CMD implements CommandExecutor {

    private SkyPvP main;
    // ❘ » •

    public Kit_CMD(SkyPvP main) {
        this.main = main;
        Bukkit.getPluginCommand("kit").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        return true;
    }
}
    