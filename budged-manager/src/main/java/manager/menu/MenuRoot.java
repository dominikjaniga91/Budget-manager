package manager.menu;

import java.util.Map;

/**
 * @author Dominik_Janiga
 */
class MenuRoot implements Menu {

    private final String name;
    private final Map<Option, Menu> submenu;

    MenuRoot(String name, Map<Option, Menu> submenu) {
        this.name = name;
        this.submenu = submenu;
    }

    @Override
    public Menu back() {
        return this;
    }

    @Override
    public void show() {
        System.out.print(this);
    }

    @Override
    public Menu performAction() {
        System.out.println(this);
        return this;
    }

    public Menu selectMenuOption(int option) {
        return this.submenu.entrySet().stream()
                .filter(e -> e.getKey().getNumber() == option).
                findFirst()
                .orElseThrow()
                .getValue();
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
