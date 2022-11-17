package manager.actions;

import manager.BudgetManager;
import manager.Expense;
import manager.Reader;

/**
 * @author Dominik_Janiga
 */
class Income implements Action {

    private final BudgetManager budgetManager;
    private final Reader reader;

    Income(BudgetManager budgetManager, Reader reader) {
        this.budgetManager = budgetManager;
        this.reader = reader;
    }

    @Override
    public void perform() {
        System.out.println("Enter income:");
        double income = this.reader.readReadAmount();
        this.budgetManager.addIncome(income);
        System.out.println("Income was added!\n");
    }
}
