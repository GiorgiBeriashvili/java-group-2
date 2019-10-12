package dev.beriashvili.practice.btu;

import dev.beriashvili.practice.lectures.LecturerInfo;
import dev.beriashvili.practice.lectures.PrintInfo;
import dev.beriashvili.practice.students.StudentInfo;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LecturerInfo besik = new LecturerInfo();
        besik.setData("Besik", "Tabatadze", 40);
        PrintInfo besikInfo = new PrintInfo();
        besikInfo.printData(besik);

        LecturerInfo giorgi = new LecturerInfo();
        giorgi.setData("Giorgi", "Beriashvili", 20);
        PrintInfo giorgiInfo = new PrintInfo();
        giorgiInfo.printData(giorgi);

        StudentInfo mariam = new StudentInfo();
        mariam.setData("Mariam", 4.0);
        dev.beriashvili.practice.students.PrintInfo mariamInfo = new dev.beriashvili.practice.students.PrintInfo(mariam);

        try {
            FileWriter fileWriter = new FileWriter("file.txt");
            fileWriter.write("Hello, world!.");
            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
