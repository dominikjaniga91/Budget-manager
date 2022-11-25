package manager.file.manager;

import manager.budget.Purchase;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author Dominik_Janiga
 */
final class DataWriter {

    static void savePurchasesToFile(List<Purchase> purchases) {
        Path path = Paths.get("purchases.txt");

        try(var writer = Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING)) {
            writePurchases(purchases, writer);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void writePurchases(List<Purchase> purchases, BufferedWriter writer) {
        purchases.stream().map(Purchase::convertToString)
                .forEach(student -> writePurchase(writer, student));
    }

    private static void writePurchase(BufferedWriter writer, String student) {
        try {
            writer.write(student);
            writer.newLine();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
