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
        System.out.println(String.format("Getting family's budget: %d", familyMember.getFamilyBudget(familyBudget, 10_000)));
    }
}
