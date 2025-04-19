package entity;

import java.sql.Date;

public class Expense {
    private int expenseId;
    private int userId;
    private double amount;
    private int categoryId;
    private Date date;
    private String description;

    public Expense() {}
    public Expense(int expenseId, int userId, double amount, int categoryId, Date date, String description) {
        this.expenseId = expenseId;
        this.userId = userId;
        this.amount = amount;
        this.categoryId = categoryId;
        this.date = date;
        this.description = description;
    }

}
