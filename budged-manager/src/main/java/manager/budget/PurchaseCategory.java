package manager.budget;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

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

    public static PurchaseCategory getByName(String name) {
        return Arrays.stream(values()).filter(e -> e.name.equals(name)).findFirst().orElseThrow();
    }

    public static Map<PurchaseCategory, Double> getEnumMap() {
        Map<PurchaseCategory, Double> map = new EnumMap<>(PurchaseCategory.class);
        map.put(FOOD, 0.0);
        map.put(CLOTHES, 0.0);
        map.put(ENTERTAINMENT, 0.0);
        map.put(OTHER, 0.0);

        return map;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
