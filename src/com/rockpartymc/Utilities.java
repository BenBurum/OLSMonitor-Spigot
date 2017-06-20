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
		
		int mb = 1024*1024;
                String ramInfo = new String();
		
		//Getting the runtime reference from system
		Runtime runtime = Runtime.getRuntime();
		
		String lineOne = ("##### Heap utilization statistics [MB] #####");
		
		//Print used memory
		String usedRam = ("Used Memory: " 
			+ (runtime.totalMemory() - runtime.freeMemory()) / mb) ;

		//Print free memory
		String freeRam = ("Free Memory: " 
			+ runtime.freeMemory() / mb);
		
		//Print total available memory
		String totalRam = ("Total Memory: " + runtime.totalMemory() / mb);

		//Print Maximum available memory
		String maxRam = ("Max Memory: " + runtime.maxMemory() / mb);
                
                //create string for output
                ramInfo = lineOne + System.lineSeparator() + usedRam + System.lineSeparator() + freeRam + System.lineSeparator() + totalRam + System.lineSeparator() + maxRam + System.lineSeparator();
                
                return ramInfo;
	}
        
        public static String checkCpu() {
            OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
            String cpuInfo = new String();
            
//            Runtime runtime = Runtime.getRuntime();
            
            String lineOne = ("##### CPU Load Statistics ####");
            
            //get process cpu load
            String processCpuLoad = "Process CPU Load: " + String.valueOf(operatingSystemMXBean.getProcessCpuLoad()*100) + '%';
            
            //get process cpu time
            String processCpuTime = "Process CPU Time: " + String.valueOf(operatingSystemMXBean.getProcessCpuTime()) + "ns";
            
            //get system cpu load
            String systemCpuLoad = "System CPU Load: " + String.valueOf(operatingSystemMXBean.getSystemCpuLoad()*100) + '%';
            
            //create string for output
            cpuInfo = lineOne + System.lineSeparator() + processCpuLoad + System.lineSeparator() + processCpuTime + System.lineSeparator() + systemCpuLoad + System.lineSeparator();

            
            return cpuInfo;
        }
}

