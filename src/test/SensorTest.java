/*
package test;

import main.Car;
import main.CarImpl;
import main.Sensor;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;





public class SensorTest {

    private Sensor sensor;

    @BeforeAll
    private void setupFoo(){
        sensor = mock(Sensor.class);

        for(int i = 30;i< 34;i++){
            when(getMostPopular(sensor.getDistance(i))).thenReturn(-1);
        }
        when(getMostPopular(sensor.getDistance(35))).thenReturn(20);

        for(int i = 232; i < 237; i++){
            when(getMostPopular(sensor.getDistance(i))).thenReturn(-1);
        }

        for(int i = 410; i < 415; i++){
            when(getMostPopular(sensor.getDistance(i))).thenReturn(-1);
        }

    }

    @Test
    public void testSmallParkingSpace() {
        assertEquals(99,getMostPopular(sensor.getDistance(29)));
        for(int i = 30; i < 34; i++)
            assertEquals(-1,getMostPopular(sensor.getDistance(i)));
        assertEquals(20,getMostPopular(sensor.getDistance(35)));
    }

    @Test
    public void testNormalParkingSpaces(){
        Sensor sensor = mock(Sensor.class);

        for(int i = 232; i < 237; i++) {
            assertEquals(-1, getMostPopular(sensor.getDistance(i)));
        }

        for(int i = 410; i < 415; i++){
            assertEquals(-1,getMostPopular(sensor.getDistance(i)));
        }

    }

*/
/*
    @Test
    public void testBrokenSensor(){
        CarImpl car = mock(CarImpl.class);
        for(int i = 0; i < 500; i++){
        when(getMostPopular(car.getSensor(CarImpl.SENSOR_FRONT).getDistance(i)));

        }
        for(int i = 0; i< 500; i++){
        getMostPopular(car.getSensor(CarImpl.SENSOR_BACK).getDistance(i));
        }

    }
*//*


    public int getMostPopular(int[] array){
        int temp, tempCounter, popular, counter = 1, measurement = 0;
        popular = array[0];
        for (int i = 0; i < 5; i++) {
            temp = array[i];
            tempCounter = 0;
            for (int j = 1; j < 5; j++) {
                if (temp == array[j])
                    tempCounter++;
            }
            if (tempCounter > counter) {
                popular = temp;
                counter = tempCounter;
            }
            measurement = popular;
        }
        return measurement;
    }


}
*/
