package main;

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

    //  TC1. Create car at the beginning of the street. .
    @Test
    public void testTheCarIsAtTheBeginningOfTheStreet()
    {
        VehicleData vehicleData = new VehicleData();   // Create car at the beginning of the street.
        //Expected output: Position 0.
        assertEquals(0, vehicleData.getPosition()); //Test if expected position is 0.
    }
    //TC2: Move forward.
    @Test
    public void testMoveCarForward() {
        CarImpl instance = new CarImpl(); //Create car at the beginning of the street
        VehicleData vehicleData;
        vehicleData = instance.moveForward(); //move the car forward
        //Expected output: Position 1.
        assertEquals(1, vehicleData.getPosition());
    }

    //TC3. Create car at the beginning of the street. Move car forward 500 times.
    @Test
    public void testMoveCarFurtherThanEnd(){
        CarImpl instance = new CarImpl(); //Create car at the beginning of the street.
        VehicleData vehicleData1 = new VehicleData();
        for (int i = 0; i <= 499; i++) { // Move car forward 500 times.
            vehicleData1 = instance.moveForward();
        }
        //Expected output: Position 499.
        assertEquals(499, vehicleData1.getPosition());
    }


    /**
     * Test of isEmpty method, of class main.CarImpl.
     */
    @Test
    public void testIsEmptyWhileParked() {
        System.out.println("isEmpty");
        //Pre-condition: The car is parked
        CarImpl car = new CarImpl();
        car.whereIs().setParked(true);
        //Post-condition: The car returns -1 because it's parked.
        Assert.assertEquals(-1, car.isEmpty() );
    }

    @Test
    public void testIsEmptyWhenAtStartOfStreet() {
        System.out.println("isEmpty");
        //Pre-condition: The car is at the beginning of the street and returns
        //a value between -1 and 200
        CarImpl car = new CarImpl();
        car.whereIs().setPosition(0);
        boolean isWithinTheRange;
        if (car.isEmpty() <= 200 && car.isEmpty() >= -1) {
            isWithinTheRange = true;
        } else {
            isWithinTheRange = false;
        }
        Assert.assertTrue("The range is between -1 and 200", isWithinTheRange);
    }

    @Test
    public void testIsEmptyWhenAtEndOfStreet() {
        System.out.println("isEmpty");
        CarImpl car = new CarImpl();
        car.whereIs().setPosition(499);
        boolean isWithinTheRange;
        if (car.isEmpty() <= 200 && car.isEmpty() >= -1) {
            isWithinTheRange = true;
        } else {
            isWithinTheRange = false;
        }
        Assert.assertTrue("The range is between -1 and 200", isWithinTheRange);
    }

    /**
     * Test of MoveBackward method, of class main.CarImpl.
     */
    //TC1. The car moves 1m backward.
    @Test
    public void testMoveBackward() {
        //Pre-condition: The car is at the end of the street.
        CarImpl instance = new CarImpl(); // Create car at the beginning of the street.
        for (int i = 0; i <= 498; i++){ //Move car forward 499 times.
            instance.moveForward();
        }
        VehicleData vehicleData ; //save result in this
        vehicleData = instance.moveBackward();
        assertEquals(498, vehicleData.getPosition()); //Expected output: Car is on position 498.
    }
    //TC2: If the car is on the  beginning of the street, it can not move backward.
    @Test
    public void testMoveBackwardFromBeginningOfTheStreet(){
        CarImpl instance = new CarImpl(); // Create car at the beginning of the street.
        VehicleData vehicleData = new VehicleData(); //save result in this
        instance.moveBackward(); //The car moves backward.
        assertEquals(0, vehicleData.getPosition()); // Expected output: Position 0.
    }

    /**
     * Test of Park method, of class main.CarImpl.
     */
    @Test
    public void testPark() {
        CarImpl car = new CarImpl();
//        Assert.assertTrue("Car should be at the beginning of the street", 0 == car.whereIs().getPosition());
//        Assert.assertTrue("Car should not be parked", false == car.whereIs().isParked());
//        car.prallelPark();
//        Assert.assertTrue("Car should be parked", true == car.whereIs().isParked());
//        Assert.assertTrue("Car should be in parking space", car.whereIs().getPosition() == car.whereIs().getFreeSpace());


    }
    @Test
    public void testParkWhenStreetIsFull() {
        CarImpl car = new CarImpl("full");
        Assert.assertTrue("Car should be at the beginning of the street", 0 == car.whereIs().getPosition());
        car.park();
        Assert.assertTrue("Car should not be parked", false == car.whereIs().isParked());
        Assert.assertTrue("Car should be at the end of the street", 499 == car.whereIs().getPosition());

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
        int randomPos =(int) Math.random()*494; //creates a random valid parking spot
        instance.whereIs().setPosition(randomPos); //moves the car to the parking spot
        instance.whereIs().setParked(true); //makes the car parked to begin with
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
