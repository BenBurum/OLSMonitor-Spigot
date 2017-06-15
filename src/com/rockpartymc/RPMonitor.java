/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

/**
 *
 * @author Ben
 */
public class RPMonitor extends JavaPlugin {
    FileConfiguration config = getConfig();
    
    @Override
    public void onEnable() {
        //Create and set config values
        config.addDefault("log-ram", true);
        config.options().copyDefaults(true);
        saveConfig();
        
        //schedule the task
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
        
        //gets current time in ms
            @Override
            public void run() {
        long timeNow = System.currentTimeMillis();
        String outString = String.valueOf(timeNow);
        
        //create log file
        File log = new File(getDataFolder(), "log.txt");
            try {
                log.createNewFile();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        //save the string to the text file
        try(PrintWriter out = new PrintWriter(log)){
            out.println(outString);
            out.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

            }
        }, 0L, 600L);
    }
    
    @Override
    public void onDisable() {
    }    
}
