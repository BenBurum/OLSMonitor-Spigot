/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;

/**
 *
 * @author OmarAlama
 */
public final class Colors {
    private static final char ESC = (char)27;
    public static final String RESET = ESC + "[0m";
    public static final String RED = ESC + "[0;31m";
    public static final String B_RED = ESC + "[1;31m";
    public static final String GREEN = ESC + "[0;32m";
    public static final String B_GREEN = ESC + "[1;32m";
    public static final String YELLOW = ESC + "[0;33m";
    public static final String B_YELLOW = ESC + "[1;33m";
    public static final String BLUE = ESC + "[0;34m";
    public static final String B_BLUE = ESC + "[1;34m";
    public static final String PURPLE = ESC + "[0;35m";
    public static final String B_PURPLE = ESC + "[1;35m";
    public static final String CYAN = ESC + "[0;36m";
    public static final String B_CYAN = ESC + "[1;36m";
    public static final String BLACK = ESC + "[0;30m";
    public static final String GREY = ESC + "[1;30m";
    public static final String WHITE = ESC + "[1m";
    
    public static String stripColors(String s)
    {
        return s.replace(RESET, "").replace(RED, "").replace(B_RED, "").replace(GREEN, "")
                .replace(B_GREEN, "").replace(YELLOW, "").replace(B_YELLOW, "").replace(BLUE, "")
                .replace(B_BLUE, "").replace(PURPLE, "").replace(B_PURPLE, "").replace(CYAN, "")
                .replace(B_CYAN, "").replace(BLACK, "").replace(GREY, "").replace(WHITE, "");
    }
}
