package main;

public class CarImpl implements Car {
	
	boolean isParked;
	VehicleState vehicleState;

    public CarImpl() { //initialize vehicleState
        vehicleState = new VehicleState();
    }
        
	@Override
	public VehicleState MoveForward() {
           vehicleState.setPosition(vehicleState.getPosition() +1);
           return vehicleState;	
	}

	@Override
	public void isEmpty() {
		
	}

	@Override
	public VehicleState MoveBackward() {
             vehicleState.setPosition(vehicleState.getPosition() -1);
            return vehicleState;
		
	}

	@Override
	public void Park() {
		
	}

	@Override
	public void UnPark() {
		
	}

	@Override
	public void WhereIs() {
		
	}

}
