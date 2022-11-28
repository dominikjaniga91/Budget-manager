package manager.budget;

/**
 * @author Dominik_Janiga
 */
class Account {

    private double balance;

    void addIncome(double income) {
        this.balance += income;
    }

    void decreaseBalance(double purchase) {
        this.balance -= purchase;
    }

    void printBalance() {
        System.out.printf("Balance:  $%.2f%n%n", this.balance);
    }

    boolean canPurchase(Purchase purchase) {
        return hasEnoughBalance(purchase.getAmount());
    }

    boolean hasEnoughBalance(Double purchasesTotalAmount) {
        return Double.compare(this.balance, purchasesTotalAmount) >= 0;
    }
}
