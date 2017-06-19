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
import static org.bukkit.Bukkit.getServer;
import org.bukkit.scheduler.BukkitScheduler;

/**
 *
 * @author Ben
 */
public class MainThread {
    
    public static void writeToFile (){
        long timeNow = System.currentTimeMillis();
        String outString = String.valueOf(timeNow) + "\n";
        
        //create log file
        File log = new File(RPMonitor.getPlugin().getDataFolder(), "log.txt");
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
}
