public class UserServer {
    //Declare the variables that a user can have
    private String name;
    private String password;
    private UserRole role;
    private boolean active;

    //Makes the main constructor with exceptions

    public UserServer (String name, String password) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        if (password == null || password.isBlank()) { // Password needs to have at least a capital letter, a number , a special character and be at least 8 characters long
            throw new IllegalArgumentException("Password cannot be null");
        }
        role = UserRole.STANDART;
        active = false;
    }
    //Make getters and setters
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public UserRole getRole() {
        return role;
    }
    public boolean getActive() {
        return active;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    

}
