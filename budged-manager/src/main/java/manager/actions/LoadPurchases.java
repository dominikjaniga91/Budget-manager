package manager.actions;

import manager.budget.BudgetManager;
import manager.budget.Purchase;
import manager.file.manager.FileManager;

import java.io.IOException;
import java.util.List;

/**
 * @author Dominik_Janiga
 */
public class LoadPurchases implements Action {

    private final BudgetManager budgetManager;

    public LoadPurchases(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public void perform() {
        try {
            List<Purchase> purchases = FileManager.readDataAsPurchases();
            this.budgetManager.addAllPurchases(purchases);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
