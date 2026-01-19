public class UserServer {
    //Declare the variables that a user can have
    private String name; //Name of the user
    private String password; //Password of the user
    private UserRole role; //Role that the user can be
    private boolean active; //Identify if the user is active or not

    //Makes the empty main constructor

    public UserServer () {
        name = " "; //default the name is empty
        password = null; //default the password is null because doesn´t exist
        role = UserRole.STANDAR; //default the role is standar
        active = false; //default the user is blocked
    }
    
    //Makes the main constructor 
    public UserServer(String name, String password) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        if (password == null || password.isBlank()) { // Password needs to have at least a capital letter, a number , a special character and be at least 8 characters long
            throw new IllegalArgumentException("Password cannot be null");
        }
        this.name = name; //The user name
        this.password = password; //The password of the user
        role = UserRole.STANDART; //default the role is standar, without privileges
        active = true; //Now the user has name and password so it´s active
        role = UserRole.STANDART;
        active = false;
    }

    //Make getters and setters
    public String getName() { //To get the name of the user
        return name;
    }
    public String getPassword() {  //To get the password of the user
        return password;
    }
    public UserRole getRole() {  //To get the role of the user, default standar
        return role;
    }
    public boolean getActive() {  //To get if the user is active or not
        return active;
    }
    public void setName(String name) {  //To change the name of the user
        this.name = name;
    }
    public void setPassword(String password) {  //To change the password of the user
        this.password = password;
    }
    public void setRole(UserRole role) {  //To change the role of the user
        this.role = role;
    }
    public void setActive(boolean active) {  //To change if the user is active or not
        this.active = active;
    }
    

}
