package dev.beriashvili.practice.lectures;

public class LecturerInfo {
    String name;
    String lastName;
    int age;

    public void setData(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    protected void print() {
        System.out.println(String.format("%s %s is %d years old.", this.name, this.lastName, this.age));
    }
}
