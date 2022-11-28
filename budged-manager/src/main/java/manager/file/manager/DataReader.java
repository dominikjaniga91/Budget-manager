package manager.file.manager;

import manager.budget.Purchase;
import manager.budget.PurchaseCategory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dominik_Janiga
 */
final class DataReader {

    static List<Purchase> readDataAsPurchases(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path).stream()
                .map(DataReader::convertToPurchase)
                .collect(Collectors.toList());
    }

    private static Purchase convertToPurchase(final String purchaseRecord) {
        String[] purchaseData = purchaseRecord.split(":");
        String name = purchaseData[0];
        double amount = Double.parseDouble(purchaseData[1]);
        PurchaseCategory category = PurchaseCategory.getByName(purchaseData[2]);

        return new Purchase(name, amount, category);
    }
}
