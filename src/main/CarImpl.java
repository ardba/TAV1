package main;


public class CarImpl implements Car {

    private VehicleData vehicleData; // Return type set to VehicleData due to moveForward() TC2.
	private Sensor sensorFront;
	private Sensor sensorBack;
    public static final int SENSOR_FRONT = 0;
    public static final int SENSOR_BACK = 1;
    private Actuator actuator;


    public CarImpl() {

	    this.vehicleData = new VehicleData();
    }


	@Override
    //The method for moving the car forward
    public VehicleData moveForward() { // Return type set to VehicleData due to moveForward() TC1.1.
        if(vehicleData.getPosition() != 500){ // If statement for checking if position is not 499 is created in moveForward() TC 1.2.

            if (isEmpty() == -1){
                vehicleData.setFreeSpace(vehicleData.getPosition(), true);
            }
            else {
                vehicleData.setFreeSpace(vehicleData.getPosition(), false);
            }
         //   vehicleData.setPosition(vehicleData.getPosition() +1); // Added due to moveForward() TC1.1.
            vehicleData.setPosition(vehicleData.getPosition() + actuator.moveForward());
	    }
            return vehicleData;
    }

	@Override
	public int isEmpty() {
        int counter = 1, tempCounter;
        int temp;

        //If car is parked return -1
        if (vehicleData.isParked()) {
            return -1;
        }


        int sensorFrontPos = vehicleData.getPosition();
        int sensorBackPos = sensorFrontPos - 5;
        int sensorFrontMeasurement = 201, sensorBackMeasurement = 201;


        if (sensorFront.isActive()) {               //If the front sensor has been working properly
            if (sensorFrontPos < 500 && sensorFrontPos >= 0) {
                //Loop the 5 measurements and get rid of the noise by choosing the value
                //that shows up the most times.
                int[] sensorFrontDistance = sensorFront.getDistance(sensorFrontPos);
                int popular = sensorFrontDistance[0];


                for (int i = 0; i < (sensorFrontDistance.length - 1); i++) {
                    temp = sensorFrontDistance[i];
                    tempCounter = 0;

                    //Broken sensor test case: If the sensor gives unreasonable data, disable it.
                    if(temp > 201) sensorFront.disable();

                    for (int j = 1; j < sensorFrontDistance.length; j++) {
                        if (temp == sensorFrontDistance[j])
                            tempCounter++;
                    }
                    if (tempCounter > counter) {
                        popular = temp;
                        counter = tempCounter;
                    }
                    sensorFrontMeasurement = popular;
                }
            }
        }


        if (sensorBack.isActive()) {
            //If sensor 2 is in the range of the street, between 0 & 500
            if (sensorBackPos >= 0 && sensorBackPos < 500) {
                int[] sensorBackDistance = sensorBack.getDistance(sensorBackPos);
                counter = 1;
                int popular = sensorBackDistance[0];

                //The following loop contains the necessary logic to filter out the noise created by the sensors
                //It works by filtering out the most common measurement out of an array[5] representing
                //the five measurements the sensor makes for a specific meter.

                for (int i = 0; i < (sensorBackDistance.length - 1); i++) {
                    temp = sensorBackDistance[i];
                    tempCounter = 0;

                    if(temp > 201) sensorBack.disable(); //If the sensor gives unreasonable data, disable it.

                    for (int j = 1; j < sensorBackDistance.length; j++) {
                        if (temp == sensorBackDistance[j])
                            tempCounter++;
                    }
                    if (tempCounter > counter) {
                        popular = temp;
                        counter = tempCounter;
                    }
                    sensorBackMeasurement = popular;
                }
            }
        }

        if(!sensorFront.isActive())         //If front sensor is broken
            return sensorBackMeasurement;      //Return measurements of back sensor

        if(!sensorBack.isActive())          //If back sensor is broken
            return sensorFrontMeasurement;      //Return measurements of front sensor


        //Returns the nearest distance recorded by either one of the sensors
        if (sensorFrontMeasurement <= sensorBackMeasurement) {
            return sensorFrontMeasurement;
        } else {
            return sensorBackMeasurement;
        }
    }

	@Override
    //The method for moving the car backward
    public VehicleData moveBackward() { // Return type set to VehicleData due to moveBackward() TC3.1.
        if (vehicleData.getPosition() !=0 ){ //// If statement for checking if position is not 0 is created in moveBackward() TC 3.2.
            //vehicleData.setPosition(vehicleData.getPosition() -1); //  // Added due to moveBackward() TC3.1.
            vehicleData.setPosition(vehicleData.getPosition() + actuator.moveBackward());
        }
        return vehicleData;
    }


	@Override
	public void park() {

        if (!vehicleData.isParked()) { // Car should not be parked (TC4.1)
            if (vehicleData.isParkingSpaceFound() && vehicleData.getPosition() > vehicleData.getParkingSpace()[4]){ //Car already knows where parking space and it is past it (TC4.2)
                while (vehicleData.getPosition() > vehicleData.getParkingSpace()[4]+1) {
                    moveBackward(); // Move car backwards until it reaches the parking space (TC4.2)
                }
                parallelPark();
            }
            else { // If parking space not found yet, car has to move forward and search for it (TC4.3)
                while (vehicleData.getPosition() < 499){ // If no parking space found, car should go to the end of street (TC4.4)
                    moveForward();
                    if (vehicleData.isParkingSpaceFound()) { // Car moves till the end of street until it finds a parking space (TC4.3, TC4.5)
                        park();
                        break;
                    }
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
    public void setActuator(Actuator actuator){
        this.actuator = actuator;
    };

    public void setSensors(Sensor sensorFront, Sensor sensorBack){
        this.sensorFront = sensorFront;
        this.sensorBack = sensorBack;
    };
}
