package main;

import java.util.ArrayList;

public class VehicleData {
    
    private int position;
    private boolean isParked;
    private ArrayList<Integer> freeSpace;

    public VehicleData() {
        position = 0;
        isParked = false;
        freeSpace = new ArrayList<Integer>();
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
    
    
}
