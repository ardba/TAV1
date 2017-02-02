package main;

public class VehicleData{
    
    private int position;
    private boolean isParked;
    private boolean[] freeSpace;
    private boolean parkingSpaceFound;
    private int[] parkingSpace;

    public VehicleData() { // Implemented for testing moveForward() TC1.
        position = 0; // added for moveForward() TC2.
        isParked = false;
        parkingSpaceFound = false;
        freeSpace = new boolean[500];
    }

    public int getPosition() {
        return position;
    } // Implemented for testing of moveForward TC1.

    public void setPosition(int position) {
            this.position = position;
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean isParked) {
        this.isParked = isParked;
    }


    public void setFreeSpace(int position, boolean isEmpty) {
        this.freeSpace[position] = isEmpty;
    }

    public boolean equals(VehicleData o) {
        if((o.getPosition() == this.position) && (o.isParked() == this.isParked)){
            return true;
        }
        else{
            return false;
        }
    }

    public int[] getParkingSpace(){
        return parkingSpace;
    }

    public boolean isParkingSpaceFound(){
        setParkingSpace();
        return this.parkingSpaceFound;
    }

    public void setParkingSpace(){
        if (position > 4 && position < 500){

            for (int i = 0; i < freeSpace.length; i++){
                if (freeSpace[i] && freeSpace[i-1] && freeSpace[i-2] && freeSpace[i-3] && freeSpace[i-4]){
                    parkingSpace = new int[]{i-4, i-3, i-2, i-1, i};
                    parkingSpaceFound = true;
                }
            }
        }
    }

}
