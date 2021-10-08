package main.pratha.splitExpenses;



import main.pratha.splitExpenses.model.*;
import main.pratha.splitExpenses.model.exception.InvalidInputException;
import main.pratha.splitExpenses.service.ExpenseManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws InvalidInputException {
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.addUser(new User("u1", "user1", "pratha@gmail.com", "123213234"));
        expenseManager.addUser(new User("u2", "user2", "nikita@gmail.com", "12324324"));
        expenseManager.addUser(new User("u3", "user3", "xyz@gmail.com", "324234324"));
        expenseManager.addUser(new User("u4", "user4", "abs@gmail.com", "23423423432"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            switch (commandType) {
                case "SHOW":
                    if (commands.length == 1) {
                        expenseManager.showBalances();
                    } else {
                        expenseManager.showBalance(commands[1]);
                    }
                    break;
                case "EXPENSE":
                    String paidBy = commands[1];
                    Double amount = Double.parseDouble(commands[2]);
                    int noOfUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + noOfUsers];
                    List<Split> splits = new ArrayList<>();
                    switch (expenseType) {
                        case "EQUAL":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new EqualSplit(expenseManager.userMap.get(commands[4 + i])));
                            }

                            expenseManager.addExpense(ExpenseType.EQUAL, amount, paidBy, splits);
                            break;
                        case "EXACT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new ExactSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType.EXACT, amount, paidBy, splits);
                            break;
                    }
                    break;
            }
        }
    }
}
