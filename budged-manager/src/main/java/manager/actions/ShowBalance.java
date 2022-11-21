package manager.actions;

import manager.budget.BudgetManager;

/**
 * @author Dominik_Janiga
 */
public class ShowBalance implements Action {

    private final BudgetManager budgetManager;

    public ShowBalance(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public void perform() {
        this.budgetManager.printBalance();
    }
}
