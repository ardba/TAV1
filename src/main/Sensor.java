package main;


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

}
