public class Song {
    //Declare the variables that a song can have
    private String title;
    private String artist;
    private float duration;
    private int playback;
    private boolean explicitContent;
    //Make the main constructor with the exceptions
    public Song (String title, String artist, int duration, int playback, boolean explicitContent) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException ("A title is needed for the song");
        }
        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException ("There must be an assigned artist");
        }
        if (duration < 0) {
            throw new IllegalArgumentException("The duration cant be negative");
        }
        if (playback < 0) {
            throw new IllegalArgumentException("The playback cannot be negative");
        }
        this.artist = artist;
        this.title = title;
        this.playback = playback;
        this.duration = duration;
        this.explicitContent = explicitContent;
    }
}