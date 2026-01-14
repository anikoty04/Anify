public class Song {
    //Declare the variables that a song can have

    // Correction: Need to explain what the variables will be used for
    private String title;
    // Coulde be artist , artitsts , group , band , etc
    private String artist; 
    private float duration; // Why float? 
    private int playback; // How will you use playback? Consider renaming for clarity
    private boolean explicitContent;
    //Makes the main constructor with exceptions
    
    public Song (String title, String artist, int duration, int playback, boolean explicitContent) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException ("A title is needed for the song");
        }
        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException ("There must be an assigned artist");
        }
        if (duration < 0) { // Correction: duration must not be 0 too , so change to <= 0
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        if (playback < 0) {
            throw new IllegalArgumentException("Playback cannot be negative");
        }
        this.artist = artist;
        this.title = title;
        this.playback = playback;
        this.duration = duration;
        this.explicitContent = explicitContent; 
    }

    //Getters for all the variables are needed, use try/catch if necessary
}