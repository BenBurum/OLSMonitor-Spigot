/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*TODO:  
login/logout listener, 
commands: reload, pause; 
plugin.yml, 
*/

package com.rockpartymc;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

/**
 *
 * @author Ben
 */
public class OLSMonitor extends JavaPlugin {
//    FileConfiguration config = getConfig();
    private static OLSMonitor pluginReference;
    public static int interval = 600;
    private static File dataPath;
    static int schedId;
 
    @Override
    public void onEnable() {
        //register commands
        this.getCommand("olsmonitor").setExecutor(new Reload());
        //Create and set config values
        pluginReference = this;
        dataPath = this.getDataFolder();
        getConfig().addDefault("debug-mode", false);
        getConfig().addDefault("print-data-to-console", false);
        getConfig().addDefault("check-ram", true);
        getConfig().addDefault("check-CPU", true);
        getConfig().addDefault("check-tps", true);
        getConfig().addDefault("count-players", true);
        getConfig().addDefault("monitordata-file-name", "data");
        getConfig().addDefault("custom-data-path", false);
        getConfig().addDefault("custom-path-location", "plugins\\OLSMonitor");
        getConfig().addDefault("monitor-interval", 600);
        getConfig().addDefault("debug-mode", false);
        getConfig().options().copyDefaults(true);
        saveConfig();

        //set the monitor interval to the amount specified in the config.
        interval = getConfig().getInt("monitor-interval");
        
        //check for custom path for monitor data file
        if (getConfig().getBoolean("custom-data-path")){
            String dataPathString = getConfig().getString("custom-path-location");
            System.out.println("[OLSMonitor] - Custom Path set to " + dataPathString);
            dataPath = new File(dataPathString);
            if (!dataPath.isDirectory()){
                System.out.println("[OLSMonitor] - Path not found.  Attempting to Create");
                if (!dataPath.mkdirs()){
                    System.out.println("[OLSMonitor] - Unable to create directory.  Using Default path.");
                    dataPath = this.getDataFolder();
                }
                
            }
        }
        startScheduler();
    }
    
    @Override
    public void onDisable() {
    }    
   
    //returncurrent plugin reference    
    public static OLSMonitor getPlugin() {
        
        return pluginReference;
    }
    
    //return the path to the monitordata file.
    public static File getDataPath(){
        return dataPath;
    }

        //sets the path for the monitordata file to the one specified in config.yml
        public static void setCustomPath(){
        if (OLSMonitor.getPlugin().getConfig().getBoolean("custom-data-path")){
            String dataPathString = OLSMonitor.getPlugin().getConfig().getString("custom-path-location");
            System.out.println("[OLSMonitor] - Custom Path set to " + dataPathString);
            dataPath = new File(dataPathString);
            if (!dataPath.isDirectory()){
                System.out.println("[OLSMonitor] - Path not found.  Attempting to Create");
                if (!dataPath.mkdirs()){
                    System.out.println("[OLSMonitor] - Unable to create directory.  Using Default path.");
                    dataPath = OLSMonitor.getPlugin().getDataFolder();
                }
                
            }
        }
    }
        //Start the scheduled task
        public static void startScheduler(){
            //schedule the task
     //      Bukkit.getServer().getScheduler().cancelTask(schedId);
           BukkitScheduler scheduler = OLSMonitor.getPlugin().getServer().getScheduler();
           OLSMonitor.schedId = scheduler.scheduleSyncRepeatingTask(OLSMonitor.getPlugin(), new Runnable() {

           //gets current time in ms 
               @Override
               public void run() {
                   MainThread.writeToFile();

               }
               
           }, 0L, interval);
   //        Bukkit.getServer().getScheduler().cancelTask(schedId);
        }
}


