package test;

import main.Actuator;
import main.CarImpl;
import main.Sensor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.*;

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


        try{
            FileReader reader = new FileReader(new File("street.txt"));
            BufferedReader bReader = new BufferedReader(reader);
            String street = bReader.readLine();
            String[] measurements = street.split(" ");
            for(int i = 0; i<measurements.length; i+=5){
                int[] reading ={
                        Integer.parseInt(measurements[i]),
                        Integer.parseInt(measurements[i+1]),
                        Integer.parseInt(measurements[i+2]),
                        Integer.parseInt(measurements[i+3]),
                        Integer.parseInt(measurements[i+4])};
                when(sensorFront.getDistance(i/5)).thenReturn(reading);
                when(sensorBack.getDistance(i/5)).thenReturn(reading);
            }
        }catch (FileNotFoundException e){
            System.out.println("File street.txt not found, creating one " + e);
            try {
                PrintWriter out = new PrintWriter("street.txt");
                String freeSpace = "-1 -1 -1 -1 -1 ";
                String takenSpace = "20 364 20 124 20 ";
                for(int i = 0; i < 500; i++){

                    //Put too small parking place (4 size)
                    if(i > 30 && i < 35){
                        out.print(freeSpace);
                    }else if(i >= 232 && i <= 242){
                        out.print(freeSpace);
                    }else if(i > 430 && i < 436 ){
                        out.print(freeSpace);
                    }else{
                        out.print(takenSpace);
                    }
                }
                out.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }catch (IOException e){
            System.out.println("IO exception " + e);
        }

        //We need to break one sensor!
        int[] brokenSpace = {6075,300,412,259,475};
        for(int i = 250; i<500;i++){
            when(sensorBack.getDistance(i)).thenReturn(brokenSpace);
        }


    }

    @Test
    public void scenario1(){
        car.whereIs().setPosition(0); //Car starts at the beginning of the street
        car.park();                   //Check the report or the park method for this one
        Assert.assertEquals(true,car.whereIs().isParked());

        car.unPark();
        Assert.assertEquals(false,car.whereIs().isParked());

        Assert.assertEquals(237, car.whereIs().getPosition()); //Expect the car to be parked

        while(car.whereIs().getPosition() != 499)
            car.moveForward();

       Assert.assertEquals(true,(car.whereIs().getPosition() == 499));

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
