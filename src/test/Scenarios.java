package test;

import main.Actuator;
import main.CarImpl;
import main.Sensor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Scenarios {

    CarImpl car;

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

    }

    @Test
    public void scenario1(){
        car.whereIs().setPosition(0); //Car starts at the beginning of the street
        car.park();                   //Check the report or the park method for this one
        Assert.assertEquals(true,car.whereIs().isParked());


        car.unPark();
        Assert.assertEquals(false,car.whereIs().isParked());

        Assert.assertEquals(232, car.whereIs().getPosition()); //Expect the car to be parked


        while(car.whereIs().getPosition() != 436)
            car.moveForward();

       // Assert.assertEquals(true,(car.whereIs().getPosition() == 499));

    }

    @Test
    public void scenario2(){

        Assert.assertEquals(false, car.whereIs().isParked());

        car.whereIs().setPosition(490);
        car.whereIs().setStaticParkingSpace();
        car.park();

        Assert.assertEquals(true, car.whereIs().isParked());

    }
}
