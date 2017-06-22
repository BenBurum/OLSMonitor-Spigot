/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;

import java.io.File;
import java.io.FileNotFoundException;
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
        try {
            File log = new File(SMMonitor.getLogPath(), SMMonitor.getPlugin().config.getString("logfile-name") + ".monitordata");
            FileOutputStream fos = new FileOutputStream(log);
            FileChannel fileChannel = fos.getChannel();
                   
            //write to outString
            try {
                //lock the outputstream
                FileLock lock = fileChannel.lock();

                PrintWriter out = new PrintWriter(fos);
                printBasic();
                //check config for "check-ram" option
                if (SMMonitor.getPlugin().config.getBoolean("check-ram")){
                    printRam();
                }
                //check config for "check-CPU" option
                if (SMMonitor.getPlugin().config.getBoolean("check-CPU")){
                    printCpu();
                }
                //check config for "list-players" option
                if (SMMonitor.getPlugin().config.getBoolean("list-players")){
                    printPlayers();
                }
                //Finally print the string to the log and close writers.
                out.println(outString);
                lock.release();
                out.close();
                fos.close();
                
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e){
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
        outString += SMMonitor.interval + System.lineSeparator();
        outString += String.valueOf(timeNow) + System.lineSeparator();
    }
    
    public static void printPlayers(){
        outString += getOnlinePlayers();
    }
}
