package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Dominik_Janiga
 */
final class FileReader {

    public static List<String> readFileAsString(String url) throws IOException {
        return Files.readAllLines(Paths.get(url));
    }
}
