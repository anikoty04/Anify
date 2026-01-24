public class StreamingClient {
    private UserServer sesion; //User with active sesion
    private Playlist playlist; //Active playlist
    private Song actualSong; //Song in play
    private PlayerState state; //State of player
    private int temporalPosition; //Actual second of the song

    //Makes the main constructor

    public StreamingClient(UserServer sesion) {
        this.sesion = sesion;
        state = PlayerState.STOP;
        temporalPosition = 0;
    }
    //Player control
    public void play(Song s) {
        actualSong = s;
        temporalPosition = 0;
        state = PlayerState.PLAYING;
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
    
}
