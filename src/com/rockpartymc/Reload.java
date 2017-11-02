/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitScheduler;

/**
 *
 * @author Ben
 */
public class Reload implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command olsmonitor, String label, String[] args){
        if (sender.isOp()) {
            if (args.length > 0){
                    if (args[0].equals("reload")){
                        sender.sendMessage("[OLSMonitor] - Reloading config.");
                        Bukkit.getServer().getScheduler().cancelTask(OLSMonitor.schedId);
                        BukkitScheduler scheduler = OLSMonitor.getPlugin().getServer().getScheduler();
                        //reload the config file
                        OLSMonitor.getPlugin().reloadConfig();
                        //attmept to reset the path for monitordata file
                        OLSMonitor.setCustomPath();
                        //get interval from config
                        OLSMonitor.interval = OLSMonitor.getPlugin().getConfig().getInt("monitor-interval");
                        System.out.println("[OLSMonitor] - Log interval set to " + OLSMonitor.interval + " ticks");
                        
                        System.out.println("[OLSMonitor] - restarting scheduler");
                        OLSMonitor.startScheduler();
                    }
            }
                   else {
                sender.sendMessage("Possible Commands: " + "/smm reload");
            }
        }
        else {
            sender.sendMessage("[OLSMonitor - You do not have permission to use that command.");
        }

        return true;
    }
    
    

}
