package test;
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import main.CarImpl;
import main.VehicleState;
import org.junit.Test;

import org.junit.jupiter.api.Assertions;


/**
 *
 * @author sanja
 */
public class CarImplTest {
    
    public CarImplTest() {
    }
    
    /**
     * Test of MoveForward method, of class main.CarImpl.
     */
    @org.junit.jupiter.api.Test
    public void testMoveForward() {
        System.out.println("MoveForward");
        //  Pre-condition: The car is not on the end of the street and the car is not parked.
        CarImpl instance = new CarImpl();
        //Test-cases: testMoveForward();
        VehicleState vehicleState = new VehicleState();
        vehicleState = instance.MoveForward();
        // Post-condition: The car is moved 1m forward.
         Assertions.assertEquals(1, vehicleState.getPosition());
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
        Assertions.fail("The test case is a prototype.");
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
         Assertions.assertEquals(0, vehicleState.getPosition());
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
        Assertions.fail("The test case is a prototype.");
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
        Assertions.fail("The test case is a prototype.");
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
        Assertions.fail("The test case is a prototype.");
    }
    
}
