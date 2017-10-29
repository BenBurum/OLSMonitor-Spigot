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
    public boolean onCommand(CommandSender sender, Command smmonitor, String label, String[] args){
            if (args.length > 0){
                    if (args[0].equals("reload")){
                        sender.sendMessage("[SMMonitor] - Reloading config.");
                        System.out.println("Cancelling SchedId: " + SMMonitor.schedId);
                        Bukkit.getServer().getScheduler().cancelTask(SMMonitor.schedId);
                        BukkitScheduler scheduler = SMMonitor.getPlugin().getServer().getScheduler();
                        System.out.println("Is still running?: " + scheduler.isCurrentlyRunning(SMMonitor.schedId));
                        //reload the config file
                        SMMonitor.getPlugin().reloadConfig();
                        //attmept to reset the path for log file
                        SMMonitor.setCustomPath();
                        //get interval from config
                        SMMonitor.interval = SMMonitor.getPlugin().getConfig().getInt("log-interval");
                        System.out.println("[SMMonitor] - Log interval set to " + SMMonitor.interval + " ticks");
                        
                        System.out.println("[SMMonitor] - restarting scheduler");
                        SMMonitor.startScheduler();
                    }
            }
            else {
                sender.sendMessage("Possible Commands: " + "/smm reload");
            }
        return true;
    }
    
    

}
