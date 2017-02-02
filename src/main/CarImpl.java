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
		
	}

	@Override
	public void whereIs() {
		
	}

	// Additional methods

	public VehicleData getVehicleData(){
        return vehicleData;
    }

    public void prallelPark(){

    }

}