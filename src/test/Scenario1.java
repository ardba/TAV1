package test;

import main.Actuator;
import main.CarImpl;
import main.Sensor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class Scenario1 {
    Actuator actuator = mock(Actuator.class);
    Sensor sensorFront = mock(Sensor.class);
    Sensor sensorBack = mock(Sensor.class);
    int i;

    @Before

    public void setup() {

    }

    // Scenario 1.
    @Test
    public void testScenario1_Mockito() {
        // Start at the beginning of the street
        CarImpl car = new CarImpl();
        car.setActuator(actuator);
        car.setSensors(sensorFront, sensorBack);

        //Moves along the street and scan the available parking places.
        //Not finding any space
        when(actuator.moveForward()).thenReturn(1);
        int[] noSpace = {1, 1, 1, 1, 1};
        when(sensorFront.getDistance(anyInt())).thenReturn(noSpace);
        for (i = 1; i < 200; i++) {
            if (i < 4) {//If rear sensor out of bounds
                Arrays.fill(noSpace, -1); //Fill result with "out of bounds error"
            }
            when(sensorBack.getDistance(anyInt())).thenReturn(noSpace);
            car.moveForward();
            Arrays.fill(noSpace, 1); //reset to default "in bounds" value
        }


        //Moves the car backwards and parks.
        when(actuator.moveBackward()).thenReturn(-1);
        car.park();

        //Unparks the car and drive to the end of the street.
        car.unPark();
        for (i = 30; i < 500; i++) {
            car.moveForward();

            //check sensors reading every time
        }


    }
}
