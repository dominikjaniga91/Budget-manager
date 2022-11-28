package manager.budget;

/**
 * @author Dominik_Janiga
 */
public class Purchase implements Comparable<Purchase> {

    private final String name;
    private final double amount;
    private final PurchaseCategory category;

    public Purchase(String name, double amount, PurchaseCategory category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", this.name, this.amount);
    }

    public String convertToString() {
        return String.format("%s:%.2f:%s", this.name, this.amount, this.category);
    }

    public double getAmount() {
        return this.amount;
    }

    public PurchaseCategory getCategory() {
        return this.category;
    }

    @Override
    public int compareTo(Purchase o) {
        return Double.compare(this.amount, o.amount);
    }
}
