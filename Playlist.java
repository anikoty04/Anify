import java.util.ArrayList;

public class Playlist {
    private String name;
    private boolean collaborative; //Collaborative mode
    private ArrayList<Song> songs; //List of songs
    

    //Makes the empty main constructor
    public Playlist() {
        name = " ";
    }

    //Makes the main constructor
    public Playlist(String name, boolean collaborative) {
        this.name = name;
        this.collaborative = collaborative;
        songs = new ArrayList<>();
    }
    //Makes getters and setters
    public String name() { //To get the name
        return name;
    }
    public boolean collaborative() { //To get if it´s collaborative or not
        return collaborative;
    }
    public ArrayList<Song> songs() { //To get a list of songs
        return songs;
    }
    public void setName(String name) { //To change the name
        this.name = name;
    }
    public void setCollaborative(boolean collaborative) { //To change if it´s collaborative or not
        this.collaborative = collaborative;
    }
    public void setSongs(ArrayList<Song> songs) { //To change the list of songs
        this.songs = songs;
    }
    
}
