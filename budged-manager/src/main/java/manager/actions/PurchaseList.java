package manager.actions;

import manager.BudgetManager;
import manager.Expense;
import manager.Reader;

/**
 * @author Dominik_Janiga
 */
class PurchaseList implements Action {

    private final BudgetManager budgetManager;

    PurchaseList(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public void perform() {
        this.budgetManager.showExpenses();
    }
}
