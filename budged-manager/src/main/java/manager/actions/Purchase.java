package manager.actions;

import manager.BudgetManager;
import manager.Expense;
import manager.Reader;
import manager.actions.Action;

/**
 * @author Dominik_Janiga
 */
class Purchase implements Action {

    private final BudgetManager budgetManager;
    private final Reader reader;

    Purchase(BudgetManager budgetManager, Reader reader) {
        this.budgetManager = budgetManager;
        this.reader = reader;
    }

    @Override
    public void perform() {
        System.out.println("\nEnter purchase name:");
        String purchaseName = this.reader.readText();
        System.out.println("Enter its price:");
        double purchasePrice = this.reader.readReadAmount();
        Expense expense = new Expense(purchaseName, purchasePrice);
        this.budgetManager.addExpense(expense);
        System.out.println("Purchase was added!\n");
    }
}

