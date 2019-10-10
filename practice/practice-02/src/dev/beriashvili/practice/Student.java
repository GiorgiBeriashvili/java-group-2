package dev.beriashvili.practice;

public class Student implements IStudent {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {
        System.out.println(name);
    }

    @Override
    public int getAge() {
        return 0;
    }
}
