package main;

import java.util.ArrayList;
import java.util.List;

public class VehicleData{
    
    private int position;
    private boolean isParked;
    private List<Boolean> freeSpace = new ArrayList<>();
    private boolean parkingSpaceFound;
    private int[] parkingSpace;

    public VehicleData() {
        position = 0;
        isParked = false;
        parkingSpaceFound = false;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (position > 499) {
            this.position = 499;
        } else if (position < 0) {
            this.position = 0;
        } else {
            this.position = position;
        }
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean isParked) {
        this.isParked = isParked;
    }

    public List<Boolean> getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(boolean isEmpty) {
        this.freeSpace.add(isEmpty);
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

            if (freeSpace.get(position-1) == true &&
                    freeSpace.get(position-2) == true &&
                    freeSpace.get(position-3) == true &&
                    freeSpace.get(position-4) == true &&
                    freeSpace.get(position-5) == true){
                parkingSpace = new int[]{position, position-1, position-2, position-3, position-4};
                parkingSpaceFound = true;
            }
        }
    }

}
