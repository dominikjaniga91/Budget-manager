package manager.menu;

/**
 * @author Dominik_Janiga
 */
class BackMenu implements Menu {

    private final Menu parent;

    public BackMenu(Menu parent) {
        this.parent = parent;
    }

    @Override
    public Menu back() {
        return this.parent;
    }

    public void show() {
        this.parent.show();
    }

    @Override
    public Menu performAction() {
        return this.parent;
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
