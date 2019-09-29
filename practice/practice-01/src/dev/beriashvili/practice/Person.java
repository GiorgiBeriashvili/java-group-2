package dev.beriashvili.practice;

public class Person {
    String firstName;
    public String lastName;
    private int age;

    public void printData() {
        System.out.println(String.format("%s %s", this.firstName, this.lastName));
    }
}
