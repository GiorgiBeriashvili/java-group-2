package dev.beriashvili.homework.galaxy;

import java.util.HashMap;

public class Star {
    String name;
    double diameter;
    double temperature;
    HashMap<String, Planet> planets = new HashMap<>();

    @Override
    public String toString() {
        return "Star{" +
                "name='" + name + '\'' +
                ", diameter=" + diameter +
                ", temperature=" + temperature +
                ", planets=" + planets +
                '}';
    }

    void addPlanet(Planet planet) {
        planets.put(planet.name, planet);
    }
}
