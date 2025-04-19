package entity;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;

    public User() {}
    public User(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

   
}
