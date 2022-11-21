package manager.actions;

import manager.budget.BudgetManager;
import manager.budget.Purchase;
import manager.file.manager.FileManager;

import java.util.List;

/**
 * @author Dominik_Janiga
 */
public class SavePurchases implements Action {

    private final BudgetManager budgetManager;

    public SavePurchases(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public void perform() {
        List<Purchase> allPurchases = this.budgetManager.getAllPurchases();
        FileManager.savePurchasesToFile(allPurchases);
    }
}
