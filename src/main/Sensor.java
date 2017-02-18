package main;

/**
 * Created by Andres on 2017-02-15.
 */
public interface Sensor {

    /**
    Description: This method creates a street with cars parked on it.
    Pre-condition: -
     Post-condition: Street with three parking places created of which one too small to park.
    */

    //Do we even need this. Isn't the normal version (line 30) just as good.
   //public void createStreet(int streetVariation);


    /**
     Description: This method measures the distance from car to an object on the car's right hand side.
     Pre-condition: The car is on the street.
     Post-condition: Returns a number between 0-200 representing the distance to an object on the right hand side.
     */
    public int[] getDistance (int position);


    /**
     Description: This method creates a street with cars parked on it.
     Pre-condition: -
     Post-condition: A street is created.
     */
    public void createStreet();


    /**
     Description: This method adds noise to the sensor readings of distance to objects on the car's right hand side..
     Pre-condition: A street has been created.
     Post-condition: Noise has been added to the sensors readings of the street.
     */
    public void addNoise();


    /**
     Description: This method creates three free parking spot on the street of which one is too small for the car.
     Pre-condition: A street has been created.
     Post-condition: Three free parking places have been created on the street.
     */
    public void addEmptySpace();

    //Again do we need this?
    public void addStaticEmptySpace();


    /**
     Description: This method disables a sensor if the sensor returns unreliable readings regularly.
     Pre-condition: A sensor is active.
     Post-condition: The sensor readings are ignored
     */
    public void disable();

    public boolean isActive();
}
