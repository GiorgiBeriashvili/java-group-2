package dev.beriashvili.practice;

public class Main {
    public static void main(String[] args) {
	    TestException testException = new TestException();
        System.out.println("Before exception.");
        testException.exceptionOne();
        System.out.println("After exception.");

        try {
            testException.exceptionTwo();
        } catch (Exception error) {
            error.printStackTrace();
        }

        Student student = new Student();
        student.getAge();
        student.setName("Giorgi Beriashvili");
        student.getName();
    }
}
