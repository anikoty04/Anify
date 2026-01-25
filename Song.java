import java.time.Duration;

public class Song {
    //Declare the variables that a song can have
    private String title; //Title of the song, we use this for know what song is
    private String artist; // Coulde be artist , artitsts , group , band , etc, we use this for know who is the creator of the song 
    private Duration duration; // Use the duration for know how long is the song, right now duration is in seconds, later we convert them into minutes and seconds.
    private int countReproductions; // Count of total reproductions the song has, use this to know how many reproductions does the song have
    private boolean explicitContent; // Identify if the song has explicit content

    //Makes the empty main constructor
    
    public Song () {
        this.artist = " "; //default we don´t know the artist
        this.title = " "; // default we don´t know the title
        this.countReproductions = 0; // defaut the song has 0 reproductions
        this.duration = Duration.ZERO; //default the song last 0:00
        this.explicitContent = false;  //default the song hasn't explicit content
    }

    //Makes the main constructor with the title and artist

    public Song (String title, String artist) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException ("A title is needed for the song");
        }
        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException ("There must be an assigned artist");
        }
        this.title = title; //we need to know the title of the song
        this.artist = artist; //We need to know the artist of the song
        countReproductions = 0; //default the song has 0 reproductions
        duration = Duration.ZERO; //default the song last 0:00
        explicitContent = false; //default the song hasn't explicit content
    }

    //Makes the main constructor with all parametres

    public Song(String title, String artist, Duration duration, boolean explicitContent) {
         if (title == null || title.isBlank()) {
            throw new IllegalArgumentException ("A title is needed for the song");
        }
        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException ("There must be an assigned artist");
        }
        if (duration.isNegative()) { 
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        if (countReproductions < 0) {
            throw new IllegalArgumentException("Playback cannot be negative");
        }
        //We need to know all the parametres
        this.title = title; 
        this.artist = artist;
        this.duration = duration;
        this.explicitContent = explicitContent;
    }
    //Getters for all the variables are needed, use try/catch if necessary
    public String getTitle() {  //To get the title of the song
        return title;
    }
    public Duration getDuration() { //To get the duration of the song
        return duration;
    }
    public int getReproductions() { //To get the total of reproductions of the song
        return countReproductions;
    }
    public boolean getExplicitContent() { // To get if the song has explicit content (true or false)
        return explicitContent;
    }
    public void setTitle(String title) { //To change the title of the song
        this.title = title;
    }
    public void setArtist(String artist) {  //To change the artist of the song
        this.artist = artist;
    }
    public void setDuration(Duration duration) {  //To change de duration of the song
        this.duration = duration;
    }
    public void setReproductions(int reproductions) {  //To change the total of reproductions
        this.countReproductions = reproductions;
    }
    public void setExplicitContent(boolean explicitContent) {  //To change if the song has explicit content
        this.explicitContent = explicitContent;
    }
    public void play() { //To count reproductions
        countReproductions++;
    }

    public boolean isExplicit() {
        return explicitContent;
    }
    //Increase reproductions
    public void increaseReproductions() {
        countReproductions++;
    }
}