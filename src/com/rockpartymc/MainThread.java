/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import static org.bukkit.Bukkit.getOnlinePlayers;

/**
 *
 * @author Ben
 */
public class MainThread {
    static String outString = "";
      
    public static void writeToFile (){
        outString = "";
        //Initialize OutputStream and save string to file.
        File log = new File(SMMonitor.getLogPath(), SMMonitor.getPlugin().getConfig().getString("logfile-name") + ".monitordata");
        try (FileOutputStream fos = new FileOutputStream(log,true)) {
            
                FileChannel fileChannel = fos.getChannel();
                //lock the outputstream so the servermanager program can't interfere.
                if (SMMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                    System.out.println("[SMMonitor] - Locking Log File");
                }
                
                FileLock lock = fileChannel.lock();
                //Clear the contents of the file
                fileChannel.truncate(0);
                PrintWriter out = new PrintWriter(fos);
                printBasic();
                //check config for "check-ram" option
                if (SMMonitor.getPlugin().getConfig().getBoolean("check-ram")){
                    printRam();
                }
                //check config for "check-CPU" option
                if (SMMonitor.getPlugin().getConfig().getBoolean("check-CPU")){
                    printCpu();
                }
                //Check config cor "check-tps" option
                 if (SMMonitor.getPlugin().getConfig().getBoolean("check-tps")){
                    printTps();
                }
                //check config for "list-players" option
                if (SMMonitor.getPlugin().getConfig().getBoolean("list-players")){
                    printPlayers();
                }
                //Finally print the string to the log and close writers.
                if (SMMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                    System.out.println("[SMMonitor] - Writing to log file");
                }
                
                out.println(outString);
                
                if (SMMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                    System.out.println("[SMMonitor] - Unlocking Log File");
                }
                out.close();
                
        } catch (IOException e){
            e.printStackTrace();
        }
        
        

    }
    
    //Print Ram use info
    public static void printRam() {
        outString += Utilities.checkRam();
    }
    
    //print CPU Load info
    public static void printCpu() {
        outString += Utilities.checkCpu();
    }
    
    //print the interval and the time
    public static void printBasic(){
        long timeNow = System.currentTimeMillis();
        outString += (SMMonitor.interval*50) + System.lineSeparator();
        outString += String.valueOf(timeNow) + System.lineSeparator();
    }
    
    //Print the number of players
    public static void printPlayers(){
        outString += "Players:" + getOnlinePlayers().size();
    }
    
    //Print the TPS info
    public static void printTps(){
        outString += Utilities.checkTps();
    }
}
