package main;

/**
 * Created by Andres on 2017-02-15.
 */
public interface Sensor {

    public void createStreet(int streetVariation);

    public int[] getDistance (int position);
    public void createStreet();
    public void addNoise();
    public void addEmptySpace();
    public void addStaticEmptySpace();
    public void disable();

    public boolean isActive();
}
