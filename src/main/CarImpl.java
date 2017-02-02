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
		sensor = new Sensor();
	}
        
	@Override
	public VehicleData moveForward() {
            if(vehicleData.getPosition() != 500){
                vehicleData.setPosition(vehicleData.getPosition() +1);
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

		/*//If sensor 2 is in the range of the street, between 0 & 500
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
		}*/
		return sensor1Measurement;
	}

	@Override
	public VehicleData moveBackward() {
            if (vehicleData.getPosition() !=0 ){
                vehicleData.setPosition(vehicleData.getPosition() -1);
            }
            return vehicleData;
	}


	@Override
	public void park() {
		if (vehicleData.getPosition() < 500){

			while (vehicleData.getPosition() < 500){
				moveForward();

			}
		}
		
	}

	@Override
	public void unPark() {
		
	}

	@Override
	public VehicleData whereIs() {
		return vehicleData; //Returns the expected vehicle data
	}

	// Additional methods


    public void prallelPark(){
		vehicleData.setPosition(vehicleData.getFreeSpace());
		vehicleData.setParked(true);
    }

}
