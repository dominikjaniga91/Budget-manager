package phonebook;

/**
 * @author Dominik_Janiga
 */
class ContactToFind {

    private final String firstName;
    private final String lastName;

    public ContactToFind(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
