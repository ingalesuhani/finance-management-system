package test;

import dao.FinanceRepositoryImpl;
import entity.User;
import entity.Expense;
import org.junit.jupiter.api.*;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

public class FinanceRepositoryTest {
    private static FinanceRepositoryImpl repo;

    @BeforeAll
    public static void init() {
        repo = new FinanceRepositoryImpl();
    }

    @Test
    public void testCreateUser() {
        User user = new User(0, "testuser", "pass123", "test@example.com");
        assertTrue(repo.createUser(user));
    }

    @Test
    public void testCreateExpense() {
        Expense expense = new Expense(0, 1, 200.0, 1, Date.valueOf("2024-01-10"), "Lunch");
        assertTrue(repo.createExpense(expense));
    }

    @Test
    public void testGetAllExpenses() {
        assertNotNull(repo.getAllExpenses(1));
    }

    @Test
    public void testDeleteNonExistentExpense() {
        assertFalse(repo.deleteExpense(99999)); // assuming this doesn't exist
    }
}
