package manager.actions.analyzer;

import manager.actions.Action;
import manager.budget.BudgetManager;

public class PurchaseSorter implements Action {

    private final BudgetManager budgetManager;

    public PurchaseSorter(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public void perform() {

    }
}
