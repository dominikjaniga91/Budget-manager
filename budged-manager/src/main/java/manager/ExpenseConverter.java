package manager;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dominik_Janiga
 */
class ExpenseConverter {

    List<Expense> convertALlToExpense(final List<String> expenses) {
        return expenses.stream().map(this::convertToExpense).collect(Collectors.toList());
    }

    private Expense convertToExpense(final String expenseRecord) {
        String[] expenseData = expenseRecord.split(" \\$");
        String name = expenseData[0];
        double amount = Double.parseDouble(expenseData[1]);

        return new Expense(name, amount);
    }
}
