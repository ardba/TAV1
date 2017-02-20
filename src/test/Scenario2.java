package test;

import main.Actuator;
import main.CarImpl;
import main.Sensor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class Scenario2 {

    CarImpl car;

    @Mock
    Actuator actuator;
    Sensor sensor;

    @Before
    public void create(){
        initMocks(this);
        car = new CarImpl();
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



    }

    @Test
    public void test(){

    }
}
