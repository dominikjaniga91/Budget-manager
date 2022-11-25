package manager.actions.analyzer;

import manager.actions.Action;
import manager.budget.BudgetManager;
import manager.budget.PurchaseCategory;

public class PurchaseByCategorySorter implements Action {

    private final BudgetManager budgetManager;
    private final PurchaseCategory category;

    public PurchaseByCategorySorter(BudgetManager budgetManager, PurchaseCategory category) {
        this.budgetManager = budgetManager;
        this.category = category;
    }

    @Override
    public void perform() {

    }
}
