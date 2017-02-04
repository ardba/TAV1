package main;

import java.util.Arrays;

public class Sensor {

    //Create an array to demonstrate a 500m long street with 5 measurements
    //for each meter.
    private int[] distance = new int[2500];
    private boolean isActive ;
    public final static int STREET_DEFAULT = 0; //Creates a street with a randomly placed parking spot
    public final static int STREET_EMPTY = 1;  //Creates a street that contains only empty space
    public final static int STREET_FULL = 2;   //Creates a street that contains no parking space
    public final static int BROKEN_SENSOR = 3; //Creates a street with faulty measurements
    public final static int STREET_STATIC_PARKING_PLACE = 4; //Creates a street with a parking place at pos [204 - 202]


    public Sensor(Sensor sensor){
        this.distance = sensor.distance;
        this.isActive = sensor.isActive;
    }

    public Sensor(int streetVariation){
        this.isActive = true;
        switch (streetVariation){
            case STREET_DEFAULT:
                createStreet();
                addNoise();
                addEmptySpace();
                break;
            case STREET_EMPTY:
                for (int i=0; i < 2500; i++){
                    distance[i] = -1;
                }
                break;
            case STREET_FULL:
                createStreet();
                addNoise();
                break;
            case BROKEN_SENSOR:
                for (int j = 1; j < 2500; j++)
                    distance[j] = (int) (Math.random() * 1000000);
                break;
            case STREET_STATIC_PARKING_PLACE:
                createStreet();
                //Create parking space at [200,201,202,203,204]
                addStaticEmptySpace();
                break;

            default:
                createStreet();
                addNoise();
                addEmptySpace();
                break;
        }
    }

    public void createStreet(){

        //Populate array distance with random numbers between 0 and 200
        //so that the same number comes 25 times in a row.
        for (int i = 0; i < 2500; i++) {
            int sensorMeasurement = (int) (Math.random() * 200);

            for (int j = i; j < i + 25; j++) {
                if (j != 2500) {
                    distance[j] = sensorMeasurement;
                }
            }
            i += 24;
        }
    }
	public void addNoise(){
        //Add noise to the measurements
        for (int i = 0; i < 2500; i += Math.random() * 5 + 3) {
            distance[i] += Math.random() * 200 + 1;
            if (distance[i] > 200) {
                distance[i] = 200;
            }
        }
    }


    public void addEmptySpace(){
        //Add a row of -1 in the distance array to demonstrate a free parking spot
        int i = (int) (Math.random() * 2450);
        for (int j = i; j < i + 25; j++) {
            distance[j] = -1;
        }

    }

    public void addStaticEmptySpace(){
        for (int i = 1000; i < i+25; i++){
            distance[i] = -1;
        }
    }

    public int[] getDistance ( int position){
        int[] distance = new int[5];
        for (int i = 0; i < 5; i++) {
            distance[i] = this.distance[i + (position * 5)];
        }
        return distance;
    }

    public void disable(){
        this.isActive = false;
    }

    public boolean isActive(){
        return this.isActive;
    }

}
