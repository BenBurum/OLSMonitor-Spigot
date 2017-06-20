/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

/**
 *
 * @author Ben
 */
public class RPMonitor extends JavaPlugin {
    FileConfiguration config = getConfig();
    private static RPMonitor pluginReference;
    public static int interval = 600;   
 
    @Override
    public void onEnable() {
        //Create and set config values
        config.addDefault("log-ram", true);
        config.options().copyDefaults(true);
        saveConfig();
        pluginReference = this;

    
        
        //schedule the task
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
        
        //gets current time in ms 
            @Override
            public void run() {
                MainThread.writeToFile();

            }
        }, 0L, interval);
    }
    
    @Override
    public void onDisable() {
    }    
   
        
    public static RPMonitor getPlugin() {
        
        return pluginReference;
    }

}


