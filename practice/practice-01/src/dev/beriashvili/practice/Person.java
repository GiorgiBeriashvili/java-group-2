package dev.beriashvili.practice;

class Person {
    String firstName;
    String lastName;
    int age;

    void printData() {
        System.out.println(String.format("%s %s is %d years old.", this.firstName, this.lastName, this.age));
    }
}
