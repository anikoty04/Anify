import java.util.ArrayList;

public class StreamingServer {
    private ArrayList<Song> songCatalog; // List that contains all the songs
    private ArrayList<UserServer> user; // List that contains all the users
    private ServerLog log; //Logs in the server
    private ArrayList<License> activeLicenses; //List with all the active licenses
    private static int reproductions = 0; //Total of reproductions
    private static int conectedUsers = 0; //Total of users conected
    private ServerState serverState; //How is the server

    //Makes empty main constructor

    public StreamingServer() {
        songCatalog = new ArrayList<>(); //Create an empty catalog
        user = new ArrayList<>(); //Create an empty list of users
        log = new ServerLog(); //Create new log
        activeLicenses = new ArrayList<>(); //Create a list of active licenses
        reproductions = 0; //Count the total of reproductions
        conectedUsers = 0; //Count the total of users conected
        serverState = ServerState.ACTIVE; //Default the server is active
    }

    //Makes the main constructor

    public StreamingServer(ArrayList<Song> songCatalog, ArrayList<UserServer> user, ServerLog log, ArrayList<License> activeLicenses, ServerState serverState) {
        if (this.songCatalog == null) {
            throw new IllegalArgumentException("Catalog can´t be null");
        }
        if (this.user == null) {
            throw new IllegalArgumentException("User can´t be null");
        }
        if (this.log == null) {
            throw new IllegalArgumentException("Log can´t be null");
        }
        if (this.activeLicenses == null) {
            throw new IllegalArgumentException("Licenses can´t be null");
        }
        if (serverState == null) {
            throw new IllegalArgumentException("State can´t be null");
        }
        this.songCatalog = songCatalog;
        this.user = user;
        this.log = log;
        this.activeLicenses = activeLicenses;
        this.serverState = serverState;
    }

    //Makes getters and setters

    public ArrayList<Song> getSongCatalog() {
        return songCatalog;
    }
    public ArrayList<UserServer> getUser() {
        return user;
    }
    public ServerLog getLog() {
        return log;
    }
    public ArrayList<License> getActiveLicense() {
        return activeLicenses;
    }
    public int getReproduction() {
        return reproductions;
    }
    public int getConectedUser() {
        return conectedUsers;
    }
    public ServerState serverState() {
        return serverState;
    }
    public void setSongCatalog(ArrayList<Song> songCatalog) {
        this.songCatalog = songCatalog;
    }
    public void setUser(ArrayList<UserServer> user) {
        this.user = user;
    }
    public void setLog(ServerLog log) {
        this.log = log;
    }
    public void setActiveLicense(ArrayList<License> activeLicenses) {
        this.activeLicenses = activeLicenses;
    }
    public void setServerState(ServerState serverState) {
        this.serverState = serverState;
    }

    //Makes user sign
    public void userSign() {
        
    }


}
