package main.pratha.splitExpenses.service;

import main.pratha.splitExpenses.model.*;

import java.util.List;

public class ExpenseService {

    public static Expense createExpense(ExpenseType expenseType, double amount, User payer, List<Split> splits) {
        switch (expenseType) {
            case EXACT:
                return new ExactExpense(amount, payer, splits);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double) Math.round(amount*100/totalSplits))/100.0;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount + (amount - splitAmount*totalSplits));
                return new EqualExpense(amount, payer, splits);
            default:
                return null;
        }
    }
}

