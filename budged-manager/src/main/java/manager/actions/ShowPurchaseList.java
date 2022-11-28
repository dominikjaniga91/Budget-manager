package manager.actions;

import manager.budget.BudgetManager;
import manager.budget.PurchaseCategory;

/**
 * @author Dominik_Janiga
 */
public class ShowPurchaseList implements Action {

    private final BudgetManager budgetManager;
    private final PurchaseCategory purchaseCategory;

    public ShowPurchaseList(BudgetManager budgetManager,
                            PurchaseCategory purchaseCategory) {
        this.budgetManager = budgetManager;
        this.purchaseCategory = purchaseCategory;
    }

    @Override
    public void perform() {
        if (this.purchaseCategory == PurchaseCategory.ALL) {
            this.budgetManager.showPurchases();
        } else {
            this.budgetManager.showPurchasesByCategory(this.purchaseCategory);
        }
    }

    @Override
    public ActionInspector canPerformAction() {
        if(this.budgetManager.hasNotPurchases()) {
            return new ActionInspector(false, "The purchase list is empty!\n");
        }
        return new ActionInspector(true);
    }
}
