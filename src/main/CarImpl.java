package main;


import java.util.Arrays;

public class CarImpl implements Car {

    private VehicleData vehicleData; // Return type set to VehicleData due to moveForward() TC2.
	private Sensor sensor;

    public CarImpl() {  // Constructor added due to moveForward() TC2.
        vehicleData = new VehicleData(); //initialize vehicleData due to moveForward() TC2.

        sensor = new Sensor();
    }

    public CarImpl(String streetVariation) {
		vehicleData = new VehicleData();
		sensor = new Sensor(streetVariation);
	}

	@Override
    //The method for moving the car forward
    //The method for moving the car forward
    public VehicleData moveForward() { // Return type set to VehicleData due to moveForward() TC2.
        if(vehicleData.getPosition() != 499){ // If statement for checking if position is not 499 is created in moveForward() TC3.
                // testing
                if (isEmpty() == -1){
                    vehicleData.setFreeSpace(vehicleData.getPosition(), true);
                }
                else {
                    vehicleData.setFreeSpace(vehicleData.getPosition(), false);
                }

            vehicleData.setPosition(vehicleData.getPosition() +1); // Added due to moveForward() TC2.


	}
            return vehicleData;
        }

	@Override
	public int isEmpty() {

    	//If car is parked return empty
    	if (vehicleData.isParked() == true) {
    		return -1;
		}


    	int sensor1 = vehicleData.getPosition();
    	int sensor2 = sensor1 - 5;

    	int[] sensor1Distance = sensor.getDistance(sensor1);
    	int sensor1Measurement = 200, sensor2Measurement = 200;

    	//Loop the 5 measurements and get rid of the noise by choosing the value
		//that shows up the most times.
		int counter = 1, tempCounter;
		int popular = sensor1Distance[0];
		int temp;

		for (int i = 0; i < (sensor1Distance.length - 1); i++) {
			temp = sensor1Distance[i];
			tempCounter = 0;

			for (int j = 1; j < sensor1Distance.length; j++)
			{
				if (temp == sensor1Distance[j])
					tempCounter++;
			}
			if (tempCounter > counter)
			{
				popular = temp;
				counter = tempCounter;
			}
			sensor1Measurement = popular;
		}

		//If sensor 2 is in the range of the street, between 0 & 500
		if (sensor2 >= 0) {
			int[] sensor2Distance = sensor.getDistance(sensor2);
			counter = 1;
			popular = sensor2Distance[0];

			for (int i = 0; i < (sensor2Distance.length - 1); i++) {
				temp = sensor2Distance[i];
				tempCounter = 0;

				for (int j = 1; j < sensor2Distance.length; j++)
				{
					if (temp == sensor2Distance[j])
						tempCounter++;
				}
				if (tempCounter > counter)
				{
					popular = temp;
					counter = tempCounter;
				}
				sensor2Measurement = popular;
			}
			if (sensor1Measurement < sensor2Measurement) {
				return sensor1Measurement;
			} else {
				return sensor2Measurement;
			}
		} else {
			return sensor1Measurement;
		}

	}

	@Override
    //The method for moving the car backward
    public VehicleData moveBackward() { // Return type set to VehicleData due to moveBackward() TC1.
        if (vehicleData.getPosition() !=0 ){ //// If statement for checking if position is not 0 is created in moveBackward() TC2.
            vehicleData.setPosition(vehicleData.getPosition() -1); //  // Added due to moveBackward() TC1.
        }
        return vehicleData;
    }


    @Override
	public void park() {
		if (vehicleData.getPosition() < 500) {

			while (vehicleData.getPosition() < 500) {
				moveForward();
				if (vehicleData.isParkingSpaceFound()) {
					prallelPark();
                    break;
				}
			}

		}
	}

	@Override
	public void unPark() {
        if(vehicleData.isParked()){ //testUnparkWhenCarIsNotParked: requires the vehicle not to change when it isn't parked
            for(int i = 0; i<5; i++){
                moveForward(); //testUnparkWhenCarIsParked: Moves forward 5 times, getting away of the parking place
          }
            vehicleData.setParked(false); //testUnparkWhenCarIsParked: change the vehicle status
        }
	}

	@Override
	public VehicleData whereIs() {
		return vehicleData; //Returns the expected vehicle data
	}

	// Additional methods


    public void prallelPark(){
		vehicleData.setPosition(vehicleData.getPosition()-5);
		vehicleData.setParked(true);
    }

}
