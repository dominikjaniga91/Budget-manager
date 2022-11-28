package manager.menu;

/**
 * @author Dominik_Janiga
 */
class ExitMenu implements Menu {

    @Override
    public Menu back() {
        return this;
    }

    @Override
    public void show() {}

    @Override
    public Menu performAction() {
        System.out.println("Bye!");
        return this;
    }

    @Override
    public boolean canExit() {
        return true;
    }

    @Override
    public Menu selectMenuOption(int actionNumber) {
        return this;
    }

    @Override
    public boolean isNotControlActionMenu() {
        return false;
    }
}
