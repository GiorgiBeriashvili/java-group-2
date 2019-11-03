package dev.beriashvili.classwork;

import dev.beriashvili.classwork.first_exercise.A;
import dev.beriashvili.classwork.second_exercise.FamilyBudget;
import dev.beriashvili.classwork.second_exercise.FamilyMember;

class Utils {
    static void main() {
        A firstExercise = new A();
        firstExercise.main();

        FamilyBudget familyBudget = new FamilyBudget();
        familyBudget.main();

        FamilyMember familyMember = new FamilyMember("Giorgi", "Beriashvili", 20, "Student");
        familyMember.writeFieldsToFile();

        int requestedAmount = 10_000;
        System.out.println(String.format("Result of requested budget (%d): %d", requestedAmount, familyMember.requestFamilyBudget(familyBudget, requestedAmount)));
    }
}
