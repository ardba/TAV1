package main;


public class CarImpl implements Car {

	private VehicleData vehicleData;
	private Sensor sensor;

    public CarImpl() { //initialize vehicleData
        vehicleData = new VehicleData();
		sensor = new Sensor();
    }

    public CarImpl(String streetVariation) {
		vehicleData = new VehicleData();
		sensor = new Sensor(streetVariation);
	}
        
	@Override
    //The method for moving the car forward
	public VehicleData moveForward() {
			if(vehicleData.getPosition() != 500){
                vehicleData.setPosition(vehicleData.getPosition() +1);
				// testing
				vehicleData.setFreeSpace(false);
	}
            return vehicleData;
        }

	@Override
	public int isEmpty() {

    	//If car is parked return -1 (-1 being empty)
    	if (vehicleData.isParked() == true) {
    		return -1;
		}

		//Create the two sensors: sensor1 being in the front of the car thus taking the same position as the car,
		//and sensor2 being 5 metres behind the sensor1.
    	int sensor1 = vehicleData.getPosition();
    	int sensor2 = sensor1 - 5;

    	//Get 5 readings for the distance from an object to the sensor1.
    	int[] sensor1Distance = sensor.getDistance(sensor1);
    	//Initialise the default distance to both sensors to be the maximum 200.
    	int sensor1Measurement = 200, sensor2Measurement = 200;

    	//Loop the 5 measurements for sensor1 and get rid of the noise by choosing the value
		//that shows up the most.
		int counter = 1, tempCounter;
		int popular = sensor1Distance[0];
		int temp;

		for (int i = 0; i < (sensor1Distance.length - 1); i++) {
			temp = sensor1Distance[i];
			tempCounter = 0;

			for (int j = 1; j < sensor1Distance.length; j++) {
				if (temp == sensor1Distance[j])
					tempCounter++;
			} if (tempCounter > counter) {
				popular = temp;
				counter = tempCounter;
			}
			sensor1Measurement = popular;
		}

		//If sensor 2 is in the range of the street, between 0 & 500 (and not -2 for example),
		//loop the 5 measurements the same way as for sensor1 before.
		if (sensor2 >= 0) {
			int[] sensor2Distance = sensor.getDistance(sensor2);
			counter = 1;
			popular = sensor2Distance[0];

			for (int i = 0; i < (sensor2Distance.length - 1); i++) {
				temp = sensor2Distance[i];
				tempCounter = 0;

				for (int j = 1; j < sensor2Distance.length; j++) {
					if (temp == sensor2Distance[j])
						tempCounter++;
				}if (tempCounter > counter) {
					popular = temp;
					counter = tempCounter;
				}
				sensor2Measurement = popular;
			}

			//Compare the values of both sensors and return the lesser one, that number
			// being the distance to the closest object to the sensors, or -1 for an empty space.
			if (sensor1Measurement < sensor2Measurement) {
				return sensor1Measurement;
			} else {
				return sensor2Measurement;
			}

			//if sensor2 is not in the bounds of the street (for exmaple -2) then return the
			//value of the sensor1.
		} else {
			return sensor1Measurement;
		}

	}

	@Override
    //The method for moving the car backward
	public VehicleData moveBackward() {
            if (vehicleData.getPosition() !=0 ){
                vehicleData.setPosition(vehicleData.getPosition() -1);
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
