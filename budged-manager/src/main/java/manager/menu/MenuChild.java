package manager.menu;

import manager.actions.ActionInspector;

import java.util.Map;
import java.util.Optional;

/**
 * @author Dominik_Janiga
 */
class MenuChild implements Menu {

    private final String name;
    private final Menu parent;
    private final Map<Option, Menu> submenu;

    MenuChild(String name, Menu parent, Map<Option, Menu> submenu) {
        this.name = name;
        this.parent = parent;
        this.submenu = submenu;
    }

    @Override
    public Menu back() {
        return this.parent;
    }

    @Override
    public Menu performAction() {
        return this;
    }

    @Override
    public ActionInspector checkAction() {
        ActionInspector actionInspector = new ActionInspector(true);
        for (Menu menu : this.submenu.values()) {
            if (menu.isNotControlActionMenu()) {
                actionInspector = menu.checkAction();
            }
        }
        return actionInspector;
    }

    @Override
    public Menu selectMenuOption(int option) {
        Optional<Option> selectedOption = this.submenu.keySet().stream().filter(e -> e.getNumber() == option).findFirst();
        if (selectedOption.isPresent()) {
            return this.submenu.get(selectedOption.get());
        } else {
            return this;
        }
    }

    @Override
    public void show() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append("\n");
        for (Map.Entry<Option, Menu> entry : this.submenu.entrySet()) {
            builder.append(entry.getKey()).append("\n");
        }
        return builder.toString();
    }
}
