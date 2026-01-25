import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class StreamingServer {
    private boolean parentalControlActive;
    private ArrayList<Song> songCatalog; // List that contains all the songs
    private ArrayList<UserServer> user; // List that contains all the users
    private ServerLog log; //Logs in the server
    private ArrayList<License> activeLicenses; //List with all the active licenses
    private static int reproductions = 0; //Total of reproductions
    private static int conectedUsers = 0; //Total of users conected
    private ServerState serverState; //How is the server
    private int timePlayed = 0; //Total of time played

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
    public void userSign(UserServer u) {
        user.add(u);
        log.addLog("User signed: " + u.getName());
    }
    //Makes the login
    public boolean login(String name, String pass) throws Exception {
        if (serverState != ServerState.ACTIVE) {
            throw new Exception("Server not available");
        }
        for (UserServer u : user) {
            if (u.getName().equals(name) && u.getPassword().equals(pass)) {
                conectedUsers++;
                log.addLog("Login successful: " + name);
                return true;
            }
        }

        log.addLog("Login failed: " + name);
        return false;
    }
    //Add a song
    public void registerSong(Song s) {
        songCatalog.add(s);
       log.addLog("Song registed: " + s.getTitle());
    }
    //Search a song and check if you can heard it or not
     public void requestSong(UserServer u, Song s) throws NotLoggedException, ServerDownException, ExplicitContentException, RateLimitException {
        if (u == null) {
            throw new NotLoggedException();
        }
        if (serverState != ServerState.ACTIVE) {
            throw new ServerDownException();
        }
        if (!validateLicense()) {
            throw new ServerDownException();
        }
        if (s.isExplicit() && u.getParentalControlActive()) {
            throw new ExplicitContentException();
        }
        if (!rateLimit(u)) {
            throw new RateLimitException();
        }
        recordGlobalReproductions();
        log.addLog("Song played: " + s.getTitle() + " by " + u.getName());
     }

    //Validate license
    public boolean validateLicense() {
        return !activeLicenses.isEmpty();
    }
    //Check if the content is esplicit or not
    public boolean checkEsplicitContent(UserServer u, Song s) {
        if (s.isExplicit()) {
            log.addLog("Explicit content blocked for user: " + u.getName());
            return false;
        }
        return true;
    }
    //Generate aleatory recommended songs
    public ArrayList<Song> generateRecommendations(Song s){
        ArrayList<Song> recommendations = new ArrayList<>();
        Random r = new Random();

        if (songCatalog.isEmpty()) {
            return recommendations;
        }
        if (!recommendations.contains(s)) {
            recommendations.add(s);
        }
        log.addLog("Recommendations generated");
        return recommendations;
    }
    //Return if u can play another song
    public boolean rateLimit(UserServer u) {
        return true;
    }
    //Total of songs played
    private static void recordGlobalReproductions() {
        reproductions++;
    }
    //Stadistics report
    public String resumenEstadisticas() {
        return "Users registered: " + user.size() + "\nConnected users: " + conectedUsers + "\nSongs in catalog: " + songCatalog.size() + "\nTotal reproductions: " + reproductions;
    }
    //Generate recommendations
    public ArrayList<Song> generateRecommendations(ArrayList<Song> history) {
        ArrayList<Song> recommendations = new ArrayList<>();
        ArrayList<Song> catalog = new ArrayList<>(songCatalog);

        //Add songs of the history
        for (int i = history.size() - 1; i >= 0; i--) {
            Song s = history.get(i);
            if (!recommendations.contains(s)) {
                recommendations.add(s);
            }
        }
        catalog.sort(Comparator.comparingInt(Song::getReproductions).reversed());
        for (Song s : catalog) {
            if (!recommendations.contains(s)) {
                recommendations.add(s);
            }
            if (recommendations.size() >= 5) {
                break;
            }
        }
              log.addLog("Recommendations generated");
            return recommendations;
    }
    //Record views
    public void recordViews(Song s, int durationInSeconds) {
        reproductions++;
        timePlayed += durationInSeconds;
        s.increaseReproductions();
        log.addLog("Reproduction Registred: " + s.getTitle());
    }
    //Globals Stadistics
    public void globalStadistics() {
        Song moreListenedTo = null;
        int maxReproductions = 0;

        for (Song s : songCatalog) {
            if (s.getReproductions() > maxReproductions) {
                maxReproductions = s.getReproductions();
                moreListenedTo = s;
            }
        }
        System.out.println("------Globals Stadistics------");
        if (moreListenedTo != null) {
            System.out.println("More listened song: " + moreListenedTo.getTitle() + " (" + maxReproductions + " reproductions");
        }
        System.out.println("Number of active users: " + conectedUsers);
        System.out.println("Total time played: " + timePlayed + " seconds");
        System.out.println("Total of reproductions: " + reproductions);
        System.out.println("----------------------------------------------");
    }
    //Activate license
    public void activateLicenses(License lic) {
        if (lic == null) {
            System.out.println("Cannot activate a null license");
            return;
        }
        if (!activeLicenses.contains(lic)) {
            activeLicenses.add(lic);
            lic.setActive(true);
            log.addLog("License activated: " + lic.getCode());
            System.out.println("License active correctly: " + lic.getCode());
        } else {
            System.out.println("The license was already active" + lic.getCode());
            log.addLog("Attempt to reactivate license: " + lic.getCode());
        }
    }
    public void parentalControlActive(boolean active) {
        parentalControlActive = active;

        if (active) {
            log.addLog("Parental control ACTIVATED on the server");
            System.out.println("Parental control ACTIVATED");
        }else {
            log.addLog("Parental control DESACTIVATED on the server");
            System.out.println("Parental control DESACTIVATED");
        }
    }
}