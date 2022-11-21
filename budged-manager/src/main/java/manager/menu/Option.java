package manager.menu;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return number == option.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.format("%d) %s", this.number, this.name);
    }
}
