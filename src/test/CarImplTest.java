package test;

import main.CarImpl;
import main.VehicleData;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CarImplTest {
    
    public CarImplTest() {
    }
    
    /**
     * Test of MoveForward method, of class main.CarImpl.
     */
    @Test
    public void testMoveForward() {
        System.out.println("MoveForward");
        //  Pre-condition: The car is at the beginning of the street and the car is not parked.
        //TC1: Create car at the beginning of the street.
        CarImpl instance = new CarImpl();
        VehicleData vehicleData = new VehicleData();
        //Expected output: Position 0m.
        assertEquals(0, vehicleData.getPosition());
        //TC2: Move forward.
        vehicleData = instance.moveForward();
        //Expected output: Position 1m and car not parked.
        assertEquals(1, vehicleData.getPosition());
        //TC3: Move forward 499 times.
        for (int i = 0; i < 499; i++){
            instance.moveForward();
        }
        //Expected output: Position 500m.
        assertEquals(500, vehicleData.getPosition());
        //TC4: Move forward from 500m.
        vehicleData = instance.moveForward();
        //Expected output: Position 500m.

        assertEquals(500, vehicleData.getPosition());
    }


    /**
     * Test of isEmpty method, of class main.CarImpl.
     */
    @Test
    public void testIsEmpty() {
       // System.out.println("isEmpty");
        CarImpl instance = new CarImpl();
        instance.isEmpty();
        // TODO review the generated test code and remove the default call to fail.
        Assert.fail("The test case is a prototype.");
    }

    /**
     * Test of MoveBackward method, of class main.CarImpl.
     */
    @Test
    public void testMoveBackward() {
        //Pre-condition: The car is at the end of the street.
        CarImpl instance = new CarImpl();
        for (int i = 0; i <= 499; i++) {
            instance.moveForward();
        }

        //TC1: The car moves 1m backward.
        VehicleData vehicleData = new VehicleData(); //save result in this
        vehicleData = instance.moveBackward();
        // Expected output: Car is on position 499m.
        assertEquals(499, vehicleData.getPosition());
        //TC2: The car moves backward 499 times.
        for (int i = 499; i > 0; i--) {
            instance.moveBackward();
        }
        // Expected output: Position 0m.
        assertEquals(0, vehicleData.getPosition());
        //TC3: The car moves backward.
        instance.moveBackward();
        assertEquals(0, vehicleData.getPosition());
    }

    /**
     * Test of Park method, of class main.CarImpl.
     */
    @Test
    public void testPark() {
       // System.out.println("Park");
        CarImpl car = new CarImpl();
        Assert.assertTrue("Car should be at the beginning of the street", 0 == car.whereIs().getPosition());
        Assert.assertTrue("Car should not be parked", false == car.whereIs().isParked());
        // TODO add more
    }

    /**
     * Test of UnPark method, of class main.CarImpl.
     */
    @Test
    public void testUnPark() {
     //   System.out.println("UnPark");
        CarImpl instance = new CarImpl();
        instance.whereIs().setParked(true); //makes the car parked to begin with
        int randomPos =(int) Math.random()*495; //creates a random valid parking spot
        instance.whereIs().setPosition(randomPos); //moves the car to the parking spot

        instance.unPark(); //unpark the car
        Assert.assertEquals(false,instance.whereIs().isParked()); //expect the car to be unparked
        Assert.assertEquals(randomPos+5, instance.whereIs().getPosition()); //expect the car to move forward from the parking spot
    }

    /**
     * Test of WhereIs method, of class main.CarImpl.
     */
    @Test
    public void testWhereIs() {
       // System.out.println("WhereIs");
        CarImpl instance = new CarImpl();
        VehicleData vehicleData = new VehicleData();
        Assert.assertEquals(vehicleData, instance.whereIs());
    }
    
}
