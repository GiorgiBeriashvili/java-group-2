package dev.beriashvili.homework.galaxy;

import java.util.HashMap;

public class Galaxy {
    String name;
    HashMap<String, Star> stars = new HashMap<>();

    public Galaxy(String name) {
        this.name = name;
    }

    void addStar(Star star) {
        stars.put(star.name, star);
    }

    @Override
    public String toString() {
        return "Galaxy{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                '}';
    }
}
