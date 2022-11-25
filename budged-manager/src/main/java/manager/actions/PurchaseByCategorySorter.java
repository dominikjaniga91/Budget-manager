package manager.actions;

import manager.budget.BudgetManager;
import manager.budget.PurchaseCategory;

import java.util.Comparator;
import java.util.Map;

public class PurchaseByCategorySorter implements Action {

    private final BudgetManager budgetManager;

    public PurchaseByCategorySorter(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public void perform() {

        Map<PurchaseCategory, Double> purchaseToCostMap = PurchaseCategory.getEnumMap();

        this.budgetManager.getAllPurchases()
                .forEach(purchase -> purchaseToCostMap.merge(
                                purchase.getCategory(),
                                purchase.getAmount(),
                                Double::sum
                        )
                );

        System.out.println("Types:");
        double totalSum = purchaseToCostMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .peek(e -> System.out.printf("%s - $%.2f%n", e.getKey(), e.getValue()))
                .mapToDouble(Map.Entry::getValue)
                .sum();

        System.out.printf("Total sum: $%.2f%n%n", totalSum);
    }
}