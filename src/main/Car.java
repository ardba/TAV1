package main;

public interface Car {

	
////TODO add params and stuff
    /**
     Description:This method moves the car 1 meter forward, queries the two infrared sensors through the isEmpty method described below and returns a data structure that contains the current position of the car,  and the situation of the detected parking places up to now. The car cannot be moved forward beyond the end of the street.
     Pre-condition: The car is at the beginning of the street and the car is not parked.
     Post-condition: The car is at the end of the street.

     Test-cases:
     TC 1.3.
     Requirement: This method moves the car 1 meter forward.
     Test: Create car at the beginning of the street. Move forward. Expected output: Position 1.
     TC 1.2.
     Requirement: The car cannot be moved forward beyond the end of the street.
     Test: Create car at the beginning of the street. Move car forward 500 times. Expected output: Position 499.
     */

    public VehicleData moveForward(); // Return type set to VehicleData due to moveForward() TC2.


	/**
	 Description: This method is queries the two sensors in the car, one in the front & one in
	 the back, and returns the distance to the object closest to either of the two.
	 Pre-condition: The car is within the bounds of the street.
	 Post-condition: The sensors have measured the distance to objects closest to the car's right hand side.
	 Test-cases:
	 TC1. Measure distance while parked. Expected output: Distance -1 (meaning empty)
     TC2. Measure distance when the car is out of the bounds of the street at position 530.
            Expected output: Sensors return 201, indicating an error.
	 TC2. Measure distance while sensor 2 is out of the bounds of the street at position 0.
            Expected output: Distance between 0 and 200, or -1.
	 TC3. Measure distance while sensor 1 is out of the bounds of the street at position 503.
            Expected output: Distance between 0 and 200.
	 TC4. Measure distance while one of the two sensors returns faulty information.
	 		Expected output: The faulty sensor is identified and disabled.
	 */
	public int isEmpty();

    /**
     Description: The car moves 1m backward. If the car is on the  beginning of the street, it can not move backward.
     Pre-condition: The car is on the street.
     Post-condition: Post-condition: The car is moved 1 position backward.

     Test-cases:
     TC 3.1:
     Requirement: The car moves 1m backward.
     Test:  Create car at the beginning of the street. Move car forward 499 times. Move car backward .Expected output: Car is on position 498.
     TC 3.2:
     Requirement: If the car is on the  beginning of the street, it can not move backward.
     Test: Create car at the beginning of the street. The car moves backward. Expected output: Position 0.
     */

    public VehicleData moveBackward(); // Return type set to VehicleData due to moveBackward() TC1.

	/**
	 Description: If the car has found a parking space already, it goes to the beginning of the parking space and
	 performs a parallel parking. If the place is not found yet it moves forward until the end of the street, if it
	 finds space, does as described above.
	 Pre-condition: The car is not parked.
	 Post-condition: The car is parked or the car is at the end of the street.
	 Test-cases:
	 TC4.1: testParkWhenParked(): If car is parked, it can not execute park();
	 TC4.2: testParkWhenParkingSpaceAlreadyFound(): Even though not realistic, but according to the method description
	 if a car has already found a parking space but is somewhere ahead of it, it goes back until the beginning of a
	 parking space and then parks;
	 TC4.3: testParkWithStreetOneParkingSpace(): When a car is on a street and this method is executed, car should
	 go along the street and search for a parking space, when found, stop at the beginning of the parking space and
	 park;
	 TC4.4: testParkWhenStreetIsFull(): When a car is on a street and this method is executed, car should
	 go along the street and search for a parking space if no space found it should go to the end of a stret;
	 TC4.5: testParkWithStreetIsEmpty(): When a car is on a street and this method is executed, car should
	 go along the street and search for a parking space, if street is empty it should park at the first available
	 parking space;
	 */
	public void park();

	/**
	 Description: The car is set to not parked and moves to the front of the parking space where it was parked.
	 Pre-condition: The car status is parked.
	 Post-condition: The car status is not parked and it's location is in front of where it was previously parked.
	 Test-cases:
	 TC1: testUnParkWhenCarIsParked:  The car drives out of the parking place. Expected output: Car moved five meters and its stated as unparked.
	 TC2: testUnParkWhenCarIsNotParked: The car is not parked. Expected output: The status of the car isn't changed.
	 */
	public void unPark();

	/**
	 Description: Returns the car's vehicle data, containing its location and parking status.
	 Pre-condition: The car is initialized
	 Post-condition: vehicleData containing location and distance is returned
	 Test-cases:
	 testWhereIs: Expected output: The car's vehicle data.
	 */
	public VehicleData whereIs();

	/**
	 Description: Sets the car actuators.
	 Pre-condition: The car is initialized.
	 Post-condition: Car has an actuator.
	 Test-cases: NO TEST CASE
	 */
	public void setActuator(Actuator actuator);
	public void setSensors (Sensor sensorFront, Sensor sensorBack);

}
