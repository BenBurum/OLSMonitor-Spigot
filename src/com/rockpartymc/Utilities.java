/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;


/**
 *
 * @author Ben
 */
public class Utilities {
    	public static String checkRam() {
                
            if (SMMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                System.out.println("[SMMonitor] - Checking Ram");
            }
            

            int mb = 1024*1024;
            String ramInfo = new String();

            //Getting the runtime reference from system
            Runtime runtime = Runtime.getRuntime();


            //Print used memory
            String usedRam = ("Used:" 
                    + (runtime.totalMemory() - runtime.freeMemory()) / mb) ;

            //Print free memory
            String freeRam = ("Free:" 
                    + runtime.freeMemory() / mb);

            //Print total available memory
            String totalRam = ("Total:" + runtime.totalMemory() / mb);

            //Print Maximum available memory
            String maxRam = ("Max:" + runtime.maxMemory() / mb);

            //create string for output
            ramInfo = "Ram: " + usedRam + " " + freeRam + " " + totalRam + " " + maxRam + " ";

            return ramInfo;
	}
        
        public static String checkCpu() {
            if (SMMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                System.out.println("[SMMonitor] - Checking CPU");
            }
            OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
            String cpuInfo = new String();
            
//            Runtime runtime = Runtime.getRuntime();
            
            
            //get process cpu load
            double processCpuLoadDouble = (operatingSystemMXBean.getProcessCpuLoad()*100);
            int processCpuLoadInt = (int) Math.round(processCpuLoadDouble);
            String processCpuLoad = String.valueOf(processCpuLoadInt) + '%';
            
            //get process cpu time
//            String processCpuTime = "Process CPU Time: " + String.valueOf(operatingSystemMXBean.getProcessCpuTime()) + "ns";
            
            //get system cpu load
//            String systemCpuLoad = "System CPU Load: " + String.valueOf(operatingSystemMXBean.getSystemCpuLoad()*100) + '%';
            
            //create string for output
            cpuInfo = System.lineSeparator() + "CPU:" + processCpuLoad + " ";

            
            return cpuInfo;
        }
        
        public static String checkTps(){
            if (SMMonitor.getPlugin().getConfig().getBoolean("debug-mode")){
                System.out.println("[SMMonitor] - Checking TPS");
            }
            String tpsInfo = new String();
            double tps = Lag.getTPS();
            tpsInfo = "TPS:" + String.valueOf(tps) + " ";
            
            return tpsInfo;
        }
}

