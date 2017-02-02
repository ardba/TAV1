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

    //  TC1. Create car at the beginning of the street. Expected output: Position 0m.
    @Test
    public void testTheCarIsAtTheBeginningOfTheStreet() {
        VehicleData vehicleData = new VehicleData();   // Create car at the beginning of the street.
        //Expected output: Position 0m.
        assertEquals(0, vehicleData.getPosition()); //Test if expected position is 0.
    }
    //TC2: Move forward.
    @Test
    public void testMoveCarForward() {
        CarImpl instance = new CarImpl();
        VehicleData vehicleData;
        vehicleData = instance.moveForward(); //move the car forward
        //Expected output: Position 1m and car not parked.
        assertEquals(1, vehicleData.getPosition()); //Expected result should be 1 as result of moving the car for 1m.
    }
    //TC3: Move forward 499 times.
    @Test
    public void testMoveCarForwardToTheEndOfTheStreet() {
        CarImpl instance = new CarImpl();
        VehicleData vehicleData = new VehicleData();
        for (int i = 0; i <= 499; i++) { //Move the car 499 times
            vehicleData =instance.moveForward();
        }
        assertEquals(500, vehicleData.getPosition());     //Expected output: Position 500m.
    }
    //TC4. Move forward. Expected output: Position 500m.
    @Test
    public void testMoveCarForward1m(){
        CarImpl instance = new CarImpl();
        VehicleData vehicleData1 = new VehicleData();
        for (int i = 0; i <= 499; i++) { //Try to move car further than 499m.
            vehicleData1 = instance.moveForward();
        }
        assertEquals(500, vehicleData1.getPosition());  //Expected output: Position 500m.
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
        //a value between 0 and 200
        CarImpl car = new CarImpl();
        car.whereIs().setPosition(1);
        boolean isWithinTheRange;
        if (car.isEmpty() <= 200 && car.isEmpty() >= 0) {
            isWithinTheRange = true;
        } else {
            isWithinTheRange = false;
        }
        Assert.assertTrue("The range is between 0 and 200", isWithinTheRange);
    }

    @Test
    public void testIsEmptyWhenAtEndOfStreet() {
        System.out.println("isEmpty");
        CarImpl car = new CarImpl();
        car.whereIs().setPosition(0);
        boolean isWithinTheRange;
        if (car.isEmpty() <= 200 && car.isEmpty() >= 0) {
            isWithinTheRange = true;
        } else {
            isWithinTheRange = false;
        }
        Assert.assertTrue("The range is between 0 and 200", isWithinTheRange);
    }

    /**
     * Test of MoveBackward method, of class main.CarImpl.
     */
    //TC1. The car moves 1m backward. Expected output: Car is on position 499m.
    @Test
    public void testMoveBackward1m() {
        //Pre-condition: The car is at the end of the street.
        CarImpl instance = new CarImpl();
        for (int i = 0; i <= 499; i++){
            instance.moveForward();
        }
        //TC1: The car moves 1m backward.
        VehicleData vehicleData ; //save result in this
        vehicleData = instance.moveBackward();
        assertEquals(499, vehicleData.getPosition());

    }
    @Test

    public void testCarisMovedBackward499m() {
          CarImpl instance = new CarImpl();
          VehicleData vehicleData = new VehicleData(); //save result in this
          //TC2: The car moves backward 499 times.
          for (int i = 499; i > 0; i--) {
              instance.moveBackward(); //Move the car at the beginning of the street
          }
          assertEquals(0, vehicleData.getPosition());// Expected output: Position 0m.
      }
      //TC2: The car moves backward 499 times. Expected output: Position 0m.
    @Test
        public void testMoveBackwardFromBeginningOfTheStreet(){
        CarImpl instance = new CarImpl();
        VehicleData vehicleData = new VehicleData(); //save result in this
        instance.moveBackward(); //The car moves backward.
        assertEquals(0, vehicleData.getPosition()); //Expected position of the car is 0.
    }

    /**
     * Test of Park method, of class main.CarImpl.
     */

    @Test
    public void testParkWhenStreetIsFull() {
        CarImpl car = new CarImpl("full");
        Assert.assertTrue("Car should be at the beginning of the street", 0 == car.whereIs().getPosition());
        car.park();
        Assert.assertTrue("Car should not be parked", false == car.whereIs().isParked());
        Assert.assertTrue("Car should be at the end of the street", 500 == car.whereIs().getPosition());
    }

    @Test
    public void testParkWithStreatIsEmpty() {
        CarImpl car = new CarImpl("empty");
        Assert.assertTrue("Car should be at the beginning of the street", 0 == car.whereIs().getPosition());
        car.park();
        Assert.assertTrue("Car should be parked", true == car.whereIs().isParked());
        Assert.assertTrue("Car should be in the parking space", car.whereIs().getPosition() == car.whereIs().getParkingSpace()[0]);
    }

    @Test
    public void testParkWithStreatOneParkingSpace() {
        CarImpl car = new CarImpl();
        Assert.assertTrue("Car should be at the beginning of the street", 0 == car.whereIs().getPosition());
        car.park();
        Assert.assertTrue("Car should be parked", true == car.whereIs().isParked());
        Assert.assertTrue("Car should be in the parking space", car.whereIs().getPosition() == car.whereIs().getParkingSpace()[0]);
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
