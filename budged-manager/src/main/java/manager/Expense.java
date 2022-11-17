package manager;

/**
 * @author Dominik_Janiga
 */
public class Expense {
    private final String name;
    private final double amount;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", this.name, this.amount);
    }

    double getAmount() {
        return amount;
    }
}
