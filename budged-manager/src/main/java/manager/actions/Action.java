package manager.actions;

/**
 * @author Dominik_Janiga
 */
public interface Action {

    void perform();

    default ActionInspector canPerformAction() {
        return new ActionInspector(true);
    }
}
