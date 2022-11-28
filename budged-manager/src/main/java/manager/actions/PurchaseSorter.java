package manager.actions;

import manager.budget.BudgetManager;
import manager.budget.Purchase;

import java.util.Comparator;
import java.util.List;

public class PurchaseSorter implements Action {

    private final BudgetManager budgetManager;

    public PurchaseSorter(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    /* TODO: Is it ok that this class implement action?
        Maybe it should implement another interface like Analyzer
     */
    @Override
    public void perform() {
        List<Purchase> allPurchases = this.budgetManager.getAllPurchases();

        if (allPurchases.isEmpty()) {
            System.out.println("The purchase list is empty!\n");
            return;
        }

        System.out.println("All:");
        double totalSum = allPurchases.stream()
                .sorted(Comparator.reverseOrder())
                .peek(System.out::println)
                .mapToDouble(Purchase::getAmount)
                .sum();
        System.out.printf("Total: $%.2f%n%n", totalSum);
    }
}
