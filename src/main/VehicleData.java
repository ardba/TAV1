package main;

public class VehicleData{
    
    private int position;
    private boolean isParked;
    public boolean[] freeSpace;
    private boolean parkingSpaceFound;
    private int[] parkingSpace;

    public VehicleData() { // Implemented for testing moveForward() TC1.
        position = 0; // added for moveForward() TC2.
        isParked = false;
        parkingSpaceFound = false;
        freeSpace = new boolean[500];
        parkingSpace = new int[5];
    }

    public int getPosition() {
        return position;
    } // Implemented for testing of moveForward() TC1.

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
        for (int i = 4; i < freeSpace.length; i++){
            if (freeSpace[i] && freeSpace[i-1] && freeSpace[i-2] && freeSpace[i-3] && freeSpace[i-4]){
                parkingSpace = new int[]{i-4, i-3, i-2, i-1, i};
                parkingSpaceFound = true;
            }
        }
    }

    public void setStaticParkingSpace(){
        int counter = 0;
        parkingSpace = new int[5];
        for (int i = 450; i < 455; i++){
            parkingSpace[counter] = i;
            counter++;
        }
        parkingSpaceFound = true;
    }

}
