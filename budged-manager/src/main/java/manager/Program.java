package manager;

import manager.actions.ActionInspector;
import manager.budget.BudgetManager;
import manager.menu.Menu;
import manager.menu.MenuInitializer;

/**
 * @author Dominik_Janiga
 */
class Program {
    public static void main(String[] args) {
        Reader reader = new Reader();
        BudgetManager budgetManager = new BudgetManager();
        MenuInitializer initializer = new MenuInitializer(budgetManager, reader);
        Menu currentMenu = initializer.initializeMenu();

        while (!currentMenu.exit()) {

            currentMenu.show();
            int userAction = reader.readAction();
            currentMenu = currentMenu.selectMenuOption(userAction);

            ActionInspector actionInspector = currentMenu.checkAction();
            if (actionInspector.canPerformAction()) {
                currentMenu = currentMenu.performAction();
            } else {
                currentMenu = currentMenu.back();
                actionInspector.showErrorMessage();
            }
        }
    }
}
