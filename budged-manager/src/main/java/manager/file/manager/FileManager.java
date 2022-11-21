package manager.file.manager;

import manager.budget.Purchase;

import java.io.IOException;
import java.util.List;

/**
 * @author Dominik_Janiga
 */
public final class FileManager {

    public static List<Purchase> readDataAsPurchases() throws IOException {
        return DataReader.readDataAsPurchases("purchases.txt");
    }

    public static void savePurchasesToFile(List<Purchase> purchases) {
        DataWriter.savePurchasesToFile(purchases);
    }
}
