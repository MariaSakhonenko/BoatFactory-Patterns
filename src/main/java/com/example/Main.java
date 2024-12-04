package com.example;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BoatList boatList = new BoatList();
        Sailboat sailboat = new Sailboat();
        sailboat.setId(1);
        sailboat.setType("Парусник");
        sailboat.setModel("Model X");
        sailboat.setEnginePower(100);
        sailboat.setMaxSpeed(50);
        sailboat.setReleaseDate(new Date());
        sailboat.setPrice(50000.00);
        sailboat.setSailArea(200);

        boatList.addBoat(sailboat);

        JSONHandler.writeBoatsToJSON(boatList.getBoats(), "boats_test.json");
        List<Boat> boatsFromJSON = JSONHandler.readBoatsFromJSON("boats_test.json");

        boatsFromJSON.forEach(System.out::println);
    }
}
