package manager.actions;

/**
 * @author Dominik_Janiga
 */
class Exit implements Action {

    @Override
    public void perform() {
        System.out.println("Bye!");
       System.exit(0);
    }
}
