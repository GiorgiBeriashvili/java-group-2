package dev.beriashvili.classwork.second_exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FamilyMember {
    /*
     * განსაზღვრეთ კლასი FamilyMember ოთხი დახურული თვისებით: name, lastName, age, status.
     * */
    private String name, lastName, status;
    private int age;

    /*
     * დაწერეთ FamilyMember კონსტრუქტორი, რომელიც უზრუნველყოფს თვისებების ინი-
     * ციალიზაციას.
     * */
    public FamilyMember(String name, String lastName, int age, String status) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.status = status;
    }

    /*
     * დაწერეთ მეთოდი, რომელიც family.txt ფაილში დაამატებს FamilyMember-ის ტიპის
     * ობიექტის ველების მნიშვნელობას ცალკე ხაზზე.
     * */
    public void writeFieldsToFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("family.txt", false));

            bufferedWriter.write(String.format("Name: %s\n", this.name));
            bufferedWriter.write(String.format("Last Name: %s\n", this.lastName));
            bufferedWriter.write(String.format("Age: %d\n", this.age));
            bufferedWriter.write(String.format("Status: %s\n", this.status));

            bufferedWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /*
     * დაწერეთ მეთოდი, რომელიც FamilyMember ტიპის ობექტს საშუალებას მისცემს მიმართოს
     * FamilyBudget ტიპის ობიექტს და მოსთხოვოს თანხა, თანხის მიღება განხორციელდება იმ
     * შემთხვევაში თუ money ველში მოთხოვნილ თანხაზე მეტი თანხაა.
     * */
    public int requestFamilyBudget(FamilyBudget familyBudget, int requestedAmount) {
        if (requestedAmount > 0) {
            if (requestedAmount <= familyBudget.getBudget()) {
                familyBudget.money -= requestedAmount;
                familyBudget.saveBudgetState(familyBudget.money);

                return familyBudget.getBudget();
            } else {
                System.out.println("Cannot request budget above available budget (returning -1).");

                return -1;
            }
        } else {
            System.out.println("Cannot request budget below 0 (returning -1).");

            return -1;
        }
    }
}
