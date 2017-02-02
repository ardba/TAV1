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

	public void unPark();

	public VehicleData whereIs();
}
