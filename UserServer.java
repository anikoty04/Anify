public class UserServer {
    private String name;
    private String password;
    private UserRole role;
    private boolean active;

    public UserServer (String name, String password) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null");
        }
    }
}
