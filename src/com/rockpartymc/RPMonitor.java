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
        }, 0L, 600L);
    }
    
    @Override
    public void onDisable() {
    }    
    
	public static String checkRam(String [] args) {
		
		int mb = 1024*1024;
                String ramInfo = new String();
		
		//Getting the runtime reference from system
		Runtime runtime = Runtime.getRuntime();
		
		String lineOne = ("##### Heap utilization statistics [MB] #####");
		
		//Print used memory
		String usedRam = ("Used Memory:" 
			+ (runtime.totalMemory() - runtime.freeMemory()) / mb);

		//Print free memory
		String freeRam = ("Free Memory:" 
			+ runtime.freeMemory() / mb);
		
		//Print total available memory
		String totalRam = ("Total Memory:" + runtime.totalMemory() / mb);

		//Print Maximum available memory
		String maxRam = ("Max Memory:" + runtime.maxMemory() / mb);
                
                ramInfo = lineOne + "\n" + usedRam + "\n" + freeRam + "\n" + totalRam + "\n" + maxRam;
                
                return ramInfo;
	}
        
    public static RPMonitor getPlugin() {
        
        return pluginReference;
    }

}


