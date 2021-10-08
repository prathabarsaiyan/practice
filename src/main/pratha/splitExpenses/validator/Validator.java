package main.pratha.splitExpenses.validator;

import main.pratha.splitExpenses.model.ExpenseType;
import main.pratha.splitExpenses.model.User;
import main.pratha.splitExpenses.model.exception.InvalidInputException;

public class Validator {
    public static void validateExpense(ExpenseType expenseType, double amount, User payer) throws InvalidInputException {
        if (expenseType == null || payer == null) {
            throw new InvalidInputException("Expense Type or payer cannot be null");
        }
        if (amount == 0.0) {
            throw new InvalidInputException("Amount cannot be 0");
        }
    }

//    public static void validateExactExpense(List<User> sharer, List<Split>  splits) throws InvalidInputException {
//        if(sharer == null || splits == null){
//            throw new InvalidInputException("sharer list or splits cannot be null");
//        }
//
//        if(sharer.size() != splits.size()){
//            throw new InvalidInputException("sharer list and splits length should be same for exact expense");
//        }
//    }
//
//    public static void validateEqualExpense(List<User> sharer, List<Split> splits) throws InvalidInputException {
//        if(sharer == null){
//            throw new InvalidInputException("sharer list cannot be null");
//        }
//
//        if(splits  != null){
//            throw new InvalidInputException("splits values has to be null for equal expense type");
//        }
//    }
}
