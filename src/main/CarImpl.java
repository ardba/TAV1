package main;

public class CarImpl implements Car {

	private VehicleData vehicleData;

    public CarImpl() { //initialize vehicleData
        vehicleData = new VehicleData();
    }
        
	@Override
	public VehicleData moveForward() {
            if(vehicleData.getPosition() != 500){
                vehicleData.setPosition(vehicleData.getPosition() +1);
	}
            return vehicleData;
        }

	@Override
	public void isEmpty() {
		
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


    public void paralelPark(){
		vehicleData.setPosition(vehicleData.getFreeSpace());
		vehicleData.setParked(true);
    }

}
