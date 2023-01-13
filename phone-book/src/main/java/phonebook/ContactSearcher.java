package phonebook;

import java.util.List;
import java.util.Optional;

/**
 * @author Dominik_Janiga
 */
class ContactSearcher {

    private final PhoneBook phoneBook;

    public ContactSearcher(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    void search(List<ContactToFind> contactsToFind) {
        long start = System.currentTimeMillis();
        System.out.println("Start searching...");
        int counter = 0;

        for (ContactToFind contactToFind : contactsToFind) {
            Optional<Contact> contact = phoneBook.findContact(contactToFind);

            if (contact.isPresent()) {
                counter++;
            }
        }


        long end = System.currentTimeMillis();
        long result = end - start;
        String formattedResult = String.format("Time taken: %d min. %d sec. %d ms.", result / 3600, (result % 3600) / 60, (result % 60));
        System.out.printf("Found %d / %d entries.", counter, contactsToFind.size());
        System.out.println(formattedResult);
    }
}
