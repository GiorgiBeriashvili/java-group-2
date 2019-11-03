package dev.beriashvili.classwork.second_exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FamilyBudget implements BudgetController {
    /*
     * განსაზღვრეთ კლასი FamilyBudget: მთელი ტიპის დახური money ცვლადით. ააგეთ მეთოდები
     * რომლებიც საშუალებას იძლევა money ცვლადში მნიშვნელობის მინიჭების, შეცვლის, მიღე-
     * ბის.
     * */
    int money = 0;

    public void main() {
        // Starting budget
        System.out.println(String.format("Starting budget is: %d", this.money));

        // Setting the budget
        setBudget();
        System.out.println(String.format("Set budget is: %d", this.money));

        // Updating the budget
        updateBudget(1_000);
        System.out.println(String.format("Updated budget is: %d", this.money));

        // Updating the budget
        updateBudget(-10_000);
        System.out.println(String.format("Updated budget is: %d", this.money));

        // Getting the budget
        System.out.println(String.format("The current budget is: %d", getBudget()));

        // Getting the family's budget condition
        System.out.println(getFamilyBudgetCondition(this.money));
    }

    // Set the budget
    @Override
    public void setBudget() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Set the budget: ");
        int queriedBudget = scanner.nextInt();

        if (queriedBudget < 0) {
            System.out.println("Cannot set the budget below 0.");
        } else {
            this.money = queriedBudget;

            saveBudgetState(this.money);
        }
    }

    // Update the budget
    @Override
    public void updateBudget(int amount) {
        if (this.money + amount < 0) {
            System.out.println("Cannot update the budget below 0.");
        } else {
            this.money += amount;
            saveBudgetState(this.money);
        }
    }

    // Get the budget
    @Override
    public int getBudget() {
        saveBudgetState(this.money);

        return this.money;
    }

    /*
     * დაწერეთ მეთოდი, რომელიც დაადგენს FamilyBudget მდგომარეობას money თვისების
     * მიხედვით. (თუ money მეტია 40 000-ზე მდიდარი, თუ მოთავსებულია 10000-დან 40 000-
     * მდე საშუალო, წინააღმდეგ შემთხვევაში ღარიბი).
     * */
    private String getFamilyBudgetCondition(int budget) {
        if (budget > 40_000) {
            return "The family seems to be rich.";
        } else if (budget > 10_000) {
            return "The family seems to be average.";
        } else {
            return "The family seems to be poor.";
        }
    }

    /*
     * დაწერეთ მეთოდი, რომელიც budget.txt ფაილში შეინახავს მოთხოვნი FamilyBudget-ის
     * money თვისების მდგომარეობას, ყოველი მისი ცვლილების დროს.
     * */
    void saveBudgetState(int budget) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("budget.txt", false));

            bufferedWriter.write(String.format("Current budget: %d\n", budget));

            bufferedWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
