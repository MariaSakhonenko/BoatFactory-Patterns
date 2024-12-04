package com.example;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class BoatFactorySingleton
{
    private static BoatFactorySingleton instance;

    private BoatFactorySingleton() {}

    public static synchronized BoatFactorySingleton getInstance()
    {
        if (instance == null)
        {
            instance = new BoatFactorySingleton();
        }
        return instance;
    }

    public void createBoats()
    {
        BoatDirector director = new BoatDirector();

        SailboatBuilder sailboatBuilder = new SailboatBuilder();
        director.setBoatBuilder(sailboatBuilder);
        director.constructBoat(1, "Model X", 100, 50, 50000.00);
        Sailboat sailboat = (Sailboat) director.getBoat();
        sailboatBuilder.buildSailArea(200);

        MotorboatBuilder motorboatBuilder = new MotorboatBuilder();
        director.setBoatBuilder(motorboatBuilder);
        director.constructBoat(2, "Model Y", 200, 80, 70000.00);
        Motorboat motorboat = (Motorboat) director.getBoat();
        motorboatBuilder.buildFuelCapacity(500);

        CatamaranBuilder catamaranBuilder = new CatamaranBuilder();
        director.setBoatBuilder(catamaranBuilder);
        director.constructBoat(3, "Model Z", 150, 60, 80000.00);
        Catamaran catamaran = (Catamaran) director.getBoat();
        catamaranBuilder.buildPassengerCapacity(20);

        BoatList boatList = new BoatList();
        boatList.addBoat(sailboat);
        boatList.addBoat(motorboat);
        boatList.addBoat(catamaran);

        BoatMap boatMap = new BoatMap();
        boatMap.addBoat(sailboat);
        boatMap.addBoat(motorboat);
        boatMap.addBoat(catamaran);

        performOperations(boatList);
    }

    private void performOperations(BoatList boatList)
    {
        System.out.println("\nПервичный вывод списка лодок:");
        boatList.getBoats().forEach(System.out::println);

        try
        {
            BoatFileManager.writeBoatsToFile(boatList.getBoats(), "boats.dat");

            List<Boat> boatsFromFile = BoatFileManager.readBoatsFromFile("boats.dat");
            System.out.println("\nВывод списка лодок после чтения из файла boats.dat:");
            boatsFromFile.forEach(System.out::println);

            XMLHandler.writeBoatsToXML(boatList.getBoats(), "boats.xml");

            List<Boat> boatsFromXML = XMLHandler.readBoatsFromXML("boats.xml");
            System.out.println("\nВывод списка лодок после чтения из XML boats.xml:");
            boatsFromXML.forEach(System.out::println);

            JSONHandler.writeBoatsToJSON(boatList.getBoats(), "boats.json");

            List<Boat> boatsFromJSON = JSONHandler.readBoatsFromJSON("boats.json");
            System.out.println("\nВывод списка лодок после чтения из JSON boats.json:");
            boatsFromJSON.forEach(System.out::println);

            SecretKey secretKey = EncryptionUtil.generateKey();
            EncryptionUtil.encryptFile("boats.json", "boats_encrypted.json", secretKey);
            EncryptionUtil.decryptFile("boats_encrypted.json", "boats_decrypted.json", secretKey);

            List<Boat> originalBoats = JSONHandler.readBoatsFromJSON("boats.json");
            List<Boat> decryptedBoats = JSONHandler.readBoatsFromJSON("boats_decrypted.json");

            if (originalBoats.equals(decryptedBoats))
            {
                System.out.println("\nСодержимое файлов идентично. Шифрование и дешифрование выполнены успешно.");
            }
            else
            {
                System.out.println("\nСодержимое файлов отличается. Проверьте алгоритмы шифрования и дешифрования.");
            }

            ZipUtil.zipFile("boats.json", "boats.zip");

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
