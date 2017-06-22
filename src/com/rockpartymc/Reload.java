/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Ben
 */
public class Reload implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command servermanager, String reload, String[] args){
        SMMonitor.getPlugin().getConfig();
        return true;
    }
}
