package manager.menu;

import manager.budget.BudgetManager;
import manager.Reader;
import manager.actions.AddIncome;
import manager.actions.AddPurchase;
import manager.actions.ShowBalance;
import manager.actions.ShowPurchaseList;

import java.util.LinkedHashMap;
import java.util.Map;

import static manager.budget.PurchaseCategory.*;

/**
 * @author Dominik_Janiga
 */
public class MenuInitializer {

    private final Reader reader;
    private final BudgetManager budgetManager;

    public MenuInitializer(BudgetManager budgetManager, Reader reader) {
        this.budgetManager = budgetManager;
        this.reader = reader;
    }

    public Menu initializeMenu() {
        Map<Option, Menu> rootMenuOptions = new LinkedHashMap<>();

        Menu root = new MenuRoot("Choose your action:", rootMenuOptions);
        Menu addIncome = new ActionMenu( root, new AddIncome(budgetManager, reader));

        //Add purchase by
        Map<Option, Menu> purchaseTypeMenuOptions = new LinkedHashMap<>();
        Menu purchaseTypeMenu = new MenuChild("Choose the type of purchase", root, purchaseTypeMenuOptions);
        purchaseTypeMenuOptions.put(new Option(1, FOOD.getName()), new ActionMenu(purchaseTypeMenu, new AddPurchase(budgetManager, reader, FOOD)));
        purchaseTypeMenuOptions.put(new Option(2, CLOTHES.getName()), new ActionMenu(purchaseTypeMenu, new AddPurchase(budgetManager, reader, CLOTHES)));
        purchaseTypeMenuOptions.put(new Option(3, ENTERTAINMENT.getName()), new ActionMenu(purchaseTypeMenu, new AddPurchase(budgetManager, reader, ENTERTAINMENT)));
        purchaseTypeMenuOptions.put(new Option(4, OTHER.getName()), new ActionMenu(purchaseTypeMenu, new AddPurchase(budgetManager, reader, OTHER)));
        purchaseTypeMenuOptions.put(new Option(5, "Back"), new BackMenu(root));


        //show purchases by
        Map<Option, Menu> showPurchasesMenuOptions = new LinkedHashMap<>();
        Menu showPurchasesMenu = new MenuChild("Choose the type of purchase", root, showPurchasesMenuOptions);
        showPurchasesMenuOptions.put(new Option(1, FOOD.getName()), new ActionMenu(showPurchasesMenu, new ShowPurchaseList(budgetManager, FOOD)));
        showPurchasesMenuOptions.put(new Option(2, CLOTHES.getName()), new ActionMenu(showPurchasesMenu, new ShowPurchaseList(budgetManager, CLOTHES)));
        showPurchasesMenuOptions.put(new Option(3, ENTERTAINMENT.getName()), new ActionMenu(showPurchasesMenu, new ShowPurchaseList(budgetManager, ENTERTAINMENT)));
        showPurchasesMenuOptions.put(new Option(4, OTHER.getName()), new ActionMenu(showPurchasesMenu, new ShowPurchaseList(budgetManager, OTHER)));
        showPurchasesMenuOptions.put(new Option(5, ALL.getName()), new ActionMenu(showPurchasesMenu, new ShowPurchaseList(budgetManager, ALL)));
        showPurchasesMenuOptions.put(new Option(6, "Back"), new BackMenu(root));


        rootMenuOptions.put(new Option(1, "Add income"), addIncome);
        rootMenuOptions.put(new Option(2, "Add purchase"), purchaseTypeMenu);
        rootMenuOptions.put(new Option(3, "Show list of purchases"), showPurchasesMenu);
        rootMenuOptions.put(new Option(4, "Balance"), new ActionMenu(root, new ShowBalance(budgetManager)));
        rootMenuOptions.put(new Option(0, "Exit"), new ExitMenu());

        return root;
    }
}
