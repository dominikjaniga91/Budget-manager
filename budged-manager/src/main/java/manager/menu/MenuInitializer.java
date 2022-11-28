package manager.menu;

import manager.Reader;
import manager.actions.AddIncome;
import manager.actions.AddPurchase;
import manager.actions.LoadPurchases;
import manager.actions.PurchaseByCategorySorter;
import manager.actions.PurchaseConcreteCategorySorter;
import manager.actions.PurchaseSorter;
import manager.actions.SavePurchases;
import manager.actions.ShowBalance;
import manager.actions.ShowPurchaseList;
import manager.budget.BudgetManager;

import java.util.LinkedHashMap;
import java.util.Map;

import static manager.budget.PurchaseCategory.ALL;
import static manager.budget.PurchaseCategory.CLOTHES;
import static manager.budget.PurchaseCategory.ENTERTAINMENT;
import static manager.budget.PurchaseCategory.FOOD;
import static manager.budget.PurchaseCategory.OTHER;

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
        Menu addIncome = new ActionMenu( root, new AddIncome(this.budgetManager, this.reader));

        /*
            TODO: Is it necessary to create such amount of similar objects?
                Can we pass purchase type more dynamically to the method?

         */
        //Add purchase by
        Map<Option, Menu> purchaseTypeMenuOptions = new LinkedHashMap<>();
        Menu purchaseTypeMenu = new MenuChild("Choose the type of purchase", root, purchaseTypeMenuOptions);
        purchaseTypeMenuOptions.put(new Option(1, FOOD.getName()), new ActionMenu(purchaseTypeMenu, new AddPurchase(this.budgetManager, this.reader, FOOD)));
        purchaseTypeMenuOptions.put(new Option(2, CLOTHES.getName()), new ActionMenu(purchaseTypeMenu, new AddPurchase(this.budgetManager, this.reader, CLOTHES)));
        purchaseTypeMenuOptions.put(new Option(3, ENTERTAINMENT.getName()), new ActionMenu(purchaseTypeMenu, new AddPurchase(this.budgetManager, this.reader, ENTERTAINMENT)));
        purchaseTypeMenuOptions.put(new Option(4, OTHER.getName()), new ActionMenu(purchaseTypeMenu, new AddPurchase(this.budgetManager, this.reader, OTHER)));
        purchaseTypeMenuOptions.put(new Option(5, "Back"), new BackMenu(root));


        //show purchases by
        Map<Option, Menu> showPurchasesMenuOptions = new LinkedHashMap<>();
        Menu showPurchasesMenu = new MenuChild("Choose the type of purchase", root, showPurchasesMenuOptions);
        showPurchasesMenuOptions.put(new Option(1, FOOD.getName()), new ActionMenu(showPurchasesMenu, new ShowPurchaseList(this.budgetManager, FOOD)));
        showPurchasesMenuOptions.put(new Option(2, CLOTHES.getName()), new ActionMenu(showPurchasesMenu, new ShowPurchaseList(this.budgetManager, CLOTHES)));
        showPurchasesMenuOptions.put(new Option(3, ENTERTAINMENT.getName()), new ActionMenu(showPurchasesMenu, new ShowPurchaseList(this.budgetManager, ENTERTAINMENT)));
        showPurchasesMenuOptions.put(new Option(4, OTHER.getName()), new ActionMenu(showPurchasesMenu, new ShowPurchaseList(this.budgetManager, OTHER)));
        showPurchasesMenuOptions.put(new Option(5, ALL.getName()), new ActionMenu(showPurchasesMenu, new ShowPurchaseList(this.budgetManager, ALL)));
        showPurchasesMenuOptions.put(new Option(6, "Back"), new BackMenu(root));


        rootMenuOptions.put(new Option(1, "Add income"), addIncome);
        rootMenuOptions.put(new Option(2, "Add purchase"), purchaseTypeMenu);
        rootMenuOptions.put(new Option(3, "Show list of purchases"), showPurchasesMenu);
        rootMenuOptions.put(new Option(4, "Balance"), new ActionMenu(root, new ShowBalance(this.budgetManager)));
        rootMenuOptions.put(new Option(5, "Save"), new ActionMenu(root, new SavePurchases(this.budgetManager)));
        rootMenuOptions.put(new Option(6, "Load"), new ActionMenu(root, new LoadPurchases(this.budgetManager)));

        Map<Option, Menu> analyzerMenuOptions = new LinkedHashMap<>();
        Menu analyzerMenu = new MenuChild("How do you want to sort?", root, analyzerMenuOptions);
        analyzerMenuOptions.put(new Option(1, "Sort all purchases"), new ActionMenu(analyzerMenu, new PurchaseSorter(this.budgetManager)));
        analyzerMenuOptions.put(new Option(2, "Sort by type"), new ActionMenu(analyzerMenu, new PurchaseByCategorySorter(this.budgetManager)));


        Map<Option, Menu> purchaseConcreteCaregoryOptions = new LinkedHashMap<>();
        Menu purchaseConcreteCategoryMenu = new MenuChild("Choose the type of purchase", analyzerMenu, purchaseConcreteCaregoryOptions);
        purchaseConcreteCaregoryOptions.put(new Option(1, FOOD.getName()), new ActionMenu(analyzerMenu, new PurchaseConcreteCategorySorter(this.budgetManager, FOOD)));
        purchaseConcreteCaregoryOptions.put(new Option(2, ENTERTAINMENT.getName()), new ActionMenu(analyzerMenu, new PurchaseConcreteCategorySorter(this.budgetManager, ENTERTAINMENT)));
        purchaseConcreteCaregoryOptions.put(new Option(3, CLOTHES.getName()), new ActionMenu(analyzerMenu, new PurchaseConcreteCategorySorter(this.budgetManager, CLOTHES)));
        purchaseConcreteCaregoryOptions.put(new Option(4, OTHER.getName()), new ActionMenu(analyzerMenu, new PurchaseConcreteCategorySorter(this.budgetManager, OTHER)));
        analyzerMenuOptions.put(new Option(3, "Sort certain type"), purchaseConcreteCategoryMenu);
        analyzerMenuOptions.put(new Option(4, "Back"), new BackMenu(root));


        rootMenuOptions.put(new Option(7, "Analyze (Sort)"), analyzerMenu);
        rootMenuOptions.put(new Option(0, "Exit"), new ExitMenu());

        return root;
    }
}
