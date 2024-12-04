package com.example;

import java.util.Date;

public class MotorboatBuilder extends BoatBuilder
{
    @Override
    public void createNewBoatProduct()
    {
        boat = new Motorboat();
    }

    @Override
    public void buildId(int id)
    {
        boat.setId(id);
    }

    @Override
    public void buildType()
    {
        boat.setType("Моторная лодка");
    }

    @Override
    public void buildModel(String model)
    {
        boat.setModel(model);
    }

    @Override
    public void buildEnginePower(int enginePower)
    {
        boat.setEnginePower(enginePower);
    }

    @Override
    public void buildMaxSpeed(int maxSpeed)
    {
        boat.setMaxSpeed(maxSpeed);
    }

    @Override
    public void buildReleaseDate()
    {
        boat.setReleaseDate(new Date());
    }

    @Override
    public void buildPrice(double price)
    {
        boat.setPrice(price);
    }

    public void buildFuelCapacity(int fuelCapacity)
    {
        ((Motorboat) boat).setFuelCapacity(fuelCapacity);
    }
}
