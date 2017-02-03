package main;

public interface Car {

	
////TODO add params and stuff
    /**
     Description:This method moves the car 1 meter forward, queries the two infrared sensors through the isEmpty method described below and returns a data structure that contains the current position of the car,  and the situation of the detected parking places up to now. The car cannot be moved forward beyond the end of the street.
     Pre-condition: The car is at the beginning of the street and the car is not parked.
     Post-condition: The car is at the end of the street.

     Test-cases:
     TC1.
     Requirement: None. This is a base case interpreted by the team to get a starting point for further testing.
     Test: Create car at the beginning of the street. Expected output: Position 0.
     TC2.
     Requirement: This method moves the car 1 meter forward.
     Test: Create car at the beginning of the street. Move forward. Expected output: Position 1.
     TC3.
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
	 */
	public int isEmpty();

    /**
     Description: The car moves 1m backward. If the car is on the  beginning of the street, it can not move backward.
     Pre-condition: The car is not on the beginning of the street.
     Post-condition: Post-condition: The car is moved 1 position backward.

     Test-cases:
     TC1:
     Requirement: The car moves 1m backward.
     Test:  Create car at the beginning of the street. Move car forward 499 times. Move car backward .Expected output: Car is on position 498.
     TC2:
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
	 Pre-condition: -
	 Post-condition: -
	 Test-cases:
	 testWhereIs: Expected output: The car's vehicle data.
	 */
	public VehicleData whereIs();
}
