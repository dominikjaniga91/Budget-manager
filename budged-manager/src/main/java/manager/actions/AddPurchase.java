package manager.actions;

import manager.budget.BudgetManager;
import manager.budget.Purchase;
import manager.budget.PurchaseCategory;
import manager.Reader;

/**
 * @author Dominik_Janiga
 */
public class AddPurchase implements Action {

    private final BudgetManager budgetManager;
    private final Reader reader;
    private final PurchaseCategory purchaseCategory;

    public AddPurchase(BudgetManager budgetManager,
                       Reader reader,
                       PurchaseCategory purchaseCategory) {
        this.budgetManager = budgetManager;
        this.reader = reader;
        this.purchaseCategory = purchaseCategory;
    }

    @Override
    public void perform() {
        System.out.println("Enter purchase name:");
        String purchaseName = this.reader.readText();
        System.out.println("Enter its price:");
        double purchasePrice = this.reader.readReadAmount();
        Purchase purchase = new Purchase(purchaseName, purchasePrice, this.purchaseCategory);
        this.budgetManager.addExpense(purchase);
        System.out.println("Purchase was added!\n");
    }
}

