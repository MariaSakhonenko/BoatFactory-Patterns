package com.example;

public abstract class BoatBuilder
{
    protected Boat boat;

    public Boat getBoat()
    {
        return boat;
    }

    public abstract void createNewBoatProduct();
    public abstract void buildId(int id);
    public abstract void buildType();
    public abstract void buildModel(String model);
    public abstract void buildEnginePower(int enginePower);
    public abstract void buildMaxSpeed(int maxSpeed);
    public abstract void buildReleaseDate();
    public abstract void buildPrice(double price);
}
