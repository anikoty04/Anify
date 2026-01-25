import java.util.ArrayList;

public class StreamingClient {
    private UserServer sesion; //User with active sesion
    private Playlist playlist; //Active playlist
    private Song actualSong; //Song in play
    private PlayerState state; //State of player
    private int temporalPosition; //Actual second of the song
    private StreamingServer server; //Server reference
    private ArrayList<Song> history;
    //Makes the main constructor

    public StreamingClient(UserServer sesion, StreamingServer server) {
        this.sesion = sesion;
        state = PlayerState.STOP;
        temporalPosition = 0;
        this.server = server;
    }
    //Player control
    public void play(Song s) {
        try{
        server.requestSong(sesion, s);
        actualSong = s;
        temporalPosition = 0;
        state = PlayerState.PLAYING;
        } catch (NotLoggedException | ServerDownException | ExplicitContentException | RateLimitException e) {
            System.out.println(e.getMessage());
        }
    }
    public void pause() {
        if (state == PlayerState.PLAYING) {
            state = PlayerState.PAUSED;
        }
    }
    public void stop() {
        state = PlayerState.STOP;
        temporalPosition = 0;
        actualSong = null;
    }
    public void resume() {
    if (state == PlayerState.PAUSED) {
        state = PlayerState.PLAYING;
        System.out.println("Resume reproduction: " + actualSong.getTitle());
    }
}
    //Time simulation
    public void tic() {
        if (state != PlayerState.PLAYING || actualSong == null) {
            return;
        }

        temporalPosition++;

        if (temporalPosition >= actualSong.getDuration().getSeconds()) {
            stop();
        }
    }
    //Getters
    public int getTemporalPosition() {
        return temporalPosition;
    }
    public PlayerState getState() {
        return state;
    }
    public Song getActualSong() {
        return actualSong;
    }
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
    public ArrayList<Song> getHistory() {
        return history;
    }
}
