package app;

import dao.FinanceRepositoryImpl;
import entity.Expense;
import entity.User;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class FinanceApp {
    public static void main(String[] args) {
        FinanceRepositoryImpl repo = new FinanceRepositoryImpl();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add User\n2. Add Expense\n3. Delete User\n4. Delete Expense\n5. Update Expense\n6. View All Expenses\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // flush

            switch (choice) {
                case 1 -> {
                    System.out.print("Username: ");
                    String uname = sc.nextLine();
                    System.out.print("Password: ");
                    String pwd = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    boolean success = repo.createUser(new User(0, uname, pwd, email));
                    System.out.println(success ? "User created." : "Failed.");
                }
                case 2 -> {
                    System.out.print("User ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    System.out.print("Category ID: ");
                    int cid = sc.nextInt();
                    System.out.print("Date (yyyy-mm-dd): ");
                    Date date = Date.valueOf(sc.next());
                    sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    boolean success = repo.createExpense(new Expense(0, uid, amount, cid, date, desc));
                    System.out.println(success ? "Expense added." : "Failed.");
                }
                case 3 -> {
                    System.out.print("User ID to delete: ");
                    int id = sc.nextInt();
                    repo.deleteUser(id);
                }
                case 4 -> {
                    System.out.print("Expense ID to delete: ");
                    int id = sc.nextInt();
                    repo.deleteExpense(id);
                }
                case 5 -> {
                    System.out.print("User ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Expense ID: ");
                    int eid = sc.nextInt();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    System.out.print("Category ID: ");
                    int cid = sc.nextInt();
                    System.out.print("Date (yyyy-mm-dd): ");
                    Date date = Date.valueOf(sc.next());
                    sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    repo.updateExpense(uid, new Expense(eid, uid, amount, cid, date, desc));
                }
                case 6 -> {
                    System.out.print("User ID: ");
                    int uid = sc.nextInt();
                    List<Expense> expenses = repo.getAllExpenses(uid);
                    expenses.forEach(System.out::println);
                }
            }
        } while (choice != 0);
        sc.close();
    }
}
