package dao;

import entity.User;
import entity.Expense;
import java.util.List;

public interface IFinanceRepository {
    boolean createUser(User user);
    boolean deleteUser(int userId);
    boolean createExpense(Expense expense);
    boolean deleteExpense(int expenseId);
    boolean updateExpense(int userId, Expense expense);
    List<Expense> getAllExpenses(int userId);
}
