package dao;

import entity.User;
import entity.Expense;
import util.DBConnUtil;
import exception.UserNotFoundException;
import exception.ExpenseNotFoundException;

import java.sql.*;
import java.util.*;

public class FinanceRepositoryImpl implements IFinanceRepository {
    private Connection conn = DBConnUtil.getConnection();

    public boolean createUser(User user) {
        String sql = "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int userId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Users WHERE user_id = ?");
            ps.setInt(1, userId);
            if (ps.executeUpdate() == 0) throw new UserNotFoundException("User ID not found.");
            return true;
        } catch (SQLException | UserNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createExpense(Expense expense) {
        String sql = "INSERT INTO Expenses (user_id, amount, category_id, date, description) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, expense.getUserId());
            ps.setDouble(2, expense.getAmount());
            ps.setInt(3, expense.getCategoryId());
            ps.setDate(4, expense.getDate());
            ps.setString(5, expense.getDescription());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteExpense(int expenseId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Expenses WHERE expense_id = ?");
            ps.setInt(1, expenseId);
            if (ps.executeUpdate() == 0) throw new ExpenseNotFoundException("Expense ID not found.");
            return true;
        } catch (SQLException | ExpenseNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateExpense(int userId, Expense expense) {
        String sql = "UPDATE Expenses SET amount=?, category_id=?, date=?, description=? WHERE user_id=? AND expense_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, expense.getAmount());
            ps.setInt(2, expense.getCategoryId());
            ps.setDate(3, expense.getDate());
            ps.setString(4, expense.getDescription());
            ps.setInt(5, userId);
            ps.setInt(6, expense.getExpenseId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Expense> getAllExpenses(int userId) {
        List<Expense> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Expenses WHERE user_id = ?")) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Expense e = new Expense(
                    rs.getInt("expense_id"),
                    rs.getInt("user_id"),
                    rs.getDouble("amount"),
                    rs.getInt("category_id"),
                    rs.getDate("date"),
                    rs.getString("description")
                );
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
