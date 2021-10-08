package main.pratha.splitExpenses.service;

import main.pratha.splitExpenses.model.Expense;
import main.pratha.splitExpenses.model.ExpenseType;
import main.pratha.splitExpenses.model.Split;
import main.pratha.splitExpenses.model.User;
import main.pratha.splitExpenses.model.exception.InvalidInputException;
import main.pratha.splitExpenses.validator.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    public List<Expense> expenses;
    public Map<String, User> userMap;
    public Map<String, Map<String, Double>> balanceSheet;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        userMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getName(), user);
        balanceSheet.put(user.getName(), new HashMap<>());
    }

    public void addExpense(ExpenseType expenseType, double amount, String payer, List<Split> splits) throws InvalidInputException {
        Validator.validateExpense(expenseType,amount,userMap.get(payer));
        Expense expense = ExpenseService.createExpense(expenseType, amount, userMap.get(payer), splits);
        expenses.add(expense);
        for (Split split : expense.getSplits()) {
            String paidTo = split.getUser().getName();
            Map<String, Double> balances = balanceSheet.get(payer);
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            balances = balanceSheet.get(paidTo);
            if (!balances.containsKey(payer)) {
                balances.put(payer, 0.0);
            }
            balances.put(payer, balances.get(payer) - split.getAmount());
        }
    }

    public void showBalance(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    private void printBalance(String user1, String user2, double amount) {
        String user1Name = userMap.get(user1).getName();
        String user2Name = userMap.get(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }
}