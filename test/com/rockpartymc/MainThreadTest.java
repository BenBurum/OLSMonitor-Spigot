/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpartymc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ben
 */
public class MainThreadTest {
    
    public MainThreadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of writeToFile method, of class MainThread.
     */
    @Test
    public void testWriteToFile() {
        System.out.println("writeToFile");
        MainThread.writeToFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printRam method, of class MainThread.
     */
    @Test
    public void testPrintRam() {
        System.out.println("printRam");
        MainThread.printRam();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printCpu method, of class MainThread.
     */
    @Test
    public void testPrintCpu() {
        System.out.println("printCpu");
        MainThread.printCpu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printBasic method, of class MainThread.
     */
    @Test
    public void testPrintBasic() {
        System.out.println("printBasic");
        MainThread.printBasic();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printPlayers method, of class MainThread.
     */
    @Test
    public void testPrintPlayers() {
        System.out.println("printPlayers");
        MainThread.printPlayers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
