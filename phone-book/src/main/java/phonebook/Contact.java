package phonebook;

/**
 * @author Dominik_Janiga
 */
class Contact {

    private final long number;
    private final String firstName;
    private final String lastName;

    public Contact(long number, String firstName, String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean hasCredentials(ContactToFind credentials) {
        return this.firstName.equals(credentials.getFirstName())
                && this.lastName.equals(credentials.getLastName());
    }
}
