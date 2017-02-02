package main;

public interface Car {

	
////TODO add params and stuff
	/**
	 Description:This method is about moving the car 1m forward queries two
	 	sensors which checks if there is some empty space on the right side of the car
	 	and gives the current position of the car. The car cannot be moved forward beyond the end of the street.
	 Pre-condition: The car is at the beginning of the street and the car is not parked.
	 Post-condition: The car is at the end of the street.
	 Test-cases:
	 TC1.Create car at the beginning of the street. Expected output: Position 0m.
	 TC2. Move forward. Expected output: Position 1m and car not parked.
	 TC3. Move forward 499 times. Expected output: Position 500m.
	 TC4. Move forward. Expected output: Position 500m.
	 */
	public VehicleData moveForward();


	/**
	 Description: This method is queries the two sensors in the car, one in the front & one in
	 the back, and returns the distance to the object closest to either of the two.
	 Pre-condition: The car is within the bounds of the street.
	 Post-condition: The sensors have measured the distance to objects closest to the car's right hand side.
	 Test-cases:
	 TC1. Measure distance while parked. Expected output: Distance -1 (meaning empty)
	 TC2. Measure distance while in position 0. Expected output: Distance between 0 and 200, or -1.
	 TC3. Measure distance while in position 499. Expected output: Distance between 0 and 200.
	 */
	public int isEmpty();

	/**
	 Description: The car moves 1m backward. If the car is on the  beginning of the street, it can not move backward.
	 Pre-condition: The car is at the end of the street.
	 Post-condition: The car is at the beginning of the street.
	 Test-cases:
	 TC1:  The car moves 1m backward. Expected output: Car is on position 499m.
	 TC2: The car moves backward 499 times. Expected output: Position 0m.
	 TC3: The car moves backward. Expected output: Position 0m
	 */
	public VehicleData moveBackward();

	public void park();
	/**
	 Description: The car is set to not parked and moves to the front of the parking space where it was parked.
	 Pre-condition: The car status is parked.
	 Post-condition: The car status is not parked and it's location is in front of where it was previously parked.
	 Test-cases:
	 testUnParkWhenCarIsParked:  The car drives out of the parking place. Expected output: Car moved five meters and its stated as unparked.
	 testUnParkWhenCarIsNotParked: The car is not parked. Expected output: The status of the car isn't changed.
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
