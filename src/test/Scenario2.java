package test;

import main.Actuator;
import main.CarImpl;
import main.Sensor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class Scenario2 {

    CarImpl car;

    //@Mock
    Actuator actuator;
    Sensor sensorFront;
    Sensor sensorBack;

    @Before
    public void create(){
     //   initMocks(this);

        actuator = mock(Actuator.class);
        sensorFront = mock(Sensor.class);
        sensorBack = mock(Sensor.class);

        car = new CarImpl();
        car.setSensors(sensorFront,sensorBack);
        car.setActuator(actuator);

        when(actuator.moveForward()).thenAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {

                if (car.whereIs().getPosition() > 500){
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });
        when(actuator.moveBackward()).thenAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {

                if (car.whereIs().getPosition() < 1){
                    return 0;
                }
                else {
                    return -1;
                }
            }
        });

        int[] freeSpace = {-1,-1,-1,-1,-1};
        int[] takenSpace = {20,364,20,124,20};
        int[] brokenSpace = {6075,300,412,259,475};
        for(int i = 0; i < 500; i++){

            if(i > 30 && i < 35){
                when(sensorFront.getDistance(i)).thenReturn(freeSpace);
                when(sensorBack.getDistance(i)).thenReturn(freeSpace);
            }else if(i >= 232 && i <= 242){
                when(sensorFront.getDistance(i)).thenReturn(freeSpace);
                when(sensorBack.getDistance(i)).thenReturn(freeSpace);
            }else if(i > 430 && i < 436 ){
                when(sensorFront.getDistance(i)).thenReturn(freeSpace);
            }else{
                when(sensorFront.getDistance(i)).thenReturn(takenSpace);
                if(i > 250) {
                    when(sensorBack.getDistance(i)).thenReturn(brokenSpace);
                }else{
                    when(sensorBack.getDistance(i)).thenReturn(takenSpace);
                }
            }


        }

        when(sensorFront.isActive()).thenReturn(true);
        when(sensorBack.isActive()).thenReturn(true);
    }

    @Test
    public void test(){
        car.park();
        Assert.assertEquals(241,car.whereIs().getPosition());
        Assert.assertEquals(true,car.whereIs().isParkingSpaceFound());

    }
}
