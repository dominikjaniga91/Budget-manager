package phonebook;

/**
 * @author Dominik_Janiga
 */
class StringToCredentialsConverter {

    static ContactToFind convert(String recordToFind) {
        String[] data = recordToFind.split(" ");
        try {
            String firstName = data[0];
            String lastName = data.length == 2 ? data[1] : "";
            return new ContactToFind(firstName, lastName);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid data: " + recordToFind);
        }
    }
}
