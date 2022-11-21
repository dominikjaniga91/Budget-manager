package manager.budget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Dominik_Janiga
 */
public class BudgetManager {
    /*TODO:

        1. Create a purchase category - there are four categories:
            Food
            Clothes
            Entertainment
            Other
        1a. Create sub menus
        2. Assign purchase to specific category
            a) WHEN user select "2) Add purchase"
               THEN display category submenu:
                    Choose the type of purchase
                    1) Food
                    2) Clothes
                    3) Entertainment
                    4) Other
                    5) Back
             b) WHEN user chose category in submenu
                THEN display option to add purchase
             c) WHEN purchase has been added
                THEN display category submenu again
             d) WHEN user select "back" in category submenu
                THEN return to main menu

                3) Show list of purchases
        3. Allows to output the shopping list by type
            a) WHEN user select "3) Show list of purchases"
               THEN display purchase category submenu (this is different than previous one, with "ALl" option)
            b) WHEN user select purchase category in submenu
               THEN display purchases in the category in format:
                    <category-name>:
                    <product> <price>
                    .
                    .
                    <product> <price>
                    Total sum: $0.00
     */

    private final Account account;
    private final List<Purchase> purchases = new ArrayList<>();

    public BudgetManager() {
        this.account = new Account();
    }

    public void addIncome(final double income) {
        this.account.addIncome(income);
    }

    public void addExpense(Purchase purchase) {
        if (this.account.canPurchase(purchase)) {
            this.purchases.add(purchase);
            this.account.addPurchase(purchase.getAmount());
        }
    }

    public void showExpenses() {
        if(this.purchases.isEmpty()) {
            System.out.println("\nThe purchase list is empty\n");
        } else {
            System.out.println("All:");
            this.purchases.forEach(System.out::println);
            double purchasesSum = sumAllPurchases();
            System.out.printf("Total sum: $%.2f%n%n", purchasesSum);
        }
    }

    public void showExpensesByCategory(PurchaseCategory category) {

        List<Purchase> purchasesForCategory = this.purchases.stream()
                .filter(purchase -> purchase.getCategory() == category)
                .collect(Collectors.toList());
        System.out.println(category + ":");
        if (purchasesForCategory.isEmpty()) {
            System.out.println("The purchase list is empty\n");
        } else {
            purchasesForCategory.forEach(System.out::println);
            double purchasesSum = sumPurchasesForCategory(purchasesForCategory);
            System.out.printf("Total sum: $%.2f%n%n", purchasesSum);
        }
    }

    public boolean hasNotExpenses() {
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
}

