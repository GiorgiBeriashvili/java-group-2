package dev.beriashvili.homework.galaxy;

public class Planet {
    String name;
    String starSystem;
    double distance;
    double orbitalPeriod;
    double orbitalSpeed;

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", starSystem='" + starSystem + '\'' +
                ", distance=" + distance +
                ", orbitalPeriod=" + orbitalPeriod +
                ", orbitalSpeed=" + orbitalSpeed +
                '}';
    }

    public void setOrbitalPeriod(Star star) {
        orbitalPeriod = (2 * Math.PI * (star.diameter / 2 + distance)) / orbitalSpeed;
    }
}
