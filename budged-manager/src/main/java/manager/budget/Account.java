package manager.budget;

/**
 * @author Dominik_Janiga
 */
class Account {

    private double balance;

    void decreaseBalance(double income) {
        this.balance += income;
    }

    void addPurchase(double purchase) {
        this.balance -= purchase;
    }

    void printBalance() {
        System.out.printf("Balance:  $%.2f%n%n", this.balance);
    }

    boolean canPurchase(Purchase purchase) {
        return this.balance > purchase.getAmount();
    }
}
