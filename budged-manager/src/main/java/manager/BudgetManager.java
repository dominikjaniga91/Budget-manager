package manager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dominik_Janiga
 */
public class BudgetManager {

    private final Account account;
    private final List<Expense> expenses = new ArrayList<>();

    public BudgetManager(Account account) {
        this.account = account;
    }

    public void addIncome(final double income) {
        this.account.addIncome(income);
    }

    public void addExpense(Expense expense) {
        if (this.account.canPurchase(expense)) {
            this.expenses.add(expense);
            this.account.addPurchase(expense.getAmount());
        }
    }

    public void showExpenses() {
        if(this.expenses.isEmpty()) {
            System.out.println("\nThe purchase list is empty\n");
        } else {
            this.expenses.forEach(System.out::println);
            double expensesSum = sumExpenses(expenses);
            System.out.printf("Total sum: $%.2f%n%n", expensesSum);
        }
    }

    public void printBalance() {
        this.account.printBalance();
    }

    private double sumExpenses(List<Expense> expenses) {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }
}

