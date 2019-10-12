package dev.beriashvili.practice.students;

public class PrintInfo {
    public PrintInfo(StudentInfo studentInfo) {
        System.out.println(String.format("Student's GPA is: %f", studentInfo.gpa));
    }
}
