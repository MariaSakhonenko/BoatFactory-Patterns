package com.example;

public class BoatDirector
{
    private BoatBuilder boatBuilder;

    public void setBoatBuilder(BoatBuilder boatBuilder)
    {
        this.boatBuilder = boatBuilder;
    }

    public Boat getBoat()
    {
        return boatBuilder.getBoat();
    }

    public void constructBoat(int id, String model, int enginePower, int maxSpeed, double price)
    {
        boatBuilder.createNewBoatProduct();
        boatBuilder.buildId(id);
        boatBuilder.buildType();
        boatBuilder.buildModel(model);
        boatBuilder.buildEnginePower(enginePower);
        boatBuilder.buildMaxSpeed(maxSpeed);
        boatBuilder.buildReleaseDate();
        boatBuilder.buildPrice(price);
    }
}
