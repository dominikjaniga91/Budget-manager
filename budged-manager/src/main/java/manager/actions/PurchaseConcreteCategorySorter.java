package manager.actions;

import manager.budget.BudgetManager;
import manager.budget.Purchase;
import manager.budget.PurchaseCategory;

import java.util.Comparator;
import java.util.List;

public class PurchaseConcreteCategorySorter implements Action {

    private final BudgetManager budgetManager;
    private final PurchaseCategory category;

    public PurchaseConcreteCategorySorter(BudgetManager budgetManager, PurchaseCategory category) {
        this.budgetManager = budgetManager;
        this.category = category;
    }

    @Override
    public void perform() {
        List<Purchase> allPurchases = this.budgetManager.getAllPurchases();

        if (allPurchases.isEmpty()) {
            System.out.println("The purchase list is empty!\n");
            return;
        }

        System.out.printf("%s:%n", this.category);
        double totalSum = allPurchases.stream()
                .filter(p -> p.getCategory() == this.category)
                .sorted(Comparator.reverseOrder())
                .peek(System.out::println)
                .mapToDouble(Purchase::getAmount)
                .sum();

        System.out.printf("Total sum: $%.2f%n%n", totalSum);

    }
}
