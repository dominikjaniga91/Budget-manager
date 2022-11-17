package manager.actions;

import manager.BudgetManager;
import manager.Reader;

/**
 * @author Dominik_Janiga
 */
public class ActionSelector {

    private final BudgetManager budgetManager;
    private final Reader reader;

    public ActionSelector(BudgetManager budgetManager, Reader reader) {
        this.budgetManager = budgetManager;
        this.reader = reader;
    }

    public Action select(int actionNumber) {
        return switch (actionNumber) {
            case 1 -> new Income(this.budgetManager, this.reader);
            case 2 -> new Purchase(this.budgetManager, this.reader);
            case 3 -> new PurchaseList(this.budgetManager);
            case 4 -> new Balance(this.budgetManager);
            default -> new Exit();
        };
    }
}
