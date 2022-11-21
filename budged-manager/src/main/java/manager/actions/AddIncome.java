package manager.actions;

import manager.budget.BudgetManager;
import manager.Reader;

/**
 * @author Dominik_Janiga
 */
public class AddIncome implements Action {

    private final BudgetManager budgetManager;
    private final Reader reader;

    public AddIncome(BudgetManager budgetManager, Reader reader) {
        this.budgetManager = budgetManager;
        this.reader = reader;
    }

    @Override
    public void perform() {
        System.out.println("Enter income:");
        double income = this.reader.readReadAmount();
        this.budgetManager.addIncome(income);
        System.out.println("Income was added!\n");
    }
}
