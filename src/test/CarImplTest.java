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
        CarImpl car = new CarImpl();
        Assert.assertTrue("Car should be at the beginning of the street", 0 == car.whereIs().getPosition());
        Assert.assertTrue("Car should not be parked", false == car.whereIs().isParked());
        car.paralelPark();
        Assert.assertTrue("Car should be parked", true == car.whereIs().isParked());
        Assert.assertTrue("Car should be in parking space", car.whereIs().getPosition() == car.whereIs().getFreeSpace());
    }

    /**
     * Test of UnPark method, of class main.CarImpl.
     */
    @Test
    public void testUnParkWhenCarIsNotParked() {
     //   System.out.println("UnPark");
        CarImpl instance = new CarImpl();
        int randomPos =(int) Math.random()*495; //A random position on the street
        instance.whereIs().setPosition(randomPos); //moves the car to the random position
        instance.whereIs().setParked(false); //makes sure the car is parked (redundant)
        instance.unPark(); //unpark the car

        VehicleData vehicleData = new VehicleData(); //Create a control vehicle data, the one we expect the car to have
        vehicleData.setPosition(randomPos);         //Make it have the same position as the car
        vehicleData.setParked(false);               //Make it not be parked (redundant)

        Assert.assertTrue("Car should have the same position and status as before",
                instance.whereIs().equals(vehicleData));
        /*Compare both vehicle data, the car should
        have the same position and parked status as before since it isn't supposed to change.*/
    }

    @Test
    public void testUnParkWhenCarIsParked() {
        //   System.out.println("UnPark");
        CarImpl instance = new CarImpl();
        instance.whereIs().setParked(true); //makes the car parked to begin with
        int randomPos =(int) Math.random()*495; //creates a random valid parking spot
        instance.whereIs().setPosition(randomPos); //moves the car to the parking spot
        instance.unPark();
        VehicleData vehicleData = new VehicleData(); //Create a control vehicle data, the one we expect the car to have
        vehicleData.setPosition(randomPos + 5);         //Make it have the same position as the car
        vehicleData.setParked(false);               //Make it not be parked (redundant)

        Assert.assertTrue("Car should have changed its position and status",
                instance.whereIs().equals(vehicleData));

        /*Compare both vehicle data, the car should
        have the same position and parked status as before since it isn't supposed to change.*/

        }



    /**
     * Test of WhereIs method, of class main.CarImpl.
     */
    @Test
    public void testWhereIs() {
       // System.out.println("WhereIs");
        CarImpl instance = new CarImpl();
        VehicleData vehicleData = new VehicleData();
        Assert.assertTrue(vehicleData.equals(instance.whereIs()));
    }
    
}
