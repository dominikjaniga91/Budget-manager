package manager.menu;

import manager.actions.ActionInspector;

/**
 * @author Dominik_Janiga
 */
public interface Menu {

    void show();

    Menu selectMenuOption(int option);

    Menu back();

    Menu performAction();

    default ActionInspector checkAction() {
        return new ActionInspector(true);
    }

    default boolean isNotControlActionMenu() {
        return true;
    }

    default boolean exit() {
        return false;
    }
}
