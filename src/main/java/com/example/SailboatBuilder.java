package com.example;

import java.util.Date;

public class SailboatBuilder extends BoatBuilder
{
    @Override
    public void createNewBoatProduct()
    {
        boat = new Sailboat();
    }

    @Override
    public void buildId(int id)
    {
        boat.setId(id);
    }

    @Override
    public void buildType()
    {
        boat.setType("Парусник");
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

    public void buildSailArea(int sailArea)
    {
        ((Sailboat) boat).setSailArea(sailArea);
    }
}
