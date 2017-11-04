/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;


import com.rockpartymc.servermanager.consolecommunication.Colors;
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
        File monitordata = new File(OLSMonitor.getDataPath(), OLSMonitor.getPlugin().getConfig().getString("monitordata-file-name") + ".monitordata");
        try (FileOutputStream fos = new FileOutputStream(monitordata,true)) {
            
                FileChannel fileChannel = fos.getChannel();
                //lock the outputstream so the servermanager program can't interfere.
                if (OLSMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                    System.out.println("[OLSMonitor] - Locking monitor data File");
                }
                
                FileLock lock = fileChannel.lock();
                //Clear the contents of the file
                fileChannel.truncate(0);
                PrintWriter out = new PrintWriter(fos);
                printBasic();
                //check config for "check-ram" option
                if (OLSMonitor.getPlugin().getConfig().getBoolean("check-ram")){
                    printRam();
                }
                //check config for "check-CPU" option
                if (OLSMonitor.getPlugin().getConfig().getBoolean("check-CPU")){
                    printCpu();
                }
                //Check config cor "check-tps" option
                 if (OLSMonitor.getPlugin().getConfig().getBoolean("check-tps")){
                    printTps();
                }
                //check config for "count-players" option
                if (OLSMonitor.getPlugin().getConfig().getBoolean("count-players")){
                    printPlayers();
                }
                //Finally print the string to the monitordata file and close writers.
                if (OLSMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                    System.out.println("[OLSMonitor] - Writing to monitor data file");
                }
                //finally print the string to the monitordata file.
                out.println(outString);
                
                //test strings to check formatting and then print to console
                if (OLSMonitor.getPlugin().getConfig().getBoolean("print-data-to-console")) {
                    outString = outString.substring(outString.indexOf('\n')+1);
                    outString = outString.substring(outString.indexOf('\n')+1);
                    System.out.println(Colors.translateColors(outString));
                }
                
 //               System.out.println(String.format("Command: %-25s  Type: %-7s  Schedule: %-16s Next: %-20s","start","WEEKLY","MONDAY 14:20","14h 32m 4s"));
                
                if (OLSMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                    System.out.println("[OLSMonitor] - Unlocking monitor data File");
                }
                out.close();
                
        } catch (IOException e){
            e.printStackTrace();
        }
        
        

    }
    
    //Print Ram use info
    public static void printRam() {
        outString += String.format("%-25s",Utilities.checkRam());
    }
    
    //print CPU Load info
    public static void printCpu() {
        outString += System.lineSeparator() + String.format("%-25s",Utilities.checkCpu());
    }
    
    //print the interval and the time
    public static void printBasic(){
        long timeNow = System.currentTimeMillis();
        outString += (OLSMonitor.interval*50) + System.lineSeparator();
        outString += String.valueOf(timeNow) + System.lineSeparator();
    }
    
    //Print the number of players
    public static void printPlayers(){
        outString += String.format("%-25s","$_Y" + "Players:" + "$$W" + getOnlinePlayers().size());
    }
    
    //Print the TPS info
    public static void printTps(){
        outString += String.format("%-25s",Utilities.checkTps());
    }
}
