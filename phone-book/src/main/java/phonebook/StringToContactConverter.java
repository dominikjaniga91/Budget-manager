package phonebook;

/**
 * @author Dominik_Janiga
 */
class StringToContactConverter {

    static Contact convert(String phoneBookRecord) {
        String[] data = phoneBookRecord.split(" ");
        try {
            long phone = Long.parseLong(data[0]);
            String firstName = data[1];
            String lastName = data.length == 3 ? data[2] : "";
            return new Contact(phone, firstName, lastName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
