package test;

import main.CarImpl;
import main.Sensor;
import main.VehicleData;
import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CarImplTest {
    
    public CarImplTest() {
    }

    /**
     * Test of MoveForward method, of class main.CarImpl.
     */

    //  TC1. Create car at the beginning of the street.
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
        CarImpl instance = new CarImpl(Sensor.STREET_DEFAULT); //Create car at the beginning of the street
        VehicleData vehicleData;
        for(int i = 0; i < 300; i++){
        vehicleData = instance.moveForward(); //move the car forward
        //Expected output: Position 1.
        assertEquals(1+i, vehicleData.getPosition());
        }
    }

    //TC3. Create car at the beginning of the street. Move car forward 500 times.
    @Test
    public void testMoveCarFurtherThanEnd(){
        CarImpl instance = new CarImpl(Sensor.STREET_DEFAULT); //Create car at the beginning of the street.
        VehicleData vehicleData1 = new VehicleData();
        for (int i = 0; i < 499; i++) { // Move car forward 500 times.
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
        //Pre-condition: The car is parked
        CarImpl car = new CarImpl(Sensor.STREET_DEFAULT);
        car.whereIs().setParked(true);
        //Post-condition: The car returns -1 because it's parked.
        Assert.assertEquals(-1, car.isEmpty() );
    }

    @Test
    public void testIsEmptyWhenBothSensorsOutOfBounds() {
        //Pre-condition: The car is out of the bounds of the street so that no sensor can measure distance.
        CarImpl car = new CarImpl(Sensor.STREET_DEFAULT);
        car.whereIs().setPosition(530);
        boolean isOutOfBounds;
        if (car.isEmpty() == 201) {
            isOutOfBounds = true;
        } else {
            isOutOfBounds = false;
        }
        //Post-condition: Sensors return 201, indicating an error
        Assert.assertTrue("The sensor returns 201 (error)", isOutOfBounds);
    }
    @Test
    public void testIsEmptyWhenBackSensorOutOfBounds() {
        //Pre-condition: The car is at the beginning of the street so that only sensor1 is on the street
        CarImpl car = new CarImpl(Sensor.STREET_DEFAULT);
        car.whereIs().setPosition(0);
        boolean isWithinBounds;
        if (car.isEmpty() <= 200 && car.isEmpty() >= -1) {
            isWithinBounds = true;
        } else {
            isWithinBounds = false;
        }
        //Post-condition: The sensor1 returns a value between -1 and 200
        Assert.assertTrue("The range is between -1 and 200", isWithinBounds);
    }

    @Test
    public void testIsEmptyWhenFrontSensorOutOfBounds() {
        //Pre-condition: The car is at the end of the street so that sensor1 is out of the street
        CarImpl car = new CarImpl(Sensor.STREET_DEFAULT);
        car.whereIs().setPosition(503);
        boolean isWithinTheRange;
        if (car.isEmpty() <= 200 && car.isEmpty() >= -1) {
            isWithinTheRange = true;
        } else {
            isWithinTheRange = false;
        }
        //Post-condition: The sensor2 returns a value between -1 and 200
        Assert.assertTrue("The range is between -1 and 200", isWithinTheRange);
    }

    @Test
    public void testIsEmptyWithBrokenSensor(){
        CarImpl car = new CarImpl(Sensor.BROKEN_SENSOR);
        for(int i = 0; i < Math.random() * 499; i++)
            car.moveForward();
        car.isEmpty();
        boolean sensorFrontActive = car.getSensor(CarImpl.SENSOR_FRONT).isActive();
        boolean sensorBackActive = car.getSensor(CarImpl.SENSOR_BACK).isActive();
        Assert.assertTrue("One of the sensors should be disabled", (sensorBackActive ^ sensorFrontActive));
    }


    /**
     * Test of MoveBackward method, of class main.CarImpl.
     */
    //TC1. The car moves 1m backward.
    @Test
    public void testMoveBackward() {
        //Pre-condition: The car is at the end of the street.
        CarImpl instance = new CarImpl(Sensor.STREET_DEFAULT); // Create car at the beginning of the street.
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
        CarImpl instance = new CarImpl(Sensor.STREET_DEFAULT); // Create car at the beginning of the street.
        VehicleData vehicleData = new VehicleData(); //save result in this
        instance.moveBackward(); //The car moves backward.
        assertEquals(0, vehicleData.getPosition()); // Expected output: Position 0.
    }

    /**
     * Test of Park method, of class main.CarImpl.
     */

    @Test // TC4.1
    public void testParkWhenParked(){
        CarImpl car = new CarImpl(Sensor.STREET_DEFAULT);
        Assert.assertTrue("Car should not be parked", true == !car.whereIs().isParked());
    }

    @Test //TC4.2
    public void testParkWhenParkingSpaceAlreadyFound(){
        CarImpl car = new CarImpl(Sensor.STREET_DEFAULT);
        Assert.assertTrue("Car should not be parked", true == !car.whereIs().isParked());
        car.whereIs().setStaticParkingSpace(); // Manually inject a parking space in vehicleDate as if it was found
        Assert.assertTrue("Parking space should be found", true == car.whereIs().isParkingSpaceFound());
        car.whereIs().setPosition((int)(Math.random() * (499 - 206)) + 206); // Manually place the car somewhere after the parking space
        Assert.assertTrue("Car should be on the street and not before a parking space", true == (car.whereIs().getPosition() > 205 && car.whereIs().getPosition() < 499));
        car.park();
        Assert.assertTrue("Car should be parked", true == car.whereIs().isParked());
        Assert.assertTrue("Car should be in the parking space", car.whereIs().getPosition() == car.whereIs().getParkingSpace()[0]);
    }

    @Test //TC4.3
    public void testParkWithStreetOneParkingSpace() {
        CarImpl car = new CarImpl(Sensor.STREET_DEFAULT); // Create a car on a street with one parking space in random position
        Assert.assertTrue("Car should not be parked", true == !car.whereIs().isParked());
        car.park();
        Assert.assertTrue("Car should find a parking space", car.whereIs().isParkingSpaceFound());
        Assert.assertTrue("Car should be parked", true == car.whereIs().isParked());
        Assert.assertTrue("Car should be in the parking space", car.whereIs().getPosition() == car.whereIs().getParkingSpace()[0]);
    }

    @Test //TC.4.4
    public void testParkWhenStreetIsFull() {
        CarImpl car = new CarImpl(Sensor.STREET_FULL); // Create a car on the street which does not have free parking spaces
        Assert.assertTrue("Car should not be parked", false == car.whereIs().isParked());
        car.park();
        Assert.assertTrue("Car should not be parked", false == car.whereIs().isParked());
        Assert.assertTrue("Car should be at the end of the street", 499 == car.whereIs().getPosition());
    }

    @Test //TC.4.5
    public void testParkWithStreetIsEmpty() {
        int[] expectedParkingSpace = {0, 1, 2, 3, 4};
        CarImpl car = new CarImpl(Sensor.STREET_EMPTY); // Create a car on the street which is all empty for parking
        Assert.assertTrue("Car should not be parked", false == car.whereIs().isParked());
        car.park();
        Assert.assertTrue("Car should be parked", true == car.whereIs().isParked());
        Assert.assertTrue("Car should be in the parking space", car.whereIs().getPosition() == car.whereIs().getParkingSpace()[0]);
        Assert.assertArrayEquals(car.whereIs().getParkingSpace(), expectedParkingSpace); // Car should be parked in the first available space
    }



    /**
     * Test of UnPark method, of class main.CarImpl.
     */
    @Test
    public void testUnParkWhenCarIsNotParked() {
     //   System.out.println("UnPark");
        CarImpl instance = new CarImpl(Sensor.STREET_DEFAULT);
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
        CarImpl instance = new CarImpl(Sensor.STREET_DEFAULT);
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
        CarImpl instance = new CarImpl(Sensor.STREET_DEFAULT);
        VehicleData vehicleData = new VehicleData();
        Assert.assertTrue(vehicleData.equals(instance.whereIs()));
    }

    @Test (expected = NullPointerException.class)
    public void testWhereIsWithMissingCar(){
        CarImpl car = null;
        car.whereIs();
    }
    
}
