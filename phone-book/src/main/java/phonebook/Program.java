package phonebook;

import java.io.IOException;
import java.util.List;

/**
 * @author Dominik_Janiga
 */
class Program {
    public static void main(String[] args) throws IOException {

        List<String> phoneBookRecords = FileReader.readFileAsString("small_directory.txt");
        List<Contact> contacts = phoneBookRecords.stream().map(StringToContactConverter::convert).toList();
        PhoneBook phoneBook = new PhoneBook(contacts);

        List<String> recordsToFind = FileReader.readFileAsString("small_find.txt");
        List<ContactToFind> contactsToFind = recordsToFind.stream().map(StringToCredentialsConverter::convert).toList();

        ContactSearcher searcher = new ContactSearcher(phoneBook);
        searcher.search(contactsToFind);
    }
}
