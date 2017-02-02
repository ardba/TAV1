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
        Assert.assertTrue("Car should be at the beginning of the street", 0 == car.getVehicleData().getPosition());
        Assert.assertTrue("Car should not be parked", false == car.getVehicleData().isParked());
        // TODO add more
    }

    /**
     * Test of UnPark method, of class main.CarImpl.
     */
    @Test
    public void testUnPark() {
        System.out.println("UnPark");
        CarImpl instance = new CarImpl();
        instance.getVehicleData().setParked(true); //makes the car parked to begin with
        instance.getVehicleData().setPosition((int) Math.random()*500); //moves the car to a random place in the road
        instance.unPark(); //unpark the car
        Assert.assertEquals(false,instance.getVehicleData().isParked());
    }

    /**
     * Test of WhereIs method, of class main.CarImpl.
     */
    @Test
    public void testWhereIs() {
        System.out.println("WhereIs");
        CarImpl instance = new CarImpl();
        instance.whereIs();
        // TODO review the generated test code and remove the default call to fail.
        Assert.fail("The test case is a prototype.");
    }
    
}
