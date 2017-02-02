package test;

import main.CarImpl;
import main.VehicleData;
import org.junit.*;

public class CarImplTest {
    
    public CarImplTest() {
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
        VehicleData vehicleData = new VehicleData();
        vehicleData = instance.moveForward();
        // Post-condition: The car is moved 1m forward.
         Assert.assertEquals(1, vehicleData.getPosition());
    }

    /**
     * Test of isEmpty method, of class main.CarImpl.
     */
    @Test
    public void testIsEmptyWhileParked() {
        System.out.println("isEmpty");
        CarImpl car = new CarImpl();
        //instance.isEmpty();
        // TODO review the generated test code and remove the default call to fail.

        car.whereIs().setParked(true);
        Assert.assertEquals(-1, car.isEmpty() );
    }

    /**
     * Test of MoveBackward method, of class main.CarImpl.
     */
    @Test
    public void testMoveBackward() {
       //Pre-condition: The car is not at the beginning of the street.
        CarImpl instance = new CarImpl();
        instance.moveForward();
        //Test-cases: testMoveBackward();
         VehicleData vehicleData = new VehicleData(); //save result in this
         vehicleData = instance.moveBackward();
         //Post-condition: The car is moved 1m backward.
         Assert.assertEquals(0, vehicleData.getPosition());
    }

    /**
     * Test of Park method, of class main.CarImpl.
     */
    @Test
    public void testPark() {
        System.out.println("Park");
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
        System.out.println("UnPark");
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
        System.out.println("WhereIs");
        CarImpl instance = new CarImpl();
        VehicleData vehicleData = new VehicleData();
        Assert.assertEquals(vehicleData, instance.whereIs());
    }
    
}
