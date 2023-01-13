package phonebook;

import java.util.List;
import java.util.Optional;

/**
 * @author Dominik_Janiga
 */
class PhoneBook {

    private final List<Contact> contacts;

    public PhoneBook(List<Contact> contacts) {
        this.contacts = contacts;
    }

    Optional<Contact> findContact(ContactToFind credentials) {

        for (Contact contact : this.contacts) {
            if (contact.hasCredentials(credentials)) {
                return Optional.of(contact);
            }
        }
        return Optional.empty();
    }
}
