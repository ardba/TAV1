/*
package test;

import main.ActuatorImpl;

import main.CarImpl;
import main.VehicleData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

*/
/**
 * Created by sanja on 2017-02-15.
 *//*

@RunWith(MockitoJUnitRunner.class)
public class ActuatorImplTest {
    CarImpl car = mock(CarImpl.class);
    VehicleData vehicleData = mock(VehicleData.class);
    ActuatorImpl instance;
    */
/**
     * Test of MoveForward method, of class main.ActuatorImpl.
     *//*

    //TC 1.1. Car is at the beginning of the street. Move forward. Expected output: Car moves 1.

    @Before
    public void setup(){
        instance = new ActuatorImpl(car);
    }
    @Test
    public void testCarMoved1Forward_Mockito(){
        when(car.whereIs()).thenReturn(vehicleData); // when calling whereIs(), always returned mocked vehicleData
        when(vehicleData.getPosition()).thenReturn(0); //
        int result;
        result = instance.moveForward(); //move the car forward
        //Expected output: Car moves 1.
        assertEquals(1, result);
    }

*/
/*    TC 1.2.
    Car is at the end of the street. Move forward. Expected output: Car moves 0.*//*


    @Test
    public void testCarMovedForwardAtTheEndOfTheStreet_Mockito(){
        when(car.whereIs()).thenReturn(vehicleData);
        when(vehicleData.getPosition()).thenReturn(499);
        ActuatorImpl instance = new ActuatorImpl(car); // Create Actuator to test
        int result;
        result = instance.moveForward(); //move the car forward
        //Expected output: Car moves 0.
        assertEquals(0, result);
    }

}
*/
