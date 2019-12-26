package dev.beriashvili.homework.galaxy;

import dev.beriashvili.homework.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Cosmos {
    /*
     * გალაქტიკა (3 ქულა)
     * კონსოლური აპლიკაცია, რომელიც საშუალებას იძლევა ავაგოთ გალაქტიკა.
     * პროგრამის ჩატვირთვისას ჩნდება წარწერა, შექმენით ვარსკვლავი. ამის შემდეგ ეტაპობრივად
     * შესაძლებელია ვარსკვლავის მახასიათებლების შეყვანა. სახელი, დიამეტრი, ტემპერატურა. ვარსკვლავის
     * გარშემო ტრიალებენ პლანეტები. ამიტომ შეგვიძლია პლანეტების შექმნა. როდესაც პლანეტას ქმნით,
     *
     * მიუთითეთ სახელი, ვარსკვლავი რომლის გარშემო ტრიალებს, რა მანძილითაა დაშორებული ვარ-
     * სკვლავისგან და რა სიჩქარით გადაადგილდება სივრცეში. ბრძანებით შესაძლებელია თითოეული
     *
     * პლანეტის გამოძახება და თვისებების ნახვა. პლანეტის გამოძახებისას უნდა გამოჩნდეს, რა დროს
     * ანდომებს ის ვარსკვლავის გარშემო გადაადგილებას. (ეს პროგრამამ უნდა გამოთვალოს). პროგრამამ უნდა
     * შეძლოს პლანეტების გამოძახება პირდაპირ მათი სახელით. ასევე უნდა შეძლოს მთლიანი გალაქტიკის
     * დათვალიერება, ვარსკვლავებითა და მათ გარშემო მოძრავი პლანეტებით.
     * მონაცემები პლანეტების და ვარსკვლავების შესახებ იწერება ფაილში.
     * */
    int option;
    Galaxy galaxy;
    Scanner scanner;
    boolean onRepeat = true;
    boolean retry;

    void main() {
        while (onRepeat) {
            option = getMenuOption();
            handleMenuOption(option);
        }

        System.out.println("Exiting out of the program.");
    }

    public void initialize() {
        System.out.println("You can forge virtual celestial bodies through this program!\n");

        galaxyCreation();
        starCreation();
        planetCreation();

        main();
    }

    void handleMenuOption(int option) {
        System.out.println();

        scanner = new Scanner(System.in);

        switch (option) {
            case 0:
                onRepeat = false;
                break;
            case 1:
                starCreation();
                break;
            case 2:
                planetCreation();
                break;
            case 3:
                System.out.print("Enter the name of the planet: ");
                System.out.println(String.format("\nPlanet data: %s", getPlanetData(scanner.nextLine())));
                System.out.println();
                break;
            case 4:
                System.out.println(String.format("Planet data: %s", getPlanetData()));
                System.out.println();
                break;
            case 5:
                System.out.println(String.format("Galaxy data: %s", getGalaxyData()));
                System.out.println();
                break;
            case 6:
                System.out.println("Storing the galaxy's data...");
                storeData();
                System.out.println("The data has been stored successfully!");
                System.out.println();
                break;
            default:
                System.out.println("\nInvalid input. Please re-enter an option.\n");
                getMenuOption();
                break;
        }
    }

    int getMenuOption() {
        retry = true;

        while (retry) {
            try {
                System.out.println("Choose one of the options below.");

                scanner = new Scanner(System.in);

                System.out.println("0. Exit");
                System.out.println("1. Create a star");
                System.out.println("2. Create a planet");
                System.out.println("3. View planet attributes");
                System.out.println("4. View planets alongside their attributes");
                System.out.println("5. View galaxy attributes");
                System.out.println("6. Store the data on the storage device\n");

                System.out.print("Your choice: ");
                return scanner.nextInt();
            } catch (Exception error) {
                System.out.println("\nInvalid input. Please re-enter an option.\n");
            }
        }

        return 0;
    }

    void galaxyCreation() {
        System.out.println("Initializing the galaxy creation method...\n");

        System.out.println("Milky Way has been created.");
        galaxy = new Galaxy("Milky Way");

        System.out.println();
    }

    void starCreation() {
        retry = true;

        while (retry) {
            try {
                System.out.println("Initializing the star creation method... enter the star's attributes below.\n");

                scanner = new Scanner(System.in);
                Star star = new Star();

                System.out.print("Name: ");
                star.name = scanner.nextLine();

                System.out.print("Diameter (km): ");
                star.diameter = scanner.nextDouble();

                System.out.print("Temperature (kelvin): ");
                star.temperature = scanner.nextDouble();

                galaxy.addStar(star);

                System.out.println();

                retry = false;
            } catch (Exception error) {
                System.out.println("\nInvalid input. Retrying...\n");
            }
        }
    }

    void planetCreation() {
        retry = true;

        while (retry) {
            try {
                System.out.println("Initializing the planet creation method... enter the planet's attributes below.\n");

                scanner = new Scanner(System.in);
                Planet planet = new Planet();

                System.out.print("Name: ");
                planet.name = scanner.nextLine();

                System.out.print("Star System: ");
                planet.starSystem = scanner.nextLine();

                System.out.print("Distance (km): ");
                planet.distance = scanner.nextDouble();

                System.out.print("Orbital speed (km/h): ");
                planet.orbitalSpeed = scanner.nextDouble();

                for (Star star : galaxy.stars.values()) {
                    if (star.name.equals(planet.starSystem)) {
                        planet.setOrbitalPeriod(star);
                    }
                }

                galaxy.stars.get(planet.starSystem).addPlanet(planet);

                System.out.println();

                retry = false;
            } catch (Exception error) {
                System.out.println("\nInvalid input. Retrying...\n");
            }
        }
    }

    String getPlanetData(String planetName) {
        for (Star star : galaxy.stars.values()) {
            if (star.planets.containsKey(planetName)) {
                return star.planets.get(planetName).toString();
            }
        }

        return String.format("%s not found.", planetName);
    }

    ArrayList<String> getPlanetData() {
        ArrayList<String> planetData = new ArrayList<>();

        for (Star star : galaxy.stars.values()) {
            for (Planet planet : star.planets.values()) {
                planetData.add(planet.toString());
            }
        }

        return planetData;
    }

    String getGalaxyData() {
        return galaxy.toString();
    }

    void storeData() {
        File directory = Utils.getDirectory("data");
        final File file = new File(String.format("%s/%s", directory.getPath(), "data.txt"));

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            for (Map.Entry<String, Star> star : galaxy.stars.entrySet()) {
                bufferedWriter.write(String.format("Name -> %s:\n", star.getValue().name));
                bufferedWriter.write(String.format("    Diameter -> %s:\n", star.getValue().diameter));
                bufferedWriter.write(String.format("    Temperature -> %s:\n\n", star.getValue().temperature));

                for (Map.Entry<String, Planet> planet : star.getValue().planets.entrySet()) {
                    bufferedWriter.write(String.format("    Planet -> %s:\n", planet.getValue().name));
                    bufferedWriter.write(String.format("        Distance -> %s:\n", planet.getValue().distance));
                    bufferedWriter.write(String.format("        Orbital Speed -> %s:\n", planet.getValue().orbitalSpeed));
                    bufferedWriter.write(String.format("        Orbital Period -> %s:\n\n", planet.getValue().orbitalPeriod));
                }

                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }

            bufferedWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
