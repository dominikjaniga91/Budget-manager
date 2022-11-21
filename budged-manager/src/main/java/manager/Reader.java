package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dominik_Janiga
 */
public class Reader {

    private final static Scanner SCANNER = new Scanner(System.in);

    public String readText() {
        return SCANNER.nextLine();
    }

    public double readReadAmount() {
        return SCANNER.nextDouble();
    }

    int readAction() {
        int action = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println();
        return action;
    }
}
