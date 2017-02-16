package test;

import main.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sanja on 2017-02-16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ScenarioMockitoTest {
   Actuator actuator = mock(Actuator.class);
    int i;
    @Before

    public void setup(){

    }
    // Scenario 1.
    @Test
    public void testCarMoved1Forward_Mockito(){
        // Start at the beginning of the street
        CarImpl car = new CarImpl(SensorImpl.STREET_STATIC_PARKING_PLACE);
        car.setActuator(actuator);

        //Moves along the street and scan the available parking places.
        //Move until space found on position 204. (static parking place).
        when(actuator.moveForward()).thenReturn(1);
        for(i= 1; i < 205; i++){
            car.moveForward();
        }

        //Moves the car backwards and parks.
        when(actuator.moveBackward()).thenReturn(-1);
        car.park();

        //Unparks the car and drive to the end of the street.
        car.unPark();
        for(i= 30; i < 500 ; i++){
            car.moveForward();
        }


    }
}
