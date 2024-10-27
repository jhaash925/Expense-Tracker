import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    calculateTotalExpenses();
                    break;
                case 4:
                    System.out.println("Exiting the Expense Tracker. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addExpense(Scanner scanner) {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Expense expense = new Expense(description, amount);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        System.out.println("\nExpenses:");
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.getDescription());
            System.out.println("Amount: " + expense.getAmount());
            System.out.println("-----------------");
        }
    }

    static void calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("\nTotal Expenses: " + total);
    }
}

class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}