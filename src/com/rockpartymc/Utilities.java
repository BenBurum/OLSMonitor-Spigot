/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;

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
                
                ramInfo = lineOne + System.lineSeparator() + usedRam + System.lineSeparator() + freeRam + System.lineSeparator() + totalRam + System.lineSeparator() + maxRam;
                
                return ramInfo;
	}
}

