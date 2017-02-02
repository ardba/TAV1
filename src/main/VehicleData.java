package main;

public class VehicleData{
    
    private int position;
    private boolean isParked;
    private int freeSpace;

    public VehicleData() {
        position = 0;
        isParked = false;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean isParked) {
        this.isParked = isParked;
    }

    public int getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(int freeSpace) {
        this.freeSpace = freeSpace;
    }

    public boolean equals(VehicleData o) {
        if(o.getPosition() == this.position && (o.isParked() == this.isParked) && (this.freeSpace == o.getFreeSpace()))
            return true;
        else
            return false;
    }

}
