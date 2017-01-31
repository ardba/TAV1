package main;
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sanja
 */
public class CarImplTest {
    
    public CarImplTest() {
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
     * Test of MoveForward method, of class main.CarImpl.
     */
    @Test
    public void testMoveForward() {
        System.out.println("MoveForward");
        //  Pre-condition: The car is not on the end of the street and the car is not parked.
        CarImpl instance = new CarImpl();
        //Test-cases: testMoveForward();
        VehicleState vehicleState = new VehicleState();
        vehicleState = instance.MoveForward();
        // Post-condition: The car is moved 1m forward.
         assertEquals(1, vehicleState.getPosition());
    }

    /**
     * Test of isEmpty method, of class main.CarImpl.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        CarImpl instance = new CarImpl();
        instance.isEmpty();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MoveBackward method, of class main.CarImpl.
     */
    @Test
    public void testMoveBackward() {
       //Pre-condition: The car is not at the beginning of the street.
        CarImpl instance = new CarImpl();
        instance.MoveForward();
        //Test-cases: testMoveBackward();
         VehicleState vehicleState = new VehicleState(); //save result in this
         vehicleState = instance.MoveBackward();
         //Post-condition: The car is moved 1m backward.
         assertEquals(0, vehicleState.getPosition());
    }

    /**
     * Test of Park method, of class main.CarImpl.
     */
    @Test
    public void testPark() {
        System.out.println("Park");
        CarImpl instance = new CarImpl();
        instance.Park();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UnPark method, of class main.CarImpl.
     */
    @Test
    public void testUnPark() {
        System.out.println("UnPark");
        CarImpl instance = new CarImpl();
        instance.UnPark();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of WhereIs method, of class main.CarImpl.
     */
    @Test
    public void testWhereIs() {
        System.out.println("WhereIs");
        CarImpl instance = new CarImpl();
        instance.WhereIs();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
