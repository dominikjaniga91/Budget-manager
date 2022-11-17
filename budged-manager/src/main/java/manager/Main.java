package manager;

import manager.actions.Action;
import manager.actions.ActionSelector;

/**
 * @author Dominik_Janiga
 */
class Main {
    public static void main(String[] args) {

        Account account = new Account();
        Reader reader = new Reader();
        BudgetManager budgetManager = new BudgetManager(account);

        while (true) {
            UserMenu.print();
            int userAction = reader.readAction();
            ActionSelector actionSelector = new ActionSelector(budgetManager, reader);
            Action action = actionSelector.select(userAction);
            action.perform();
        }
    }
}
