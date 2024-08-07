package com.niantic.part_3_challenge;

public class Refrigerator
{
    private int currentTemperature;
    private int maxCapacity;
    private int availableSpace;
    private boolean isDoorOpen = false;

    public Refrigerator(int currentTemperature, int maxCapacity)
    {
        this.currentTemperature = currentTemperature;
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentTemperature() {return currentTemperature;}

    public int getMaxCapacity() {return maxCapacity;}

    public boolean isDoorOpen() {return isDoorOpen;}

    public void openDoor()
    {
        isDoorOpen = true;
    }

    public void closeDoor()
    {
        isDoorOpen = false;
    }

    public void addItem()
    {
        if(isDoorOpen = true && availableSpace > 0 )
        {
            availableSpace--;
        }
    }

    public void removeItem()
    {
        if(isDoorOpen = true)
        {
            availableSpace++;
        }
    }
}