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

/**
 *
 * @author Ben
 */
public class MainThread {
        static String outString = "";
    public static void writeToFile (){

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
    
    //Print Ram use inf0
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
        outString += RPMonitor.interval + System.lineSeparator();
        outString += String.valueOf(timeNow) + System.lineSeparator();
    }
}
