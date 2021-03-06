package main;

/**
 * Created by sanja on 2017-02-15.
 */
public interface Actuator {
    /**
     Description: This method moves the car 1 meter forward. The car cannot be moved forward beyond the end of the street.
     Pre-condition: The car is not at the end of the street.
     Post-condition: The car moved 1.
     */
    public int moveForward();

    /**
     Description: This method moves the car 1 meter backward. The car cannot be moved backward beyond the beginning of the street.
     Pre-condition:  The car is not at the beginning of the street.
     Post-condition: The car moved -1.
   */
    public int moveBackward();

}
