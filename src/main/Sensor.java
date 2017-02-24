package main;


public interface Sensor {
    /**
     Description: This method measures the distance from car to an object on the car's right hand side.
     Pre-condition: The car is on the street.
     Post-condition: Returns an int array with five readings the sensor gets for a specific position
        representing the distance to an object on the right hand side. If the sensor works properly it should return
        an int between -1 and 200.
     */
    public int[] getDistance (int position);

}
