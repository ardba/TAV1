package main;


public class CarImpl implements Car {

    private VehicleData vehicleData; // Return type set to VehicleData due to moveForward() TC2.
	private Sensor sensorFront;
	private Sensor sensorBack;

    public CarImpl(int streetVariation){
        vehicleData = new VehicleData();
        switch (streetVariation) {
            case Sensor.STREET_RANDOM:
                sensorFront = new Sensor(Sensor.STREET_RANDOM);
                sensorBack = new Sensor(sensorFront);
                break;
            case Sensor.STREET_EMPTY:
                sensorFront = new Sensor(Sensor.STREET_EMPTY);
                sensorBack = new Sensor(sensorFront);
                break;
            case Sensor.STREET_FULL:
                sensorFront = new Sensor(Sensor.STREET_FULL);
                sensorBack = new Sensor(sensorFront);
                break;
            case Sensor.BROKEN_SENSOR:
                if(Math.random() > 0.5){
                    sensorFront = new Sensor(Sensor.BROKEN_SENSOR);
                    sensorBack = new Sensor(Sensor.STREET_RANDOM);
                }else{
                    sensorFront = new Sensor(Sensor.STREET_RANDOM);
                    sensorBack = new Sensor(Sensor.BROKEN_SENSOR);
                }
                break;
            case Sensor.STREET_STATIC_PARKING_PLACE:
                sensorFront = new Sensor(Sensor.STREET_STATIC_PARKING_PLACE);
                sensorBack = new Sensor(sensorFront);
                break;
            default:
                sensorFront = new Sensor(Sensor.STREET_RANDOM);
                sensorBack = new Sensor(sensorFront);
                break;
        }

    }


	@Override
    //The method for moving the car forward
    //The method for moving the car forward
    public VehicleData moveForward() { // Return type set to VehicleData due to moveForward() TC2.
        if(vehicleData.getPosition() != 500){ // If statement for checking if position is not 499 is created in moveForward() TC3.

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
        int counter = 1, tempCounter;
        int temp;

    	//If car is parked return empty
    	if (vehicleData.isParked()) {
    		return -1;
		}


    	int sensor1Pos = vehicleData.getPosition();
    	int sensor2Pos = sensor1Pos - 5;


    	int sensor1Measurement = 201, sensor2Measurement = 201;

    	if (sensor1Pos < 500 && sensor1Pos >= 0) {
            //Loop the 5 measurements and get rid of the noise by choosing the value
            //that shows up the most times.
            int[] sensor1Distance = sensorFront.getDistance(sensor1Pos);
            int popular = sensor1Distance[0];


            for (int i = 0; i < (sensor1Distance.length - 1); i++) {
                temp = sensor1Distance[i];
                tempCounter = 0;

                for (int j = 1; j < sensor1Distance.length; j++) {
                    if (temp == sensor1Distance[j])
                        tempCounter++;
                }
                if (tempCounter > counter) {
                    popular = temp;
                    counter = tempCounter;
                }
                sensor1Measurement = popular;
            }
        }

		//If sensor 2 is in the range of the street, between 0 & 500
		if (sensor2Pos >= 0 && sensor2Pos < 500) {
            int[] sensor2Distance = sensorBack.getDistance(sensor2Pos);
            counter = 1;
            int popular = sensor2Distance[0];

            for (int i = 0; i < (sensor2Distance.length - 1); i++) {
                temp = sensor2Distance[i];
                tempCounter = 0;

                for (int j = 1; j < sensor2Distance.length; j++) {
                    if (temp == sensor2Distance[j])
                        tempCounter++;
                }
                if (tempCounter > counter) {
                    popular = temp;
                    counter = tempCounter;
                }
                sensor2Measurement = popular;
            }
        }

            if (sensor1Measurement <= sensor2Measurement) {
                return sensor1Measurement;
            } else {
                return sensor2Measurement;
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
					parallelPark();
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


    public void parallelPark(){
		vehicleData.setPosition(vehicleData.getPosition()-5);
		vehicleData.setParked(true);
    }

}
