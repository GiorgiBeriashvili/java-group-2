package dev.beriashvili.practice;

import java.util.ArrayList;

class CollectionsDemo {
    private ArrayList<Object> arrayList = new ArrayList<>();
    private ArrayList<Integer> integerArrayList = new ArrayList<>();

    void addToArrayList() {
        this.arrayList.add(12);
        this.arrayList.add("Hello");
        this.arrayList.add(new int[]{2, 3, 4});

        Person person = new Person();
        person.name = "Giorgi";
        person.age = 20;
        this.arrayList.add(person);

        this.integerArrayList.add(23);
//        this.integerArrayList.add("Hello");
    }

    void printArrayList() {
        System.out.println(arrayList);
        System.out.println(integerArrayList);
    }
}
