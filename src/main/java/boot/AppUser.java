package boot;

public class AppUser {
    private String username;
    private String password;

    public AppUser() {
    }

    public AppUser(String username) {
        this.username = username;
    }

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getter needed for JSON
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
