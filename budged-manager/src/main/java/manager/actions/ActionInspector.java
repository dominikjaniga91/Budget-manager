package manager.actions;

/**
 * @author Dominik_Janiga
 */
public class ActionInspector {

    private final boolean performAction;
    private String message;

    public ActionInspector(boolean performAction, String message) {
        this.performAction = performAction;
        this.message = message;
    }

    public ActionInspector(boolean performAction) {
        this.performAction = performAction;
    }

    public boolean canPerformAction() {
        return this.performAction;
    }

    public void showErrorMessage() {
        System.out.println(this.message);
    }
}
