package com.example;

import java.util.Scanner;

public class BoatFactory
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        BoatFactorySingleton factory = BoatFactorySingleton.getInstance();
        factory.createBoats();

        scanner.close();
    }
}
