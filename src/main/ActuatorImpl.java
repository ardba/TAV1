package main;

/**
 * Created by sanja on 2017-02-15.
 */
public class ActuatorImpl implements ActuatorInterface{
    Car myCar;

    public ActuatorImpl(Car myCar) {
        this.myCar = myCar;
    }

    @Override
    public int moveForward() {
        if (myCar.whereIs().getPosition() < 499){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int moveBackward() {
        return 0;
    }
}
