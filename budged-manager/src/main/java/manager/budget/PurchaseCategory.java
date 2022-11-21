package manager.budget;

/**
 * @author Dominik_Janiga
 */
public enum PurchaseCategory {

    FOOD("Food"),
    CLOTHES("Clothes"),
    ENTERTAINMENT("Entertainment"),
    OTHER("Other"),
    ALL("All");

    private final String name;

    PurchaseCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
