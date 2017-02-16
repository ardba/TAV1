package test;

import main.Car;
import main.VehicleData;
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
   // Actuator actuator = mock(Actuator.class);

    int i;
    @Before
    public void setup(){

    }
    // Scenario 1.
    @Test
    public void testCarMoved1Forward_Mockito(){
        // Start at the beginning of the street
        Car car = mock(Car.class);
        VehicleData vehicleData = mock(VehicleData.class);
        when(car.whereIs()).thenReturn(vehicleData);
        when(vehicleData.getPosition()).thenReturn(0);

        //Moves along the street and scan the available parking places.
        when(car.moveForward()).thenReturn(vehicleData);
        when(car.isEmpty()).thenReturn(1);
        for(i= 1; i < 30; i++){
            when(vehicleData.getPosition()).thenReturn(i);
            car.moveForward();
            car.isEmpty();
        }
        //Finding a space
        when(car.isEmpty()).thenReturn(-1);
        for(i= 30; i < 35; i++){
            when(vehicleData.getPosition()).thenReturn(i);
            car.moveForward();
            car.isEmpty();
        }

        // Moves backwards until the most efficient parking place (the smallest available parking where it still can park safetly)
        for(i= 34; i >= 30; i--){
            when(vehicleData.getPosition()).thenReturn(i);
            car.moveBackward();
            car.isEmpty();
        }

        //Parks the car
        car.park();



        //Unparks the car and drive to the end of the street.
        car.unPark();
        for(i= 30; i < 500 ; i++){
            when(vehicleData.getPosition()).thenReturn(i);
            car.moveForward();
            car.isEmpty();
        }


    }
}
