package manager.budget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Dominik_Janiga
 */
public class BudgetManager {

    private final Account account;
    private final List<Purchase> purchases = new ArrayList<>();

    public BudgetManager() {
        this.account = new Account();
    }

    public void addIncome(final double income) {
        this.account.addIncome(income);
    }

    public void addPurchase(Purchase purchase) {
        if (this.account.canPurchase(purchase)) {
            this.purchases.add(purchase);
            this.account.decreaseBalance(purchase.getAmount());
        }
    }

    public void showPurchases() {
        if(this.purchases.isEmpty()) {
            System.out.println("\nThe purchase list is empty\n");
        } else {
            System.out.println("All:");
            this.purchases.forEach(System.out::println);
            double purchasesSum = sumAllPurchases();
            System.out.printf("Total sum: $%.2f%n%n", purchasesSum);
        }
    }

    public void showPurchasesByCategory(PurchaseCategory category) {

        List<Purchase> purchasesForCategory = this.purchases.stream()
                .filter(purchase -> purchase.getCategory() == category)
                .collect(Collectors.toList());
        System.out.println(category.getName() + ":");
        if (purchasesForCategory.isEmpty()) {
            System.out.println("The purchase list is empty\n");
        } else {
            purchasesForCategory.forEach(System.out::println);
            double purchasesSum = sumPurchasesForCategory(purchasesForCategory);
            System.out.printf("Total sum: $%.2f%n%n", purchasesSum);
        }
    }

    public boolean hasNotPurchases() {
        return this.purchases.isEmpty();
    }

    public void printBalance() {
        this.account.printBalance();
    }

    private double sumAllPurchases() {
        return sumPurchases(this.purchases.stream());
    }

    private double sumPurchasesForCategory(List<Purchase> purchases) {
        return sumPurchases(purchases.stream());
    }

    private double sumPurchases(Stream<Purchase> purchaseStream) {
        return purchaseStream.mapToDouble(Purchase::getAmount).sum();
    }

    public List<Purchase> getAllPurchases() {
        return Collections.unmodifiableList(this.purchases);
    }

    public void addAllPurchases(List<Purchase> purchases) {

        Double purchasesTotalAmount = purchases.stream()
                .map(Purchase::getAmount)
                .reduce(0.00, Double::sum);
        if (this.account.hasEnoughBalance(purchasesTotalAmount)) {
            this.purchases.addAll(purchases);
            this.account.decreaseBalance(purchasesTotalAmount);
        } else {
            System.out.println("Not enough money!");
        }
    }
}

