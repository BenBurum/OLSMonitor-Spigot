/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;


import com.rockpartymc.servermanager.consolecommunication.Colors;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.text.DecimalFormat;



/**
 *
 * @author Ben
 */
public class Utilities {
    	public static String checkRam() {
                
            if (OLSMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                System.out.println("[OLSMonitor] - Checking Ram");
            }
            

            int mb = 1024*1024;
            String ramInfo = new String();

            //Getting the runtime reference from system
            Runtime runtime = Runtime.getRuntime();
            


            //Print used memory
            String usedRam = String.format("%-25s","$_Y" + "Used RAM:" + "$$W" +
                    + (runtime.totalMemory() - runtime.freeMemory()) / mb + "mb");

            //Print free memory
            String freeRam = String.format("%-25s","$_Y" + "Free RAM:" + "$$W" +
                    + (runtime.freeMemory()) / mb + "mb");

            //Print total available memory
            String totalRam = String.format("%-25s","$_Y" + "Total RAM:" + "$$W" + (runtime.totalMemory()) / mb + "mb");

            //Print Maximum available memory
            String maxRam = String.format("%-25s","$_Y" + "Max RAM:" + "$$W" + (runtime.maxMemory()) / mb + "mb");

            //create string for output
            ramInfo = usedRam + freeRam + totalRam + maxRam;

            return ramInfo;
	}
        
        public static String checkCpu() {
            if (OLSMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                System.out.println("[OLSMonitor] - Checking CPU");
            }
            OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
            String cpuInfo = new String();
            
//            Runtime runtime = Runtime.getRuntime();
            
            
            //get process cpu load
            double processCpuLoadDouble = (operatingSystemMXBean.getProcessCpuLoad()*100);
//            int processCpuLoadInt = (int) Math.round(processCpuLoadDouble);
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(3);
            String processCpuLoadFormatted = df.format(processCpuLoadDouble);
            String processCpuLoad = String.valueOf(processCpuLoadFormatted) + '%';
            
            //get process cpu time
//            String processCpuTime = "Process CPU Time: " + String.valueOf(operatingSystemMXBean.getProcessCpuTime()) + "ns";
            
            //get system cpu load
//            String systemCpuLoad = "System CPU Load: " + String.valueOf(operatingSystemMXBean.getSystemCpuLoad()*100) + '%';
            
            //create string for output
            cpuInfo = "$_Y" + "CPU:" + "$$W" + processCpuLoad + " ";

            
            return cpuInfo;
        }
        
        public static String checkTps(){
            if (OLSMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                System.out.println("[OLSMonitor] - Checking TPS");
            }
            String tpsInfo = new String();
            double tps = Lag.getTPS();
            tpsInfo = "$_Y" + "TPS:" + "$$W" + String.valueOf(tps) + " ";
            
            return tpsInfo;
        }
}

