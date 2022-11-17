package manager.actions;

import manager.BudgetManager;
import manager.Reader;

/**
 * @author Dominik_Janiga
 */
class Balance implements Action {

    private final BudgetManager budgetManager;

    Balance(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public void perform() {
        this.budgetManager.printBalance();
    }
}
