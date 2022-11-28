package manager.menu;

import manager.actions.Action;
import manager.actions.ActionInspector;

/**
 * @author Dominik_Janiga
 */
class ActionMenu implements Menu {

    private final Menu parent;
    private final Action action;

    ActionMenu(Menu parent, Action action) {
        this.parent = parent;
        this.action = action;
    }

    @Override
    public Menu back() {
        return this.parent;
    }

    @Override
    public void show() {
        this.parent.show();
    }

    @Override
    public Menu performAction() {
        this.action.perform();
        return this.parent;
    }

    @Override
    public ActionInspector checkAction() {
        return this.action.canPerformAction();
    }

    @Override
    public Menu selectMenuOption(int actionNumber) {
        return this;
    }

}
