import java.util.ArrayList;

public class ServerLog {
    //Declare the variables that a log can be
    private ArrayList<String> access; //When an user log in the access being signed
    private ArrayList<String> reproduction; //When an user start listening music, this time being signed
    private ArrayList<String> error; //When an error ocurred is being signed

    //Makes the empty main constructor
    public ServerLog() {
        access = new ArrayList<>();
        reproduction = new ArrayList<>();
        error = new ArrayList<>();
    }
    //Makes the main constructor with excaptions
    public ServerLog(ArrayList<String> access, ArrayList<String> reproduction, ArrayList<String> error) {
        if (access == null || access.isEmpty()) {
            throw new IllegalArgumentException("Access is required.");
        }
        if (reproduction == null || reproduction.isEmpty()) {
            throw new IllegalArgumentException("Reproduction is required.");
        }
        this.access = access;
        this.reproduction = reproduction;
        this.error = error;
    }
    public ServerLog(ArrayList<String> access, ArrayList<String> reproduction) {
        if (access == null || access.isEmpty()) {
            throw new IllegalArgumentException("Access is required.");
        }
        if (reproduction == null || reproduction.isEmpty()) {
            throw new IllegalArgumentException("Reproduction is required.");
        }
        this.access = access;
        this.reproduction = reproduction;
    }
    public ArrayList<String> getAccess() { //To get the log
        return access;
    }
    public ArrayList<String> getReproduction() { //To get the time you start listening music
        return reproduction;
    }
    public ArrayList<String> getError() { //To get the error
        return error;
    }
    public void setAccess(ArrayList<String> access) { //To change the log
        this.access = access;
    }
    public void setReproduction(ArrayList<String> reproduction) { //To change the time
        this.reproduction = reproduction;
    }
    public void setError(ArrayList<String> error) { //To change the error
        this.error = error;
    }
    //Add logs
    public void addLog(String message) {
        access.add(message);
        System.out.println("LOG: " + message);
    }
    //Show logs
    public void showLogs() {
        for (String log : access) {
            System.out.println(log);
        }
        System.out.println("----------------------");
    }

}
