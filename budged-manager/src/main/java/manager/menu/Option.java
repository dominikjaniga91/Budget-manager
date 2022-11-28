package manager.menu;

/**
 * @author Dominik_Janiga
 */
class Option {

    private final int number;
    private final String name;

    Option(int number, String name) {
        this.number = number;
        this.name = name;
    }

    int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("%d) %s", this.number, this.name);
    }
}
