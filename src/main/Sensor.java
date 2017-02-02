package main;

public class Sensor {

    //Create an array to demonstrate a 500m long street with 5 measurements
    //for each meter.
    private int[] distance = new int[2500];

    public Sensor(String streetVariation){

    }

    public Sensor() {

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

        //Add noise to the measurements
        for (int i = 0; i < 2500; i += Math.random() * 5 + 1) {
            distance[i] += Math.random() * 200 + 1;
        }

        //Add a row of -1 in the distance array to demonstrate a free parking spot
        int i = (int) (Math.random() * 2450);
        for (int j = i; j < i + 25; j++) {
            distance[j] = -1;
            //TODO add more parking spaces
        }

		 /*for(int x = 0; x < 2500; x++){
			System.out.println(distance[x]);
			}*/



        }

    public int[] getDistance ( int position){
        int[] distance = new int[5];
        for (int i = 0; i < 5; i++) {
            distance[i] = this.distance[i + (position * 5)];
        }
        return distance;
    }
}
