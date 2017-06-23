/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*TODO: Change interval to ms instead of ticks, 
Add debug messages (printing, locking, if path provided is invalid, etc), 
add tps, login/logout listener, 
commands: reload, pause; 
plugin.yml, 
*/

package com.rockpartymc;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

/**
 *
 * @author Ben
 */
public class SMMonitor extends JavaPlugin {
    FileConfiguration config = getConfig();
    private static SMMonitor pluginReference;
    public static int interval = 600;
    private static File logPath;
 
    @Override
    public void onEnable() {
        //register commands
//        this.getCommand("reload").setExecutor(new Reload());
        //Create and set config values
        pluginReference = this;
        logPath = this.getDataFolder();
        config.addDefault("debug-mode", false);
        config.addDefault("check-ram", true);
        config.addDefault("check-CPU", true);
        config.addDefault("list-players", true);
        config.addDefault("logfile-name", "log");
        config.addDefault("custom-log-path", false);
        config.addDefault("custom-path-location", "plugins\\SMMonitor");
        config.addDefault("log-interval", 600);
        config.addDefault("debug-mode", false);
        config.options().copyDefaults(true);
        saveConfig();

        //set the log interval to the amount specified in the config.
        interval = config.getInt("log-interval");
        
        //check for custom path for log file
        if (config.getBoolean("custom-log-path")){
            String logPathString = config.getString("custom-path-location");
            System.out.println("[SMMonitor] - Custom Path set to " + logPathString);
            logPath = new File(logPathString);
            if (!logPath.isDirectory()){
                System.out.println("[SMMonitor] - Path not found.  Attempting to Create");
                if (!logPath.mkdirs()){
                    System.out.println("[SMMonitor] - Unable to create directory.  Using Default path.");
                    logPath = this.getDataFolder();
                }
                
            }
        }
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
   
        
    public static SMMonitor getPlugin() {
        
        return pluginReference;
    }
    
    public static File getLogPath(){
        return logPath;
    }

}


